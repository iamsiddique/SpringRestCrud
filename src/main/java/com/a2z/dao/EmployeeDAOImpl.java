package com.a2z.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveEmployee(Employee employee) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(employee);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
	}
	
	@Override
	public void updateEmployee(Employee employee) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(employee);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
	}

	@Override
	public List<Employee> getAllEmployees() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From Employee").getResultList();
	}

	@Override
	public List<Employee> getAllActiveEmployees() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From Employee where enable=1").getResultList();
	}

	@Override
	public Employee getEmployeeWithUserById(Long id) throws DataServiceException {
		try {

			List<Employee> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From Employee em join fetch em.user where cb.id=" + id).getResultList();

			for (Employee employee : list) {
				return employee;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}
}
