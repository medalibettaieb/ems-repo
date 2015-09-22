package training.services.interfaces;

import javax.ejb.Local;

@Local
public interface IGreetingsLocal {
	String tiSallem(String name);
}
