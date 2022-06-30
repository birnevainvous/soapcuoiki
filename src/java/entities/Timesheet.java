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
@Table(name = "timesheet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timesheet.findAll", query = "SELECT t FROM Timesheet t"),
    @NamedQuery(name = "Timesheet.findById", query = "SELECT t FROM Timesheet t WHERE t.id = :id"),
    @NamedQuery(name = "Timesheet.findByStartTime", query = "SELECT t FROM Timesheet t WHERE t.startTime = :startTime"),
    @NamedQuery(name = "Timesheet.findByEndTime", query = "SELECT t FROM Timesheet t WHERE t.endTime = :endTime"),
    @NamedQuery(name = "Timesheet.findByTask", query = "SELECT t FROM Timesheet t WHERE t.task = :task"),
    @NamedQuery(name = "Timesheet.findByProject", query = "SELECT t FROM Timesheet t WHERE t.project = :project"),
    @NamedQuery(name = "Timesheet.findByTotalTime", query = "SELECT t FROM Timesheet t WHERE t.totalTime = :totalTime")})
public class Timesheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "startTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "endTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Size(max = 50)
    @Column(name = "task")
    private String task;
    @Size(max = 50)
    @Column(name = "project")
    private String project;
    @Column(name = "totalTime")
    private Integer totalTime;
    @JoinColumn(name = "workerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee workerId;

    public Timesheet() {
    }

    public Timesheet(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
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
        if (!(object instanceof Timesheet)) {
            return false;
        }
        Timesheet other = (Timesheet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Timesheet[ id=" + id + " ]";
    }
    
}
