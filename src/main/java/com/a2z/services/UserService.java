package com.a2z.services;

import java.util.List;

import com.a2z.model.User;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.vo.ChangePasswordVO;

public interface UserService {

	void doSaveUser(User user) throws BusinessServiceException;
	int doChangePassword(ChangePasswordVO changePasswordVO) throws BusinessServiceException;
	User doGetUserByUsernamePassword(String userName, String password) throws BusinessServiceException;
	List<User> doGetAllUsers() throws BusinessServiceException;

}
