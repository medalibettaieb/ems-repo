package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@Table(name="T_EMP")
public class Employee implements Serializable {

	
	private Integer id;
	private String name;
	private static final long serialVersionUID = 1L;
	
	private Department department;

	public Employee() {
		super();
	}   
	
	public Employee(String name) {
		super();
		this.name = name;
	}

	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@ManyToOne(cascade=CascadeType.PERSIST)
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
   
}
