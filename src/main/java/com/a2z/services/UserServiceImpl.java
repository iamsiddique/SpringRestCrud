package com.a2z.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.dao.UserDAO;
import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.User;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.vo.ChangePasswordVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO; 
	
	@Override
	@Transactional
	public void doSaveUser(User user) throws BusinessServiceException {
		try{
			userDAO.saveUser(user);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
	}

	@Override
	@Transactional
	public User doGetUserByUsernamePassword(String userName, String password) throws BusinessServiceException {
		User user =null;
		try{
			user = userDAO.getUserByUsernamePassword(userName, password);
			
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		return user;
	}

	@Override
	@Transactional
	public List<User> doGetAllUsers() throws BusinessServiceException {
		// TODO Auto-generated method stub
		List<User> userList =null;
		try{
			userList = userDAO.getAllUsers();
			
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		return userList;
	}

	@Override
	@Transactional
	public int doChangePassword(ChangePasswordVO changePasswordVO) throws BusinessServiceException {
		User user =null;
		int result = 0;
		try{
			user = userDAO.getUserByUsernamePassword(changePasswordVO.getUserName(), changePasswordVO.getExistingPassword());
			if(user == null){
				result =  -1;
			}else{
				result = userDAO.changePassword(changePasswordVO.getUserName(), changePasswordVO.getNewPassword());
			}
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		return result;
		
	}
	
	
	
	
}




