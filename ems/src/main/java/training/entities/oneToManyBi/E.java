package training.entities.oneToManyBi;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: E
 *
 */
@Entity

public class E implements Serializable {

	
	private Integer idE;
	private static final long serialVersionUID = 1L;
	
	private F f;

	public E() {
		super();
	}   
	@Id    
	public Integer getIdE() {
		return this.idE;
	}

	public void setIdE(Integer idE) {
		this.idE = idE;
	}
	@ManyToOne
	public F getF() {
		return f;
	}
	public void setF(F f) {
		this.f = f;
	}
   
}
