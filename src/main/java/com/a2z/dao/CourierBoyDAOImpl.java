package com.a2z.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.CourierBoy;

@Repository
public class CourierBoyDAOImpl implements CourierBoyDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveCourierBoy(CourierBoy courierBoy) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(courierBoy);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
	}
	
	@Override
	public void updateCourierBoy(CourierBoy courierBoy) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(courierBoy);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
	}

	@Override
	public List<CourierBoy> getAllCourierBoys() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From CourierBoy").getResultList();
	}

	@Override
	public List<CourierBoy> getAllActiveCourierBoys() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From CourierBoy where enable=1").getResultList();
	}

	@Override
	public CourierBoy getCourierBoyWithUserById(Long id) throws DataServiceException {
		try {

			List<CourierBoy> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From CourierBoy cb join fetch cb.user where cb.id=" + id).getResultList();

			for (CourierBoy courierBoy : list) {
				return courierBoy;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}
}
