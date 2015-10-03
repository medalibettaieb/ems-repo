package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Department
 *
 */
@Entity
@Table(name = "T_DEP")
public class Department implements Serializable {

	private Integer id;
	private String name;
	private String description;
	private static final long serialVersionUID = 1L;

	private List<Employee> employees;

	public Department() {
		super();
	}

	public Department(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public void linkEmployeesToThisDepartement(List<Employee> employees) {
		this.employees = employees;
		for (Employee e : employees) {
			e.setDepartment(this);
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = "department")
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
