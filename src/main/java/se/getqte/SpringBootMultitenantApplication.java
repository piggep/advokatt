package se.getqte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@ComponentScan(basePackages = "se.getqte")
@EnableAutoConfiguration
@PropertySources({@PropertySource("classpath:application.properties"), @PropertySource("classpath:auth0.properties")})
public class SpringBootMultitenantApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultitenantApplication.class, args);
	}
}
