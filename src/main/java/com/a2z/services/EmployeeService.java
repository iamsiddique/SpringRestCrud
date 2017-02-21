package com.a2z.services;

import java.util.List;

import com.a2z.model.Employee;
import com.a2z.services.exception.BusinessServiceException;

public interface EmployeeService {

	void doSaveEmployee(Employee employee) throws BusinessServiceException;
	
	List<Employee> doGetAllEmployees() throws BusinessServiceException;

	List<Employee> doGetAllActiveEmployees() throws BusinessServiceException;

	Employee deactivateEmployee(Long id) throws BusinessServiceException;

	void doUpdateEmployee(Employee employee) throws BusinessServiceException;
	
	Employee doGetEmployeeWithUserById(Long id) throws BusinessServiceException;

}
