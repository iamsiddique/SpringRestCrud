package com.a2z.dao;

import java.util.List;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.CourierCenter;

public interface CourierCenterDAO {
	void saveCourierCenter(CourierCenter courierBoy) throws DataServiceException;
	List<CourierCenter> getAllCourierCenters() throws DataServiceException;
	CourierCenter getCourierCenterById(Long id) throws DataServiceException;
	void deleteCourierCenter(CourierCenter courierCenter) throws DataServiceException;
}
