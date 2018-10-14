package se.getqte.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "errand_group")
public class ErrandGroup extends CommonBaseModel{

    private String name;
}
