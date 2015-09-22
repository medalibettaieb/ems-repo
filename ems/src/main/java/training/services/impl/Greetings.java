package training.services.impl;

import javax.ejb.Stateless;

import training.services.interfaces.IGreetingsLocal;
import training.services.interfaces.IGreetingsRemote;

@Stateless
public class Greetings implements IGreetingsLocal, IGreetingsRemote {

	@Override
	public String tiSallem(String name) {
		return "essalem ya :" + name;
	}

}
