package training.services.interfaces;

import javax.ejb.Remote;

@Remote
public interface CalculatorRemote {
	Integer sum(Integer a, Integer b);
}
