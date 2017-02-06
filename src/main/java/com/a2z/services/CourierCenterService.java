package com.a2z.services;

import java.util.List;

import com.a2z.model.CourierCenter;
import com.a2z.services.exception.BusinessServiceException;

public interface CourierCenterService {

	void doSaveCourierCenter(CourierCenter courierCenter) throws BusinessServiceException;
	
	List<CourierCenter> doGetAllCourierCenters() throws BusinessServiceException;
	
	CourierCenter doGetCourierCenterById(Long id) throws BusinessServiceException;
	
	void doDeleteCourierCenter(CourierCenter courierCenter) throws BusinessServiceException;

}
