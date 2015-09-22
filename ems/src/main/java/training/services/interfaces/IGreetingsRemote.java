package training.services.interfaces;

import javax.ejb.Remote;

@Remote
public interface IGreetingsRemote {
	String tiSallem(String name);
}
