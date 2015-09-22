package services.interfaces;

import javax.ejb.Remote;

import entities.Employee;

@Remote
public interface EmployeeServicesRemote {
	Boolean addEmployee(Employee employee);
}
