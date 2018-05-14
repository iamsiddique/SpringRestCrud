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
import com.a2z.model.PhoneAddress;
import com.a2z.services.PhoneAddressService;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.vo.ServiceResponse;

@Controller
@RequestMapping("/phoneaddress")
public class PhoneAddressController {

	@Autowired
	PhoneAddressService phoneAddressService;

	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse saveCC(@RequestBody PhoneAddress phoneAddress) {
		ServiceResponse serviceResponse = null;
		try {
			phoneAddressService.doSavePhoneAddress(phoneAddress);

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", phoneAddress);

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
	public @ResponseBody ServiceResponse updateCC(@RequestBody PhoneAddress phoneAddress) {
		ServiceResponse serviceResponse = null;
		try {
			phoneAddressService.doSavePhoneAddress(phoneAddress);

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data updated successfully", phoneAddress);

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
			List<PhoneAddress> phoneAddressList = phoneAddressService.doGetAllPhoneAddresses();

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", phoneAddressList);

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
			PhoneAddress phoneAddress = new PhoneAddress();
			phoneAddress.setId(id);
			phoneAddressService.doDeletePhoneAddress(phoneAddress);

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
	
	@RequestMapping(value = "/mobile/{mobileno}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getByMobile( @PathVariable(value = "mobileno") String mobileno) {
		ServiceResponse serviceResponse = null;
		try {
			PhoneAddress phoneAddress = phoneAddressService.doGetPhoneAddressByMobile(mobileno);

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", phoneAddress);

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
