package testRhManagementServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.RhManagementServicesRemote;

public class TestAMakeDecision {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		String jndiName = "/ems/RhManagementServices!services.interfaces.RhManagementServicesRemote";
		RhManagementServicesRemote proxy = (RhManagementServicesRemote) context
				.lookup(jndiName);

		System.out.println(proxy.makeDecision(3, 1, "ahhh .... tfadlek ????"));
	}

}
