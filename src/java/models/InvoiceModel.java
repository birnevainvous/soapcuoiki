/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class InvoiceModel {
    int id;
    Date startDate, endDate;
    String task, project, clientName;
    int invoiceTime;

    public InvoiceModel() {
    }

    public InvoiceModel(int id, Date startDate, Date endDate, String task, String project, String clientName, int invoiceTime) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.task = task;
        this.project = project;
        this.clientName = clientName;
        this.invoiceTime = invoiceTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(int invoiceTime) {
        this.invoiceTime = invoiceTime;
    }
    
}
