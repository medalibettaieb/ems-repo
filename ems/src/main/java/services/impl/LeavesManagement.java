package services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.LeavesManagementLocal;
import services.interfaces.LeavesManagementRemote;
import entities.Leave;
import entities.User;

/**
 * Session Bean implementation class LeavesManagement
 */
@Stateless
public class LeavesManagement implements LeavesManagementRemote,
		LeavesManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public LeavesManagement() {
	}

	@Override
	public Boolean requestLeave(User user, Leave leave) {
		Boolean b = false;
		try {
			leave.setLeaveRequestor(user);
			entityManager.merge(leave);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

}
