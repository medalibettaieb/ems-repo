package training.entities.oneToOneBi;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: A
 *
 */
@Entity
public class A implements Serializable {

	private Integer idA;
	private static final long serialVersionUID = 1L;

	private B b;

	public A() {
		super();
	}

	@Id
	public Integer getIdA() {
		return this.idA;
	}

	public void setIdA(Integer idA) {
		this.idA = idA;
	}

	@OneToOne(mappedBy = "a")
	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

}
