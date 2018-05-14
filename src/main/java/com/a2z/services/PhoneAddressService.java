package com.a2z.services;

import java.util.List;

import com.a2z.model.PhoneAddress;
import com.a2z.services.exception.BusinessServiceException;

public interface PhoneAddressService {

	void doSavePhoneAddress(PhoneAddress phoneAddress) throws BusinessServiceException;
	
	List<PhoneAddress> doGetAllPhoneAddresses() throws BusinessServiceException;
	
	PhoneAddress doGetPhoneAddressById(Long id) throws BusinessServiceException;
	
	PhoneAddress doGetPhoneAddressByMobile(String mobile) throws BusinessServiceException;
	
	void doDeletePhoneAddress(PhoneAddress phoneAddress) throws BusinessServiceException;

}
