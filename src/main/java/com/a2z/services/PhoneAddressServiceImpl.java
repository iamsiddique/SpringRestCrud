package com.a2z.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.dao.PhoneAddressDAO;
import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.PhoneAddress;
import com.a2z.services.exception.BusinessServiceException;

@Service
public class PhoneAddressServiceImpl implements PhoneAddressService {
	@Autowired
	PhoneAddressDAO phoneAddressDAO;

	@Override
	@Transactional
	public void doSavePhoneAddress(PhoneAddress phoneAddress) throws BusinessServiceException {
		try {
			PhoneAddress phoneAddressFromDao = phoneAddressDAO.getPhoneAddressByMobile(phoneAddress.getPhone());
			if(phoneAddressFromDao!=null){
			phoneAddressFromDao.setAddress(phoneAddress.getAddress());
			phoneAddressDAO.savePhoneAddress(phoneAddressFromDao);
			}else{
			phoneAddressDAO.savePhoneAddress(phoneAddress);
			}

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

	}

	@Override
	@Transactional
	public List<PhoneAddress> doGetAllPhoneAddresses() throws BusinessServiceException {
		// TODO Auto-generated method stub
		List<PhoneAddress> phoneAddresssList = null;
		try {
			phoneAddresssList = phoneAddressDAO.getAllPhoneAddresses();

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return phoneAddresssList;
	}

	@Override
	@Transactional
	public PhoneAddress doGetPhoneAddressById(Long id) throws BusinessServiceException {
		PhoneAddress phoneAddress = null;
		try {
			phoneAddress = phoneAddressDAO.getPhoneAddressById(id);
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

		return phoneAddress;
	}

	@Override
	@Transactional
	public void doDeletePhoneAddress(PhoneAddress phoneAddress) throws BusinessServiceException {
		try {

			phoneAddressDAO.deletePhoneAddress(phoneAddress);

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

	}

	@Override
	@Transactional
	public PhoneAddress doGetPhoneAddressByMobile(String mobile) throws BusinessServiceException {
		PhoneAddress phoneAddress = null;
		try {
			phoneAddress = phoneAddressDAO.getPhoneAddressByMobile(mobile);
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

		return phoneAddress;
	}

}
