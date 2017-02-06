package com.a2z.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.dao.CourierCenterDAO;
import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.CourierCenter;
import com.a2z.services.exception.BusinessServiceException;

@Service
public class CourierCenterServiceImpl implements CourierCenterService {
	@Autowired
	CourierCenterDAO courierCenterDAO;

	@Override
	@Transactional
	public void doSaveCourierCenter(CourierCenter courierCenter) throws BusinessServiceException {
		try {

			courierCenterDAO.saveCourierCenter(courierCenter);

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

	}

	@Override
	@Transactional
	public List<CourierCenter> doGetAllCourierCenters() throws BusinessServiceException {
		// TODO Auto-generated method stub
		List<CourierCenter> courierCentersList = null;
		try {
			courierCentersList = courierCenterDAO.getAllCourierCenters();

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return courierCentersList;
	}

	@Override
	@Transactional
	public CourierCenter doGetCourierCenterById(Long id) throws BusinessServiceException {
		CourierCenter courierCenter = null;
		try {
			courierCenter = courierCenterDAO.getCourierCenterById(id);
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

		return courierCenter;
	}

	@Override
	@Transactional
	public void doDeleteCourierCenter(CourierCenter courierCenter) throws BusinessServiceException {
		try {

			courierCenterDAO.deleteCourierCenter(courierCenter);

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

	}

}
