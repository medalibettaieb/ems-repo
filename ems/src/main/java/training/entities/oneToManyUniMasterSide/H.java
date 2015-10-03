package training.entities.oneToManyUniMasterSide;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: H
 *
 */
@Entity
public class H implements Serializable {

	private Integer idH;
	private static final long serialVersionUID = 1L;

	private List<G> gs;

	public H() {
		super();
	}

	@Id
	public Integer getIdH() {
		return this.idH;
	}

	public void setIdH(Integer idH) {
		this.idH = idH;
	}

	@OneToMany
	public List<G> getGs() {
		return gs;
	}

	public void setGs(List<G> gs) {
		this.gs = gs;
	}

}
