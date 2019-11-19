package edu.fundamental.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import edu.fundamental.request.InviteRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import edu.fundamental.service.InviteService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/invite")
@Api("Invite Resource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InviteResource {

    @Inject
    private InviteService inviteService;

    @POST
    @Path("/add")
    @Timed(name = "add-employee")
    @ApiOperation(value = "Adds an employee with details such as name and id.")
    public Response createInvite(@ApiParam @NotNull @Valid InviteRequest inviteRequest) {
        inviteService.createInvite(inviteRequest.getEmployeeIds());
        return Response.status(Response.Status.OK).build();
    }
}