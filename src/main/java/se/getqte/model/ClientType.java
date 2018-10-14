package se.getqte.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client_type")
public class ClientType extends CommonBaseModel{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
