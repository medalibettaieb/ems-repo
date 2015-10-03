package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Employee;

@Remote
public interface EmsGlobalServicesRemote {
	Boolean assignEmployeeToDepartementMasterSide(Integer idEmployee,
			Integer idDepartement);

	Boolean assignEmployeeToDepartementSlaveSide(Integer idEmployee,
			Integer idDepartement);

	List<Employee> findEmployeesByDepartementId(Integer id);
}
