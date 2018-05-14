package com.a2z.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.PhoneAddress;

@Repository
public class PhoneAddressDAOImpl implements PhoneAddressDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void savePhoneAddress(PhoneAddress phoneAddress) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(phoneAddress);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
	}
	


	@Override
	public List<PhoneAddress> getAllPhoneAddresses() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From PhoneAddress").getResultList();
	}

	

	@Override
	public PhoneAddress getPhoneAddressById(Long id) throws DataServiceException {
		try {

			List<PhoneAddress> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From PhoneAddress cc  where cc.id=" + id).getResultList();

			for (PhoneAddress phoneAddress : list) {
				return phoneAddress;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}



	@Override
	public void deletePhoneAddress(PhoneAddress phoneAddress) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().delete(phoneAddress);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data delete fail", dataAccessException);
		}
		
	}



	@Override
	public PhoneAddress getPhoneAddressByMobile(String mobile) throws DataServiceException {
		try {

			List<PhoneAddress> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From PhoneAddress cc  where cc.phone='" + mobile+"'").getResultList();

			for (PhoneAddress phoneAddress : list) {
				return phoneAddress;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}
}
