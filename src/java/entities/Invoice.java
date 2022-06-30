/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findById", query = "SELECT i FROM Invoice i WHERE i.id = :id"),
    @NamedQuery(name = "Invoice.findByStartDate", query = "SELECT i FROM Invoice i WHERE i.startDate = :startDate"),
    @NamedQuery(name = "Invoice.findByEndDate", query = "SELECT i FROM Invoice i WHERE i.endDate = :endDate"),
    @NamedQuery(name = "Invoice.findByTask", query = "SELECT i FROM Invoice i WHERE i.task = :task"),
    @NamedQuery(name = "Invoice.findByProject", query = "SELECT i FROM Invoice i WHERE i.project = :project"),
    @NamedQuery(name = "Invoice.findByInvoiceTime", query = "SELECT i FROM Invoice i WHERE i.invoiceTime = :invoiceTime"),
    @NamedQuery(name = "Invoice.findByClientName", query = "SELECT i FROM Invoice i WHERE i.clientName = :clientName")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 50)
    @Column(name = "task")
    private String task;
    @Size(max = 50)
    @Column(name = "project")
    private String project;
    @Column(name = "invoiceTime")
    private Integer invoiceTime;
    @Size(max = 50)
    @Column(name = "clientName")
    private String clientName;
    @JoinColumn(name = "workerId", referencedColumnName = "id")
    @ManyToOne
    private Employee workerId;

    public Invoice() {
    }

    public Invoice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Integer getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(Integer invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Employee getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Employee workerId) {
        this.workerId = workerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Invoice[ id=" + id + " ]";
    }
    
}
