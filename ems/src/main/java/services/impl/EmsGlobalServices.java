package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.DepartementServicesLocal;
import services.interfaces.EmployeeServicesLocal;
import services.interfaces.EmsGlobalServicesLocal;
import services.interfaces.EmsGlobalServicesRemote;
import entities.Department;
import entities.Employee;

/**
 * Session Bean implementation class EmsGlobalServices
 */
@Stateless
public class EmsGlobalServices implements EmsGlobalServicesRemote,
		EmsGlobalServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private EmployeeServicesLocal employeeServicesLocal;
	@EJB
	private DepartementServicesLocal departementServicesLocal;

	/**
	 * Default constructor.
	 */
	public EmsGlobalServices() {
	}

	@Override
	public Boolean assignEmployeeToDepartementMasterSide(Integer idEmployee,
			Integer idDepartement) {
		Boolean b = false;
		try {
			Employee employeeFound = employeeServicesLocal
					.findEmployeeById(idEmployee);
			Department departmentFound = departementServicesLocal
					.findDepartmentById(idDepartement);

			employeeFound.setDepartment(departmentFound);

			entityManager.merge(employeeFound);
			b = true;
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
	}

	@Override
	public Boolean assignEmployeeToDepartementSlaveSide(Integer idEmployee,
			Integer idDepartement) {
		Boolean b = false;
		try {
			Employee employeeFound = employeeServicesLocal
					.findEmployeeById(idEmployee);
			Department departmentFound = departementServicesLocal
					.findDepartmentById(idDepartement);

			List<Employee> employees = new ArrayList<>();
			employees.add(employeeFound);

			departmentFound.linkEmployeesToThisDepartement(employees);

			entityManager.merge(departmentFound);
			b = true;
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findEmployeesByDepartementId(Integer id) {
		String jpql = "select e from Employee e where e.department.id=:param1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", id);

		return query.getResultList();
	}

}
