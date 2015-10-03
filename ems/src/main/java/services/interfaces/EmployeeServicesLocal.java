package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Employee;

@Local
public interface EmployeeServicesLocal {

	public abstract Boolean addEmployee(Employee employee);

	public abstract Employee findEmployeeById(Integer id);

	public abstract Boolean deleteEmployee(Employee employee);

	public abstract Boolean updateEmployee(Employee employee);

	public abstract List<Employee> findAllEmployees();

}