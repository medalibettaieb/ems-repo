package services.util;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Department;
import entities.Employee;

/**
 * Session Bean implementation class PopulateDB
 */
@Singleton
@LocalBean
@Startup
public class PopulateDB {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public PopulateDB() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDB() {
		Employee employee = new Employee("ahmed");
		Employee employee2 = new Employee("salah");
		Employee employee3 = new Employee("ali");
		Employee employee4 = new Employee("samiha");

		Department department = new Department("IT", "IT departement ");
		Department department2 = new Department("Managemnt",
				"Management departement ");

		entityManager.persist(employee);
		entityManager.persist(employee2);
		entityManager.persist(employee3);
		entityManager.persist(employee4);

		entityManager.persist(department);
		entityManager.persist(department2);
		
		

	}

}
