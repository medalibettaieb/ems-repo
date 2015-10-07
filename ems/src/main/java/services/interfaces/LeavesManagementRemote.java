package services.interfaces;

import javax.ejb.Remote;

import entities.Leave;
import entities.User;

@Remote
public interface LeavesManagementRemote {
	Boolean requestLeave(User user, Leave leave);

}
