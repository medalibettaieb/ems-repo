package training.services.impl;

import javax.ejb.Stateless;

import training.services.interfaces.CalculatorLocal;
import training.services.interfaces.CalculatorRemote;

/**
 * Session Bean implementation class Calculator
 */
@Stateless
public class Calculator implements CalculatorRemote, CalculatorLocal {

	/**
	 * Default constructor.
	 */
	public Calculator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer sum(Integer a, Integer b) {
		return a + b;
	}

}
