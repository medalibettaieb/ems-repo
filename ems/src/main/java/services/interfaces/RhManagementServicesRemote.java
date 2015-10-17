package services.interfaces;

import javax.ejb.Remote;

import entities.StateEnum;
import entities.User;

@Remote
public interface RhManagementServicesRemote {
	Boolean addUser(User user);

	User login(String login, String password);

	Boolean makeDecision(Integer idManager, Integer idLeave, StateEnum state);

}
