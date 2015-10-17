package testRhManagementServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.RhManagementServicesRemote;
import entities.Employee;
import entities.RhManager;

public class TestAddUser {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		String jndiName = "/ems/RhManagementServices!services.interfaces.RhManagementServicesRemote";
		RhManagementServicesRemote proxy = (RhManagementServicesRemote) context
				.lookup(jndiName);

		Employee employee = new Employee();
		employee.setName("foulen");
		employee.setCnss("123MT");
		employee.setLogin("f1");
		employee.setPassword("f1");

		Employee employee2 = new Employee();
		employee2.setName("foulena");
		employee2.setCnss("123FT");
		employee2.setLogin("f2");
		employee2.setPassword("f2");

		RhManager rhManager = new RhManager();
		rhManager.setName("sidi Ali");
		rhManager.setExperience("6 months");
		rhManager.setLogin("admin");
		rhManager.setPassword("admin");

		System.out.println(proxy.addUser(employee));
		System.out.println(proxy.addUser(employee2));
		System.out.println(proxy.addUser(rhManager));
	}
}
