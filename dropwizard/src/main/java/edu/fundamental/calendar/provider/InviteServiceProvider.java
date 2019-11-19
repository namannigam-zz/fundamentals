package edu.fundamental.calendar.provider;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import edu.fundamental.calendar.dao.InviteDao;
import edu.fundamental.calendar.service.InviteService;

import java.util.Set;
import java.util.UUID;

@Slf4j
public class InviteServiceProvider implements InviteService {

    @Inject
    private InviteDao inviteDao;

    @Override
    public String createInvite(Set<String> employeeIds) {
        log.info("Invite created successfully!");
        return UUID.randomUUID().toString();
    }
}