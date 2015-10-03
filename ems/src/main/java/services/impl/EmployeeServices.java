package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.EmployeeServicesLocal;
import services.interfaces.EmployeeServicesRemote;
import entities.Employee;

/**
 * Session Bean implementation class EmployeeServices
 */
@Stateless
public class EmployeeServices implements EmployeeServicesRemote,
		EmployeeServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public EmployeeServices() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see services.impl.EmployeeServicesLocal#addEmployee(entities.Employee)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.impl.EmployeeServicesLocal#findEmployeeById(java.lang.Integer)
	 */
	@Override
	public Employee findEmployeeById(Integer id) {
		return entityManager.find(Employee.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.impl.EmployeeServicesLocal#deleteEmployee(entities.Employee)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * services.impl.EmployeeServicesLocal#updateEmployee(entities.Employee)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see services.impl.EmployeeServicesLocal#findAllEmployees()
	 */
	@Override
	public List<Employee> findAllEmployees() {
		String jpql = "select e from Employee e ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
