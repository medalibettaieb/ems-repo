package delegate;

import locator.ServiceLocator;
import services.interfaces.LeavesManagementRemote;
import entities.Leave;
import entities.User;

public class LeavesManagementDelegate {
	public static final String jndiName = "/ems/LeavesManagement!services.interfaces.LeavesManagementRemote";

	public static LeavesManagementRemote getProxy() {
		return (LeavesManagementRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void doRequestLeave(Leave leave, User user) {
		getProxy().requestLeave(user, leave);
	}
}