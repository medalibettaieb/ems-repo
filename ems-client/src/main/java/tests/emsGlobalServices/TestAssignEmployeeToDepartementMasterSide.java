package tests.emsGlobalServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.EmsGlobalServicesRemote;

public class TestAssignEmployeeToDepartementMasterSide {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/ems/EmsGlobalServices!services.interfaces.EmsGlobalServicesRemote";
		EmsGlobalServicesRemote emsGlobalServicesRemote = (EmsGlobalServicesRemote) context
				.lookup(jndiName);

		System.out.println(emsGlobalServicesRemote
				.assignEmployeeToDepartementMasterSide(3, 1));
		System.out.println(emsGlobalServicesRemote
				.assignEmployeeToDepartementMasterSide(4, 1));
	}

}
