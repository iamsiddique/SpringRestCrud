package com.a2z.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.Inventory;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveInventory(Inventory inventory) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(inventory);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

	@Override
	public List<Inventory> getAllInventories() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From Inventory").getResultList();
	}

	@Override
	public Inventory getInventoryById(Long id) throws DataServiceException {
		try {

			List<Inventory> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From Inventory p  where p.id=" + id).getResultList();

			for (Inventory inventory : list) {
				return inventory;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;

	}

	@Override
	public void updateInventory(Inventory inventory) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(inventory);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

}
