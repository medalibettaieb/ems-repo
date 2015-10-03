package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.DepartementServicesRemote;
import entities.Department;

public class TestFindDepartementById {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/ems/DepartementServices!services.interfaces.DepartementServicesRemote";
		DepartementServicesRemote proxy = (DepartementServicesRemote) context
				.lookup(jndiName);
		Department departmentFound = proxy.findDepartmentById(1);
		System.out.println(departmentFound.getEmployees().size());

	}

}
