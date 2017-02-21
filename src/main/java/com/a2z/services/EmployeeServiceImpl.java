package com.a2z.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.dao.EmployeeDAO;
import com.a2z.dao.UserDAO;
import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.Employee;
import com.a2z.model.SeedRole;
import com.a2z.model.User;
import com.a2z.services.exception.BusinessServiceException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO employeeDAO; 
	@Autowired
	UserDAO userDAO; 
	
	@Override
	@Transactional
	public void doSaveEmployee(Employee employee) throws BusinessServiceException {
		try{
			User user = employee.getUser();
			SeedRole seedRole = new SeedRole();
			seedRole.setId(3);
			user.setSeedRole(seedRole);
			userDAO.saveUser(user);
			
			employee.setUser(user);
			employee.setEnable(1);
			employeeDAO.saveEmployee(employee);
			
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
	}

	
	@Override
	@Transactional
	public void doUpdateEmployee(Employee employee) throws BusinessServiceException {
		try{
			String password = employee.getUser().getPassword();
			Employee employeeFromDao = employeeDAO.getEmployeeWithUserById(employee.getId());
			employee.setUser(employeeFromDao.getUser());
			employee.getUser().setPassword(password);
			employee.setEnable(employeeFromDao.getEnable());
			if(employee.getDlFileName()==null){
				employee.setDlFileName(employeeFromDao.getDlFileName());
				employee.setDlUniqueFileName(employeeFromDao.getDlUniqueFileName());
			}if(employee.getPanFileName()==null){
				employee.setPanFileName(employeeFromDao.getPanFileName());
				employee.setPanUniqueFileName(employeeFromDao.getPanUniqueFileName());
			}if(employee.getPhotoFileName()==null){
				employee.setPhotoFileName(employeeFromDao.getPhotoFileName());
				employee.setPhotoUniqueFileName(employeeFromDao.getPhotoUniqueFileName());
			}
			userDAO.saveUser(employee.getUser());
			User user = new User();
			user.setId(employee.getUser().getId());
			employee.setUser(user);
			employeeDAO.updateEmployee(employee);
			
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
	}
	

	@Override
	@Transactional
	public List<Employee> doGetAllEmployees() throws BusinessServiceException {
		// TODO Auto-generated method stub
		List<Employee> employeesList =null;
		try{
			employeesList = employeeDAO.getAllEmployees();
			
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		return employeesList;
	}
	
	
	@Override
	@Transactional
	public List<Employee> doGetAllActiveEmployees() throws BusinessServiceException {
		// TODO Auto-generated method stub
		List<Employee> employeesList =null;
		List<Employee> finalEmployeesList =new ArrayList<Employee>();
		try{
			employeesList = employeeDAO.getAllActiveEmployees();
			for(Employee employee : employeesList){
				if(employee.getUser()!=null)
				employee.getUser().setPassword(null);
				
				finalEmployeesList.add(employee);
			}
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		return finalEmployeesList;
	}
	
	
	@Override
	@Transactional
	public Employee deactivateEmployee(Long id) throws BusinessServiceException {
		// TODO Auto-generated method stub
		Employee employee =null;
		try{
			employee = employeeDAO.getEmployeeWithUserById(id);
			employee.setEnable(0);
			employeeDAO.saveEmployee(employee);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		return employee;
	}


	@Override
	@Transactional
	public Employee doGetEmployeeWithUserById(Long id) throws BusinessServiceException {
		Employee employee =null;
		try{
			employee = employeeDAO.getEmployeeWithUserById(id);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
		return employee;
	}
	
	
}




