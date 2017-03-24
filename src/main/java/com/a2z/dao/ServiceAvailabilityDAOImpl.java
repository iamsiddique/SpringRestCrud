package com.a2z.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.ServiceAvailability;

@Repository
public class ServiceAvailabilityDAOImpl implements ServiceAvailabilityDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveServiceAvailability(ServiceAvailability serviceAvailability) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(serviceAvailability);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
	}
	


	@Override
	public List<ServiceAvailability> getAllServiceAvailabilitys() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From ServiceAvailability").getResultList();
	}

	

	@Override
	public ServiceAvailability getServiceAvailabilityById(Long id) throws DataServiceException {
		try {

			List<ServiceAvailability> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From ServiceAvailability cc  where cc.id=" + id).getResultList();

			for (ServiceAvailability serviceAvailability : list) {
				return serviceAvailability;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}



	@Override
	public void deleteServiceAvailability(ServiceAvailability serviceAvailability) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().delete(serviceAvailability);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data delete fail", dataAccessException);
		}
		
	}
}
