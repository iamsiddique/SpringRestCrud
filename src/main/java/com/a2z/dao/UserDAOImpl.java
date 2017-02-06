package com.a2z.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	
	public void saveUser(User user) throws DataServiceException {
		try{
			this.sessionFactory.getCurrentSession().saveOrUpdate(user);
			System.out.println(user);
		}catch(DataAccessException dataAccessException){
			throw new DataServiceException("data insert fail", dataAccessException);
		}
	}
	
	@Override
	public User getUserByUsernamePassword(String userName,String password) throws DataServiceException {
		
	    try {
	    	
	    	List<User> list = this.sessionFactory.getCurrentSession().createQuery(" From User u where u.username='"+userName+"' and u.password='"+password+"'").getResultList();
	    	
	    	for(User user : list){
	    		return user;
	    	}
	    } catch (DataAccessException e) {
	      throw new DataServiceException("data retrieval fail",e);
	    }
	    return null;
	}

	@Override
	public List<User> getAllUsers() throws DataServiceException {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery(" From User").getResultList();
	}

}
