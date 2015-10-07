package entities;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: RhManager
 *
 */
@Entity
public class RhManager extends User implements Serializable {

	private String experience;
	private static final long serialVersionUID = 1L;

	public RhManager() {
		super();
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

}
