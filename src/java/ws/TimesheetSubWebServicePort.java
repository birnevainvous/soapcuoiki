/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author Admin
 */
@Path("timesheetsubwebserviceport")
public class TimesheetSubWebServicePort {

    private ws_client.TimesheetSubWebService port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TimesheetSubWebServicePort
     */
    public TimesheetSubWebServicePort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method login
     * @param arg0 resource URI parameter
     * @param arg1 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<ws_client.EmployeeModel>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("login/")
    public JAXBElement<ws_client.EmployeeModel> getLogin(@QueryParam("arg0") String arg0, @QueryParam("arg1") String arg1) {
        try {
            // Call Web Service Operation
            if (port != null) {
                ws_client.EmployeeModel result = port.login(arg0, arg1);
                return new JAXBElement<ws_client.EmployeeModel>(new QName("http//ws_client/", "employeemodel"), ws_client.EmployeeModel.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method timeSheetSubmit
     * @param arg0 resource URI parameter
     * @param arg1 resource URI parameter
     * @param arg2 resource URI parameter
     * @param arg3 resource URI parameter
     * @param arg4 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<ws_client.Timesheet>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("timesheetsubmit/")
    public JAXBElement<ws_client.Timesheet> getTimeSheetSubmit(@QueryParam("arg0") String arg0, @QueryParam("arg1") String arg1, @QueryParam("arg2") String arg2, @QueryParam("arg3") String arg3, @QueryParam("arg4")
            @DefaultValue("0") int arg4) {
        try {
            // Call Web Service Operation
            if (port != null) {
                ws_client.Timesheet result = port.timeSheetSubmit(arg0, arg1, arg2, arg3, arg4);
                return new JAXBElement<ws_client.Timesheet>(new QName("http//ws_client/", "timesheet"), ws_client.Timesheet.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private ws_client.TimesheetSubWebService getPort() {
        try {
            // Call Web Service Operation
            ws_client.TimesheetSubWebService_Service service = new ws_client.TimesheetSubWebService_Service();
            ws_client.TimesheetSubWebService p = service.getTimesheetSubWebServicePort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
