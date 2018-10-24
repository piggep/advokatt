package se.getqte;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import se.getqte.model.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackages = "se.getqte")
@EnableAutoConfiguration
@PropertySources({@PropertySource("classpath:application.properties"), @PropertySource("classpath:auth0.properties")})
public class SpringBootMultitenantApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultitenantApplication.class, args);
		//kott();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

	public static void kott(){
		Map<String, String> settings = new HashMap<>();
		settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
		settings.put("dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
		settings.put("hibernate.connection.url", "jdbc:mysql://127.0.0.1/advok?useSSL=false");
		settings.put("hibernate.connection.username", "root");
		settings.put("hibernate.connection.password", "root");
		settings.put("hibernate.hbm2ddl.auto", "create-drop");
		settings.put("show_sql", "true");

		MetadataSources metadata = new MetadataSources(
				new StandardServiceRegistryBuilder()
						.applySettings(settings)
						.build());

		metadata.addAnnotatedClass(Errand.class);
		metadata.addAnnotatedClass(ErrandGroup.class);
		metadata.addAnnotatedClass(Client.class);
		metadata.addAnnotatedClass(ClientType.class);
		metadata.addAnnotatedClass(Expense.class);
		metadata.addAnnotatedClass(Part.class);
		metadata.addAnnotatedClass(PartRole.class);
		metadata.addAnnotatedClass(TimeEntry.class);

		SchemaExport schemaExport = new SchemaExport(
				(MetadataImplementor) metadata.buildMetadata()
		);
		schemaExport.setHaltOnError(true);
		schemaExport.setFormat(true);
		schemaExport.setDelimiter(";");
		schemaExport.setOutputFile("db-schema.sql");
		schemaExport.execute(true, false, false, true);
	}
}
