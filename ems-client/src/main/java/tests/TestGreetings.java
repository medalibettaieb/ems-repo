package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ems.services.interfaces.IGreetingsRemote;

public class TestGreetings {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			String jndiName = "/ems/Greetings!"
					+ IGreetingsRemote.class.getCanonicalName();
			IGreetingsRemote proxy = (IGreetingsRemote) context
					.lookup(jndiName);

			System.out.println(proxy.tiSallem("seif"));

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
