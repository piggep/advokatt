package se.getqte.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "time_entry")
public class TimeEntry extends CommonBaseModel {
    private String description;
    private Date date;
    private Double price;
    private Integer quantity;
    private Boolean isBillable;

    @ManyToOne
    private Errand errand;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
