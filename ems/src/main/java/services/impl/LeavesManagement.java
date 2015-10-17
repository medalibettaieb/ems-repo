package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Leave> findLeavesDoneByManagerId(Integer id) {
		String jpql = "select l from Leave l join l.decisions ds where ds.user.id=:idUser";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("idUser", id);
		return query.getResultList();
	}

}
