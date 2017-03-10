package com.a2z.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.StockDispatch;

@Repository
public class StockDispatchDAOImpl implements StockDispatchDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveStockDispatch(StockDispatch stockDispatch) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(stockDispatch);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

	@Override
	public List<StockDispatch> getAllStockDispatch() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From StockDispatch").getResultList();
	}

	@Override
	public StockDispatch getStockDispatchById(Long id) throws DataServiceException {
		try {

			List<StockDispatch> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From StockDispatch p  where p.id=" + id).getResultList();

			for (StockDispatch stockDispatch : list) {
				return stockDispatch;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;

	}

	@Override
	public void updateStockDispatch(StockDispatch stockDispatch) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(stockDispatch);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

}
