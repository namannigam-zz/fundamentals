package edu.fundamental.dao;

import edu.fundamental.model.Meeting;

import java.util.List;

public interface MeetingDao {

    List<Meeting> findAllMeeting(String employeeId);

    boolean createMeeting(Meeting meeting);
}
