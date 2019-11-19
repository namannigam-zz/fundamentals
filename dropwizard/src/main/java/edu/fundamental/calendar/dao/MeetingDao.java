package edu.fundamental.calendar.dao;

import edu.fundamental.calendar.model.Meeting;

import java.util.List;

public interface MeetingDao {

    List<Meeting> findAllMeeting(String employeeId);

    boolean createMeeting(Meeting meeting);
}
