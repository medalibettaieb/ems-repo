package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.DepartementServicesLocal;
import services.interfaces.DepartementServicesRemote;
import entities.Department;

/**
 * Session Bean implementation class DepartementServices
 */
@Stateless
public class DepartementServices implements DepartementServicesRemote, DepartementServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public DepartementServices() {
	}

	/* (non-Javadoc)
	 * @see services.impl.DepartementServicesLocal#addDepartement(entities.Department)
	 */
	@Override
	public Boolean addDepartement(Department department) {
		Boolean b = false;
		try {
			entityManager.persist(department);
			b = true;
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
	}

	/* (non-Javadoc)
	 * @see services.impl.DepartementServicesLocal#deleteDepartement(java.lang.Integer)
	 */
	@Override
	public Boolean deleteDepartement(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findDepartmentById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
	}

	/* (non-Javadoc)
	 * @see services.impl.DepartementServicesLocal#updateDepartement(entities.Department)
	 */
	@Override
	public Boolean updateDepartement(Department department) {
		Boolean b = false;
		try {
			entityManager.merge(department);
			b = true;
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
	}

	/* (non-Javadoc)
	 * @see services.impl.DepartementServicesLocal#findDepartmentById(java.lang.Integer)
	 */
	@Override
	public Department findDepartmentById(Integer id) {
		return entityManager.find(Department.class, id);
	}

	/* (non-Javadoc)
	 * @see services.impl.DepartementServicesLocal#findAllDepartments()
	 */
	@Override
	public List<Department> findAllDepartments() {
		return entityManager.createQuery("select d from Departement d")
				.getResultList();
	}

}