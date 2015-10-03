package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.EmployeeServicesRemote;
import entities.Department;
import entities.Employee;

public class TestAddEmployee {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/ems/EmployeeServices!services.interfaces.EmployeeServicesRemote";
		EmployeeServicesRemote proxy = (EmployeeServicesRemote) context
				.lookup(jndiName);

		Employee employee = new Employee();
		employee.setName("foulen");

		Department department = new Department("fla7a", "emmm");

		employee.setDepartment(department);

		System.out.println(proxy.addEmployee(employee));
	}

}
