package com.a2z.dao;

import java.util.List;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.ServiceAvailability;

public interface ServiceAvailabilityDAO {
	void saveServiceAvailability(ServiceAvailability courierBoy) throws DataServiceException;
	List<ServiceAvailability> getAllServiceAvailabilitys() throws DataServiceException;
	ServiceAvailability getServiceAvailabilityById(Long id) throws DataServiceException;
	void deleteServiceAvailability(ServiceAvailability serviceAvailability) throws DataServiceException;
}
