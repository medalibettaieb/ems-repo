package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.EmployeeServicesRemote;
import entities.Employee;

public class TestUpdateEmployee {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/ems/EmployeeServices!services.interfaces.EmployeeServicesRemote";
		EmployeeServicesRemote proxy = (EmployeeServicesRemote) context
				.lookup(jndiName);

		Employee employeeFound = proxy.findEmployeeById(1);

		employeeFound.setName("new look");

		System.out.println(proxy.updateEmployee(employeeFound));
	}

}
