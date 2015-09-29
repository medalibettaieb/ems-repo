package services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.EmployeeServicesRemote;
import entities.Employee;

/**
 * Session Bean implementation class EmployeeServices
 */
@Stateless
public class EmployeeServices implements EmployeeServicesRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public EmployeeServices() {
	}

	@Override
	public Boolean addEmployee(Employee employee) {
		Boolean b = false;
		try {
			entityManager.persist(employee);
			b = true;
		} catch (Exception e) {
			System.err.println("problem adding employee");
		}
		return b;
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public Boolean deleteEmployee(Employee employee) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(employee));
			b = true;
		} catch (Exception e) {
			System.err.println("problem deleting employee");
		}
		return b;
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		Boolean b = false;
		try {
			entityManager.merge(employee);
			b = true;
		} catch (Exception e) {
			System.err.println("problem deleting employee");
		}
		return b;
	}

}
