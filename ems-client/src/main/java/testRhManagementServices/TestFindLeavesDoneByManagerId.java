package testRhManagementServices;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.LeavesManagementRemote;
import entities.Leave;

public class TestFindLeavesDoneByManagerId {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		String jndiName = "/ems/LeavesManagement!services.interfaces.LeavesManagementRemote";
		LeavesManagementRemote proxy = (LeavesManagementRemote) context
				.lookup(jndiName);

		List<Leave> leaves = proxy.findLeavesDoneByManagerId(3);
		for (Leave l : leaves) {
			System.out.println(l.getStartDate());
			System.out.println(l.getDuration());
			System.out.println(l.getLeaveRequestor().getName());
		}

	}

}
