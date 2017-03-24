package com.a2z.services;

import java.util.List;

import com.a2z.model.ServiceAvailability;
import com.a2z.services.exception.BusinessServiceException;

public interface ServiceAvailabilityService {

	void doSaveServiceAvailability(ServiceAvailability serviceAvailability) throws BusinessServiceException;
	
	List<ServiceAvailability> doGetAllServiceAvailabilitys() throws BusinessServiceException;
	
	ServiceAvailability doGetServiceAvailabilityById(Long id) throws BusinessServiceException;
	
	void doDeleteServiceAvailability(ServiceAvailability serviceAvailability) throws BusinessServiceException;

}
