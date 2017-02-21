package com.a2z.dao;

import java.util.List;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.Employee;

public interface EmployeeDAO {
	void saveEmployee(Employee employee) throws DataServiceException;
	List<Employee> getAllEmployees() throws DataServiceException;
	List<Employee> getAllActiveEmployees() throws DataServiceException;
	Employee getEmployeeWithUserById(Long id) throws DataServiceException;
	void updateEmployee(Employee employee) throws DataServiceException;
}
