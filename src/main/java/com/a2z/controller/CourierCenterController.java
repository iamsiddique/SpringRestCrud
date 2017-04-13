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
import com.a2z.model.CourierCenter;
import com.a2z.services.CourierCenterService;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.vo.ServiceResponse;

@Controller
@RequestMapping("/couriercenter")
public class CourierCenterController {

	@Autowired
	CourierCenterService courierCenterService;

	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse saveCC(@RequestBody CourierCenter courierCenter) {
		ServiceResponse serviceResponse = null;
		try {
			courierCenterService.doSaveCourierCenter(courierCenter);

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", courierCenter);

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

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse updateCC(@RequestBody CourierCenter courierCenter) {
		ServiceResponse serviceResponse = null;
		try {
			courierCenterService.doSaveCourierCenter(courierCenter);

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data updated successfully", courierCenter);

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

	
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getAllCC() {
		ServiceResponse serviceResponse = null;
		try {
			List<CourierCenter> courierCenterList = courierCenterService.doGetAllCourierCenters();

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", courierCenterList);

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
			CourierCenter courierCenter = new CourierCenter();
			courierCenter.setId(id);
			courierCenterService.doDeleteCourierCenter(courierCenter);

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
