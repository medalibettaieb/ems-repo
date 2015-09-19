package ems.services.impl;

import javax.ejb.Stateless;

import ems.services.interfaces.IGreetingsLocal;
import ems.services.interfaces.IGreetingsRemote;

@Stateless
public class Greetings implements IGreetingsLocal, IGreetingsRemote {

	@Override
	public String tiSallem(String name) {
		return "essalem ya :" + name;
	}

}
