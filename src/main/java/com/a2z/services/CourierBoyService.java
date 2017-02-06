package com.a2z.services;

import java.util.List;

import com.a2z.model.CourierBoy;
import com.a2z.services.exception.BusinessServiceException;

public interface CourierBoyService {

	void doSaveCourierBoy(CourierBoy courierBoy) throws BusinessServiceException;
	
	List<CourierBoy> doGetAllCourierBoys() throws BusinessServiceException;

	List<CourierBoy> doGetAllActiveCourierBoys() throws BusinessServiceException;

	CourierBoy deactivateCourierBoy(Long id) throws BusinessServiceException;

	void doUpdateCourierBoy(CourierBoy courierBoy) throws BusinessServiceException;
	
	CourierBoy doGetCourierBoyWithUserById(Long id) throws BusinessServiceException;

}
