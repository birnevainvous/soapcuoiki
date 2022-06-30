/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package ws;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import com.sun.mail.imap.protocol.ID;
import entities.Employee;
import entities.History;
import entities.Invoice;
import entities.Timesheet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import models.EmployeeModel;
import models.HistoryModel;
import models.InvoiceModel;
import models.TimesheetModel;

/**
 *
 * @author Admin
 */
@WebService(serviceName = "TimesheetSubWebService")
public class TimesheetSubWebService {
    
    int idNV = 0;
    @WebMethod
    public EmployeeModel login(String username, String password){
        EmployeeModel emp = null;
         
        //Mo connection toi db
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TimesheetWSPU");
        EntityManager em = factory.createEntityManager();
        
        Query q = em.createNamedQuery("Employee.login", Employee.class);
        q.setParameter("username", username);
        q.setParameter("password", password);
        List<Employee> employeeList = q.getResultList();
        if (employeeList != null && !employeeList.isEmpty()) {
            //Dang nhap thanh cong
            Employee employee = employeeList.get(0);
            idNV = employee.getId();
            emp = new EmployeeModel(employee.getId(), employee.getUsername(), employee.getPassword(), employee.getRole(), employee.getName(), employee.getEmail());
            
            for (Timesheet timesheet : employee.getTimesheetCollection()) {
                TimesheetModel timesheetModel = new TimesheetModel(timesheet.getId(), timesheet.getStartTime(), timesheet.getEndTime(), timesheet.getTask(), timesheet.getProject(), timesheet.getTotalTime());
                emp.getTimesheetModel().add(timesheetModel);
            }
            
            for (Invoice invoice : employee.getInvoiceCollection()) {
                InvoiceModel invoiceModel = new InvoiceModel(invoice.getId(), invoice.getStartDate(), invoice.getEndDate(), invoice.getTask(), invoice.getProject(), invoice.getClientName(), invoice.getInvoiceTime());
                emp.getInvoiceModel().add(invoiceModel);
            }
            
            for (History history : employee.getHistoryCollection()) {
                HistoryModel historyModel = new HistoryModel(history.getId(), history.getStartTime(), history.getEndTime(), history.getTask(), history.getProject(), history.getTotalTime(), history.getAccept());
                emp.getHistoryModel().add(historyModel);
            }
        }
        
        return emp;
    }
   
