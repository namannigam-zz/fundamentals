package edu.fundamental.provider;

import com.google.inject.Inject;
import edu.fundamental.dao.MeetingDao;
import edu.fundamental.model.Meeting;
import edu.fundamental.service.MeetingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MeetingServiceProvider implements MeetingService {

    @Inject
    MeetingDao meetingDao;

    @Override
    public List<Meeting> listAllMeetings(String employeeId) {
        return meetingDao.findAllMeeting(employeeId);
    }

    @Override
    public boolean addMeetingRoom(String meetingId, String roomId) {
        return false;
    }


    @Override
    public String createMeeting(Set<String> employeeIds, long meetingTime, long duration, String roomId) {
        meetingDao.createMeeting(Meeting.builder()
                .meetingId("meeting1")
                .participants(new ArrayList<>(employeeIds))
                .time(0L)
                .durationInMin(100L)
                .build());
        return "";
    }
}
