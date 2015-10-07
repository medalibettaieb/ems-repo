package services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.RhManagementServicesLocal;
import services.interfaces.RhManagementServicesRemote;
import entities.Decision;
import entities.Leave;
import entities.RhManager;
import entities.User;

/**
 * Session Bean implementation class RhManagementServices
 */
@Stateless
public class RhManagementServices implements RhManagementServicesRemote,
		RhManagementServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public RhManagementServices() {
	}

	@Override
	public Boolean addUser(User user) {
		Boolean b = false;
		try {
			entityManager.persist(user);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public User login(String login, String password) {
		User userLoggedIn = null;
		String jpql = "select u From User u where u.login=:param1 and u.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			userLoggedIn = (User) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("you are not authorized");
		}
		return userLoggedIn;
	}

	@Override
	public Boolean makeDecision(Integer idManager, Integer idLeave, String state) {
		Boolean b = false;
		try {
			RhManager managerFound = entityManager.find(RhManager.class,
					idManager);
			Leave leaveFound = entityManager.find(Leave.class, idLeave);
			if (idManager != leaveFound.getLeaveRequestor().getId()) {
				Decision decision = new Decision(state, managerFound,
						leaveFound);
				entityManager.persist(decision);
			} else {
				Decision decision = new Decision("7ram", managerFound,
						leaveFound);
				entityManager.persist(decision);
			}
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

}
