package com.a2z.dao;

import java.util.List;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.User;

public interface UserDAO {
	void saveUser(User user) throws DataServiceException;
	
	int changePassword(String userName,String password) throws DataServiceException;

	User getUserByUsernamePassword(String userName, String password) throws DataServiceException;
	
	List<User> getAllUsers() throws DataServiceException;
}
