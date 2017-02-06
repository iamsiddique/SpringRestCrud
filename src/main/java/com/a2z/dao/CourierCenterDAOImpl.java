package com.a2z.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.CourierCenter;

@Repository
public class CourierCenterDAOImpl implements CourierCenterDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveCourierCenter(CourierCenter courierCenter) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(courierCenter);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
	}
	


	@Override
	public List<CourierCenter> getAllCourierCenters() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From CourierCenter").getResultList();
	}

	

	@Override
	public CourierCenter getCourierCenterById(Long id) throws DataServiceException {
		try {

			List<CourierCenter> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From CourierCenter cc  where cc.id=" + id).getResultList();

			for (CourierCenter courierCenter : list) {
				return courierCenter;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}



	@Override
	public void deleteCourierCenter(CourierCenter courierCenter) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().delete(courierCenter);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data delete fail", dataAccessException);
		}
		
	}
}
