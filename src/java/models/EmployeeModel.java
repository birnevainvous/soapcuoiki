/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class EmployeeModel {
    int id;
    String username, password, role, name, email;
    
    List<TimesheetModel> timesheetModel;
    List<InvoiceModel> invoiceModel;
    List<HistoryModel> historyModel;

    public EmployeeModel(int id ,String username, String password, String role, String name, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        
        timesheetModel = new ArrayList<>();
        invoiceModel = new ArrayList<>();
        historyModel = new ArrayList<>();
    }

    public EmployeeModel() {
        timesheetModel = new ArrayList<>();
        invoiceModel = new ArrayList<>();
        historyModel = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TimesheetModel> getTimesheetModel() {
        return timesheetModel;
    }

    public void setTimesheetModel(List<TimesheetModel> timesheetModel) {
        this.timesheetModel = timesheetModel;
    }

    public List<InvoiceModel> getInvoiceModel() {
        return invoiceModel;
    }

    public void setInvoiceModel(List<InvoiceModel> invoiceModel) {
        this.invoiceModel = invoiceModel;
    }

    public List<HistoryModel> getHistoryModel() {
        return historyModel;
    }

    public void setHistoryModel(List<HistoryModel> historyModel) {
        this.historyModel = historyModel;
    }
    
}
