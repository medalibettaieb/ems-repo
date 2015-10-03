package training.entities.oneToManyUniSlaveSide;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: J
 *
 */
@Entity

public class J implements Serializable {

	
	private Integer idJ;
	private static final long serialVersionUID = 1L;

	public J() {
		super();
	}   
	@Id    
	public Integer getIdJ() {
		return this.idJ;
	}

	public void setIdJ(Integer idJ) {
		this.idJ = idJ;
	}
   
}
