package se.getqte.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "part_role")
public class PartRole extends CommonBaseModel {

    private String name;


}
