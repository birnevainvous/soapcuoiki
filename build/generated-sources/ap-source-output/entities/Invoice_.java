package entities;

import entities.Employee;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-05-11T23:24:36")
@StaticMetamodel(Invoice.class)
public class Invoice_ { 

    public static volatile SingularAttribute<Invoice, Employee> workerId;
    public static volatile SingularAttribute<Invoice, String> task;
    public static volatile SingularAttribute<Invoice, Integer> invoiceTime;
    public static volatile SingularAttribute<Invoice, Date> endDate;
    public static volatile SingularAttribute<Invoice, String> clientName;
    public static volatile SingularAttribute<Invoice, String> project;
    public static volatile SingularAttribute<Invoice, Integer> id;
    public static volatile SingularAttribute<Invoice, Date> startDate;

}