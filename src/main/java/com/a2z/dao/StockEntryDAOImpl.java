package com.a2z.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.StockEntry;

@Repository
public class StockEntryDAOImpl implements StockEntryDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveStockEntry(StockEntry stockEntry) throws Exception {
		
			this.sessionFactory.getCurrentSession().saveOrUpdate(stockEntry);
		
		
	}

	@Override
	public List<StockEntry> getAllStockEntries() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From StockEntry").getResultList();
	}

	@Override
	public StockEntry getStockEntryById(Long id) throws DataServiceException {
		try {

			List<StockEntry> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From StockEntry se  where se.id=" + id).getResultList();

			for (StockEntry stockEntry : list) {
				return stockEntry;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;

	}

	@Override
	public void updateStockEntry(StockEntry stockEntry) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(stockEntry);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

	@Override
	public List<StockEntry> getStockEntriesByCourierCenter(Long courierCenterId) throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From StockEntry se where se.courierCenter.id=" + courierCenterId).getResultList();
	}

	
}
