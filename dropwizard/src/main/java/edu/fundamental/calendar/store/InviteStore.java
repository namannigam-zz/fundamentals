package edu.fundamental.calendar.store;

import edu.fundamental.calendar.dao.InviteDao;
import edu.fundamental.calendar.model.Invite;

public class InviteStore implements InviteDao {

    @Override
    public String createInvite(Invite invite) {
        return invite.getInviteId();
    }
}