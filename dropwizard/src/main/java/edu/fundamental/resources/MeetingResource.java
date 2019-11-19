package edu.fundamental.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import edu.fundamental.model.Meeting;
import edu.fundamental.service.MeetingService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@Slf4j
@Path("/meeting")
@Api("Meeting Resource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MeetingResource {

    @Inject
    private MeetingService meetingService;

    @GET
    @Path("/all/{employee}")
    @Timed(name = "list-all-meetings")
    @ApiOperation(value = "get call to list all meetings for an employee")
    public Response fetchContentForPage(@PathParam("employee") String employeeId) {
        return Response.status(Response.Status.OK)
                .entity(meetingService.listAllMeetings(employeeId).stream()
                        .map(Meeting::getMeetingId).collect(Collectors.toList()))
                .build();
    }
}