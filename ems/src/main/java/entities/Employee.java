package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
public class Employee extends User implements Serializable {
	@NotNull
	private String cnss;
	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	}

	public String getCnss() {
		return this.cnss;
	}

	public void setCnss(String cnss) {
		this.cnss = cnss;
	}

}
