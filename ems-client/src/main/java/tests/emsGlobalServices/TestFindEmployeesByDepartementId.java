package tests.emsGlobalServices;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.EmsGlobalServicesRemote;
import entities.Employee;

public class TestFindEmployeesByDepartementId {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/ems/EmsGlobalServices!services.interfaces.EmsGlobalServicesRemote";
		EmsGlobalServicesRemote emsGlobalServicesRemote = (EmsGlobalServicesRemote) context
				.lookup(jndiName);

		List<Employee> employees = emsGlobalServicesRemote
				.findEmployeesByDepartementId(1);
		for (Employee e : employees) {
			System.out.println(e.getName());
		}
	}

}