    @WebMethod
    public String timeSheetSubmit(String startTime, String endTime, String task, String project ,int totalTime){
        EmployeeModel emp = null;
        //Mo connection toi db
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TimesheetWSPU");
        EntityManager em = factory.createEntityManager();
        int id;
        id = idNV;
        Query q = em.createNamedQuery("Employee.timesheetSubmit", Employee.class);
        q.setParameter("id", id);
        List<Employee> employeeList = q.getResultList();
        if (employeeList != null && !employeeList.isEmpty()) {
            //Lay thanh cong
            Employee employee = employeeList.get(0);
            emp = new EmployeeModel(employee.getId(), employee.getUsername(), employee.getPassword(), employee.getRole(), employee.getName(), employee.getEmail());
            
            for (Timesheet timesheet : employee.getTimesheetCollection()) {
                TimesheetModel timesheetModel = new TimesheetModel(timesheet.getId(), timesheet.getStartTime(), timesheet.getEndTime(), timesheet.getTask(), timesheet.getProject(), timesheet.getTotalTime());
                emp.getTimesheetModel().add(timesheetModel);
            }
            
            for (Invoice invoice : employee.getInvoiceCollection()) {
                InvoiceModel invoiceModel = new InvoiceModel(invoice.getId(), invoice.getStartDate(), invoice.getEndDate(), invoice.getTask(), invoice.getProject(), invoice.getClientName(), invoice.getInvoiceTime());
                emp.getInvoiceModel().add(invoiceModel);
            }
            
            for (History history : employee.getHistoryCollection()) {
                HistoryModel historyModel = new HistoryModel(history.getId(), history.getStartTime(), history.getEndTime(), history.getTask(), history.getProject(), history.getTotalTime(), history.getAccept());
                emp.getHistoryModel().add(historyModel);
            }
        }
        List<TimesheetModel> timesheetsList = emp.getTimesheetModel();
        int tongThoiGian = 0;
        for (int i = 0; i < timesheetsList.size(); i++) {
             if (task.equals(timesheetsList.get(i).getTask()) && project.equals(timesheetsList.get(i).getProject())){
                 tongThoiGian += timesheetsList.get(i).getTotalTime();
             }
        }
        tongThoiGian += totalTime;
        List<InvoiceModel> invoiceList = emp.getInvoiceModel();
        
        for(int i = 0; i < invoiceList.size(); i++){
            if (task.equals(invoiceList.get(i).getTask()) && project.equals(invoiceList.get(i).getProject()) && tongThoiGian <= invoiceList.get(i).getInvoiceTime()) {
                String dStart = startTime;
                String dEnd = endTime;
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd' 'hh:mm");
                try { 
                    
                    Date dateStart = (Date)formatter.parse(dStart);
                    Date dateEnd = (Date)formatter.parse(dEnd);
                    if((invoiceList.get(i).getStartDate().equals(dateStart) || invoiceList.get(i).getStartDate().before(dateStart)) && (invoiceList.get(i).getEndDate().equals(dateEnd) || invoiceList.get(i).getEndDate().after(dateEnd))){
                        Timesheet t = new Timesheet();
                        t.setStartTime(dateStart);
                        t.setEndTime(dateEnd);
                        t.setTask(task);
                        t.setProject(project);
                        t.setTotalTime(totalTime);
                        t.setWorkerId(employeeList.get(0));

                        History h = new History();
                        h.setStartTime(dateStart);
                        h.setEndTime(dateEnd);
                        h.setTask(task);
                        h.setProject(project);
                        h.setTotalTime(totalTime);
                        h.setAccept(Boolean.TRUE);
                        h.setWorkerId(employeeList.get(0));
                        
                        em.getTransaction().begin();
                        em.persist(t);
                        em.persist(h);
                        em.getTransaction().commit();
                        return "success";
                    }
                    else {
                        History h = new History();
                        h.setStartTime(dateStart);
                        h.setEndTime(dateEnd);
                        h.setTask(task);
                        h.setProject(project);
                        h.setTotalTime(totalTime);
                        h.setAccept(Boolean.FALSE);
                        h.setWorkerId(employeeList.get(0));
                        em.getTransaction().begin();
                        em.persist(h);
                        em.getTransaction().commit();
                        return "date wrong";
                    }
                    
                } catch (ParseException ex) {
                    Logger.getLogger(TimesheetSubWebService.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
       
        return "fail";
    }
    
    @WebMethod
    public String addInvoice(String startDate, String endDate, String task, String project, int invoiceTime,int workerId, String clientName){
        //Mo connection toi db
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TimesheetWSPU");
        EntityManager em = factory.createEntityManager();
        int id;
        id = idNV;
        Query qRole = em.createNamedQuery("Employee.findById", Employee.class);
        qRole.setParameter("id", id);
        List<Employee> employeeRoleList = qRole.getResultList();
        if (!employeeRoleList.get(0).getRole().equals("arClerk")) {
            return "Role error";
        }
        
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Query q2 = em.createNamedQuery("Employee.findById", Employee.class);
            q2.setParameter("id", workerId);
            List<Employee> workerList = q2.getResultList();
            Date dStart = (Date)formatter.parse(startDate);
            Date dEnd = (Date)formatter.parse(endDate);
            Invoice in = new Invoice();
            in.setStartDate(dStart);
            in.setEndDate(dEnd);
            in.setTask(task);
            in.setProject(project);
            in.setInvoiceTime(invoiceTime);
            in.setWorkerId(workerList.get(0));
            in.setClientName(clientName);
            em.getTransaction().begin();
            em.persist(in);
            em.getTransaction().commit();
            return "success";
        } catch (ParseException ex) {
            Logger.getLogger(TimesheetSubWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return "fail";
    }
    
    @WebMethod
    public List<Invoice> findAllInvoice(){
        //Mo connection toi db
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TimesheetWSPU");
        EntityManager em = factory.createEntityManager();
        Query q = em.createNamedQuery("Invoice.findAll", Invoice.class);
        List<Invoice> invoiceList = q.getResultList();
        return invoiceList;
    }
    
    @WebMethod
    public List<History> findHistoryByWorkerId(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TimesheetWSPU");
        EntityManager em = factory.createEntityManager();
        int id = 0;
        id = idNV;
        Query q = em.createNamedQuery("History.findByWorkerId", History.class);
        Query q2 = em.createNamedQuery("Employee.findById", Employee.class);
        q2.setParameter("id", id);
        List<Employee> employeeList = q2.getResultList();
        q.setParameter("workerId", employeeList.get(0));
        List<History> historyList = q.getResultList();
        return historyList;
    }
}
