package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Department;

@Local
public interface DepartementServicesLocal {

	public abstract Boolean addDepartement(Department department);

	public abstract Boolean deleteDepartement(Integer id);

	public abstract Boolean updateDepartement(Department department);

	public abstract Department findDepartmentById(Integer id);

	public abstract List<Department> findAllDepartments();

}