package com.a2z.dao;

import java.util.List;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.CourierBoy;
import com.a2z.vo.CourierBoyDetailsVO;

public interface CourierBoyDAO {
	void saveCourierBoy(CourierBoy courierBoy) throws DataServiceException;
	List<CourierBoy> getAllCourierBoys() throws DataServiceException;
	List<CourierBoyDetailsVO> getAllCourierBoysWithCourierDetails() throws DataServiceException;
	List<CourierBoy> getAllActiveCourierBoys() throws DataServiceException;
	CourierBoy getCourierBoyWithUserById(Long id) throws DataServiceException;
	Long getCourierBoyIdByUserById(Long id) throws DataServiceException;
	void updateCourierBoy(CourierBoy courierBoy) throws DataServiceException;
}
