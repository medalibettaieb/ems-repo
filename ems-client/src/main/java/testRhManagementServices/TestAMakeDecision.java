package testRhManagementServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.RhManagementServicesRemote;
import entities.StateEnum;

public class TestAMakeDecision {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		String jndiName = "/ems/RhManagementServices!services.interfaces.RhManagementServicesRemote";
		RhManagementServicesRemote proxy = (RhManagementServicesRemote) context
				.lookup(jndiName);

		System.out.println(proxy.makeDecision(3, 1, StateEnum.INPROGRESS));
	}

}
