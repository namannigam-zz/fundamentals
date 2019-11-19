package edu.fundamental.calendar.service;

import edu.fundamental.calendar.model.Meeting;

import java.util.List;
import java.util.Set;

public interface MeetingService {

    List<Meeting> listAllMeetings(String employeeId);

    boolean addMeetingRoom(String meetingId, String roomId);

    String createMeeting(Set<String> employeeIds, long meetingTime, long duration, String roomId);
}