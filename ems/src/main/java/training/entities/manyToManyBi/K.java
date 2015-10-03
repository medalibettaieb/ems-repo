package training.entities.manyToManyBi;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: K
 *
 */
@Entity
public class K implements Serializable {

	private Integer idK;
	private static final long serialVersionUID = 1L;

	private List<L> ls;

	public K() {
		super();
	}

	@Id
	public Integer getIdK() {
		return this.idK;
	}

	public void setIdK(Integer idK) {
		this.idK = idK;
	}

	@ManyToMany
	public List<L> getLs() {
		return ls;
	}

	public void setLs(List<L> ls) {
		this.ls = ls;
	}

}
