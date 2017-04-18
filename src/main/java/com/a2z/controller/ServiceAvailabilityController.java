package com.a2z.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a2z.controller.util.ServiceResponseUtils;
import com.a2z.model.ServiceAvailability;
import com.a2z.services.ServiceAvailabilityService;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.vo.ServiceResponse;

@Controller
@RequestMapping("/serviceavailability")
public class ServiceAvailabilityController {

	@Autowired
	ServiceAvailabilityService serviceAvailabilityService;

	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse saveCC(@RequestBody ServiceAvailability serviceAvailability) {
		ServiceResponse serviceResponse = null;
		try {
			serviceAvailabilityService.doSaveServiceAvailability(serviceAvailability);

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", serviceAvailability);

		} catch (BusinessServiceException e) {
			// e.printStackTrace();
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);

		} catch (Exception e) {
			if(e.getCause().getMessage().contains("pincode"))
				serviceResponse = ServiceResponseUtils.dataResponse("2", e.getCause().getMessage(), null);
			else
				
				serviceResponse = ServiceResponseUtils.dataResponse("0", e.getCause().getMessage(), null);
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getAllCC() {
		ServiceResponse serviceResponse = null;
		try {
			List<ServiceAvailability> serviceAvailabilityList = serviceAvailabilityService.doGetAllServiceAvailabilitys();

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", serviceAvailabilityList);

		} catch (BusinessServiceException e) {
			// e.printStackTrace();
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}

	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse deleteCC( @PathVariable(value = "id") Long id) {
		ServiceResponse serviceResponse = null;
		try {
			ServiceAvailability serviceAvailability = new ServiceAvailability();
			serviceAvailability.setId(id);
			serviceAvailabilityService.doDeleteServiceAvailability(serviceAvailability);

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data deleted successfully", null);

		} catch (BusinessServiceException e) {
			// e.printStackTrace();
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}
	
}
