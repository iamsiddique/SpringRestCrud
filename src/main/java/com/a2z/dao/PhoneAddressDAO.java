package com.a2z.dao;

import java.util.List;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.PhoneAddress;

public interface PhoneAddressDAO {
	void savePhoneAddress(PhoneAddress phoneAddress) throws DataServiceException;
	List<PhoneAddress> getAllPhoneAddresses() throws DataServiceException;
	PhoneAddress getPhoneAddressById(Long id) throws DataServiceException;
	PhoneAddress getPhoneAddressByMobile(String mobile) throws DataServiceException;
	void deletePhoneAddress(PhoneAddress phoneAddress) throws DataServiceException;
}
