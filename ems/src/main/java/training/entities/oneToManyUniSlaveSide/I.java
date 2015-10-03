package training.entities.oneToManyUniSlaveSide;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: I
 *
 */
@Entity
public class I implements Serializable {

	private Integer idI;
	private static final long serialVersionUID = 1L;

	private J j;

	public I() {
		super();
	}

	@Id
	public Integer getIdI() {
		return this.idI;
	}

	public void setIdI(Integer idI) {
		this.idI = idI;
	}

	@ManyToOne
	public J getJ() {
		return j;
	}

	public void setJ(J j) {
		this.j = j;
	}

}
