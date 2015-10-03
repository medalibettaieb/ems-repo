package training.entities.oneToManyBi;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: F
 *
 */
@Entity
public class F implements Serializable {

	private Integer idF;
	private static final long serialVersionUID = 1L;

	private List<E> es;

	public F() {
		super();
	}

	@Id
	public Integer getIdF() {
		return this.idF;
	}

	public void setIdF(Integer idF) {
		this.idF = idF;
	}

	@OneToMany(mappedBy = "f")
	public List<E> getEs() {
		return es;
	}

	public void setEs(List<E> es) {
		this.es = es;
	}

}
