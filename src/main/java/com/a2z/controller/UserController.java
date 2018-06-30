package com.a2z.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a2z.controller.util.ServiceResponseUtils;
import com.a2z.model.ServiceAvailability;
import com.a2z.model.User;
import com.a2z.services.UserService;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.vo.ChangePasswordVO;
import com.a2z.vo.ServiceResponse;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserService userService;
	

	static final Logger logger = Logger.getLogger(UserController.class);

	
		

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody
	ServiceResponse userLogin(@RequestBody User user) {
		ServiceResponse serviceResponse = null;
		try {
			User responseUser= userService.doGetUserByUsernamePassword(user.getUsername(), user.getPassword());
			
			if(responseUser!=null){
				responseUser.setPassword(null);
				serviceResponse =ServiceResponseUtils.dataResponse("1", "login success", responseUser);	
			}else{
				serviceResponse =ServiceResponseUtils.dataResponse("0", "invalid credentials", null);
			}
			
			
			
		} catch (BusinessServiceException e) {
			// e.printStackTrace();
			serviceResponse =ServiceResponseUtils.dataResponse("0", e.toString(), null);
			
		}catch(Exception e){
			e.printStackTrace();
		}catch(Throwable e){
			e.printStackTrace();
		}
		return serviceResponse;

	}

	

	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	ServiceResponse getEmployee() {
		ServiceResponse serviceResponse = null;
		try {
			List<User> userList= userService.doGetAllUsers();
			
			serviceResponse =ServiceResponseUtils.dataResponse("1", "data retrived successfully", userList);
			
		} catch (BusinessServiceException e) {
			// e.printStackTrace();
			serviceResponse =ServiceResponseUtils.dataResponse("0", e.toString(), null);
			
		}catch(Exception e){
			e.printStackTrace();
		}catch(Throwable e){
			e.printStackTrace();
		}
		return serviceResponse;

	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse changePassword(@RequestBody ChangePasswordVO changePasswordVO) {
		ServiceResponse serviceResponse = null;
		try {
			//serviceAvailabilityService.doSaveServiceAvailability(serviceAvailability);
			int result = userService.doChangePassword(changePasswordVO);
			if(result==1){
				serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", changePasswordVO);	
			}else{
				serviceResponse = ServiceResponseUtils.dataResponse("2", "incorrect existing password", changePasswordVO);
			}
			

		} catch (BusinessServiceException e) {
			// e.printStackTrace();
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);

		} catch (Exception e) {
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.getCause().getMessage(), null);
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;

	}

	


}
