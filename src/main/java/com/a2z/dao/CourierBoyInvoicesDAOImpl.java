package com.a2z.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.CourierBoyInvoices;

@Repository
public class CourierBoyInvoicesDAOImpl implements CourierBoyInvoicesDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(CourierBoyInvoices courierBoyInvoices) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(courierBoyInvoices);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

	@Override
	public List<CourierBoyInvoices> getAll() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From CourierBoyInvoices").getResultList();
	}

	@Override
	public CourierBoyInvoices getById(Long id) throws DataServiceException {
		try {

			List<CourierBoyInvoices> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From CourierBoyInvoices p  where p.id=" + id).getResultList();

			for (CourierBoyInvoices courierBoyInvoices : list) {
				return courierBoyInvoices;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;

	}

	
	@Override
	public void update(CourierBoyInvoices courierBoyInvoices) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(courierBoyInvoices);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

	@Override
	public List<CourierBoyInvoices> getByCourierboyid(Long courierBoyId) throws DataServiceException {
		String hql = "From CourierBoyInvoices i where i.courierBoy.id = :courierBoyId";
	
		List<CourierBoyInvoices> list = this.sessionFactory.getCurrentSession().createQuery(hql)
		.setParameter("courierBoyId", courierBoyId)
		.getResultList();
		
		return list;
	}

	@Override
	public List<CourierBoyInvoices> getByCourierboyidStatus(Long courierBoyId, Character status)
			throws DataServiceException {
		String hql = "From CourierBoyInvoices i where i.courierBoy.id = :courierBoyId and i.courierStatus = :status";
		
		List<CourierBoyInvoices> list = this.sessionFactory.getCurrentSession().createQuery(hql)
		.setParameter("courierBoyId", courierBoyId)
		.setParameter("status", status)
		.getResultList();
		
		return list;
	}
	
	@Override
	public List<CourierBoyInvoices> getByUseridStatus(Long userId, Character status)
			throws DataServiceException {
		String hql = "From CourierBoyInvoices i where i.courierBoy.user.id = :userId and i.courierStatus = :status";
		
		List<CourierBoyInvoices> list = this.sessionFactory.getCurrentSession().createQuery(hql)
		.setParameter("userId", userId)
		.setParameter("status", status)
		.getResultList();
		
		return list;
	}

}
