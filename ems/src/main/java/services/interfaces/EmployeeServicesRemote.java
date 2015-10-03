package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Employee;

@Remote
public interface EmployeeServicesRemote {
	Boolean addEmployee(Employee employee);

	Employee findEmployeeById(Integer id);

	Boolean deleteEmployee(Employee employee);

	Boolean updateEmployee(Employee employee);

	List<Employee> findAllEmployees();

}
