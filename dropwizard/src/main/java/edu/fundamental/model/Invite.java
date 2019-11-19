package edu.fundamental.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Invite {
    String inviteId;
    String meetingId;
    Set<String> employeeIds;
}