package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Department;

@Remote
public interface DepartementServicesRemote {
	Boolean addDepartement(Department department);

	Boolean deleteDepartement(Integer id);

	Boolean updateDepartement(Department department);

	Department findDepartmentById(Integer id);

	List<Department> findAllDepartments();

}
