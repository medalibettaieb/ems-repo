package testRhManagementServices;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.LeavesManagementRemote;
import entities.Employee;
import entities.Leave;
import entities.RhManager;

public class TestRequestLeave {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		String jndiName = "/ems/LeavesManagement!services.interfaces.LeavesManagementRemote";
		LeavesManagementRemote proxy = (LeavesManagementRemote) context
				.lookup(jndiName);

		Employee employee = new Employee();
		employee.setName("falten");
		employee.setCnss("123MT");
		employee.setLogin("falten1");
		employee.setPassword("falten1");

		Leave leave = new Leave(new Date(), 4D, "vacation");
		
		System.out.println(proxy.requestLeave(employee, leave));

	

	}

}
