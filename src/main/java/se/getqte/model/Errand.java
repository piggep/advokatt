package se.getqte.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "errand")
public class Errand extends CommonBaseModel {

    private String errandNr;
    private Date startDate;
    private String reference;
    private String objectiveNr;
    private Boolean internal;
    private Boolean billable;
    private Boolean active;
    private String archiveNr;
    private Date endDate;
    private String endNote;
    private String errandNote;

    @ManyToOne
    private Client client;

    @ManyToOne
    private ErrandGroup errandGroup;


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ErrandGroup getErrandGroup() {
        return errandGroup;
    }

    public void setErrandGroup(ErrandGroup errandGroup) {
        this.errandGroup = errandGroup;
    }

    public String getErrandNr() {
        return errandNr;
    }

    public void setErrandNr(String errandNr) {
        this.errandNr = errandNr;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getObjectiveNr() {
        return objectiveNr;
    }

    public void setObjectiveNr(String objectiveNr) {
        this.objectiveNr = objectiveNr;
    }

    public Boolean getInternal() {
        return internal;
    }

    public void setInternal(Boolean internal) {
        this.internal = internal;
    }

    public Boolean getBillable() {
        return billable;
    }

    public void setBillable(Boolean billable) {
        this.billable = billable;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getArchiveNr() {
        return archiveNr;
    }

    public void setArchiveNr(String archiveNr) {
        this.archiveNr = archiveNr;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEndNote() {
        return endNote;
    }

    public void setEndNote(String endNote) {
        this.endNote = endNote;
    }

    public String getErrandNote() {
        return errandNote;
    }

    public void setErrandNote(String errandNote) {
        this.errandNote = errandNote;
    }





}
