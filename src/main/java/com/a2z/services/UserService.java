package com.a2z.services;

import java.util.List;

import com.a2z.model.User;
import com.a2z.services.exception.BusinessServiceException;

public interface UserService {

	void doSaveUser(User user) throws BusinessServiceException;
	User doGetUserByUsernamePassword(String userName, String password) throws BusinessServiceException;
	List<User> doGetAllUsers() throws BusinessServiceException;

}
