package testRhManagementServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.RhManagementServicesRemote;
import entities.Employee;
import entities.RhManager;
import entities.User;

public class TestLogin {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		String jndiName = "/ems/RhManagementServices!services.interfaces.RhManagementServicesRemote";
		RhManagementServicesRemote proxy = (RhManagementServicesRemote) context
				.lookup(jndiName);

		User userLoggedIn = proxy.login("", "");
		if (userLoggedIn instanceof Employee) {
			System.out.println("u are a simple employee");
		} else if (userLoggedIn instanceof RhManager) {
			System.out.println("welcoooome si eSir");
		} else {
			System.out.println("rawa7 ...");
		}
	}
}
