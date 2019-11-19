package edu.fundamental.calendar.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import edu.fundamental.calendar.model.Employee;
import edu.fundamental.calendar.request.AddEmployeeRequest;
import edu.fundamental.calendar.service.ManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/manage")
@Api("Management Resource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ManagementResource {

    @Inject
    private ManagementService managementService;

    @POST
    @Path("/employee/add")
    @Timed(name = "add-employee")
    @ApiOperation(value = "Adds an employee with details such as name and id.")
    public Response addEmployee(@ApiParam @NotNull @Valid AddEmployeeRequest addEmployeeRequest) {
        managementService.addEmployee(Employee.builder()
                .empId(addEmployeeRequest.getEmployeeId())
                .name(addEmployeeRequest.getEmployeeName())
                .build());
        return Response.status(Response.Status.OK).build();
    }
}