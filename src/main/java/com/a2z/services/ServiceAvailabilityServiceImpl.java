package com.a2z.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.dao.ServiceAvailabilityDAO;
import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.ServiceAvailability;
import com.a2z.services.exception.BusinessServiceException;

@Service
public class ServiceAvailabilityServiceImpl implements ServiceAvailabilityService {
	@Autowired
	ServiceAvailabilityDAO serviceAvailabilityDAO;

	@Override
	@Transactional
	public void doSaveServiceAvailability(ServiceAvailability serviceAvailability) throws BusinessServiceException {
		try {

			serviceAvailabilityDAO.saveServiceAvailability(serviceAvailability);

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

	}

	@Override
	@Transactional
	public List<ServiceAvailability> doGetAllServiceAvailabilitys() throws BusinessServiceException {
		// TODO Auto-generated method stub
		List<ServiceAvailability> serviceAvailabilitysList = null;
		try {
			serviceAvailabilitysList = serviceAvailabilityDAO.getAllServiceAvailabilitys();

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return serviceAvailabilitysList;
	}

	@Override
	@Transactional
	public ServiceAvailability doGetServiceAvailabilityById(Long id) throws BusinessServiceException {
		ServiceAvailability serviceAvailability = null;
		try {
			serviceAvailability = serviceAvailabilityDAO.getServiceAvailabilityById(id);
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

		return serviceAvailability;
	}

	@Override
	@Transactional
	public void doDeleteServiceAvailability(ServiceAvailability serviceAvailability) throws BusinessServiceException {
		try {

			serviceAvailabilityDAO.deleteServiceAvailability(serviceAvailability);

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

	}

}
