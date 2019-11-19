package edu.fundamental.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Meeting {
    String meetingId;
    Long time;
    Long durationInMin;
    List<String> participants;
    List<String> rooms;
}
