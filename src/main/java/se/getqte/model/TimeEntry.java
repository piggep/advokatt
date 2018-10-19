package se.getqte.model;

import javax.persistence.Column;
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

    @Column(name = "is_billable")
    private Boolean isBillable;

    @ManyToOne
    private Errand errand;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getBillable() {
        return isBillable;
    }

    public void setBillable(Boolean billable) {
        isBillable = billable;
    }

    public Errand getErrand() {
        return errand;
    }

    public void setErrand(Errand errand) {
        this.errand = errand;
    }
}
