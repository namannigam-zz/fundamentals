package edu.fundamental.store;

import edu.fundamental.dao.InviteDao;
import edu.fundamental.model.Invite;

public class InviteStore implements InviteDao {

    @Override
    public String createInvite(Invite invite) {
        return invite.getInviteId();
    }
}