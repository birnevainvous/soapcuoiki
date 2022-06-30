package entities;

import entities.History;
import entities.Invoice;
import entities.Timesheet;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-05-11T23:24:36")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> password;
    public static volatile CollectionAttribute<Employee, Invoice> invoiceCollection;
    public static volatile SingularAttribute<Employee, String> role;
    public static volatile CollectionAttribute<Employee, History> historyCollection;
    public static volatile CollectionAttribute<Employee, Timesheet> timesheetCollection;
    public static volatile SingularAttribute<Employee, String> name;
    public static volatile SingularAttribute<Employee, Integer> id;
    public static volatile SingularAttribute<Employee, String> email;
    public static volatile SingularAttribute<Employee, String> username;

}