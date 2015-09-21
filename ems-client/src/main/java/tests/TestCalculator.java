package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ems.services.interfaces.CalculatorRemote;

public class TestCalculator {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/ems/Calculator!ems.services.interfaces.CalculatorRemote";
		CalculatorRemote proxy = (CalculatorRemote) context.lookup(jndiName);

		System.out.println(proxy.sum(1, 3));

	}

}
