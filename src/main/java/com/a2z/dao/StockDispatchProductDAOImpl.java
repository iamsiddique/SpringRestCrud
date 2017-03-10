package com.a2z.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.StockDispatchProduct;

@Repository
public class StockDispatchProductDAOImpl implements StockDispatchProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveStockDispatchProduct(StockDispatchProduct stockDispatchProduct) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(stockDispatchProduct);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

	@Override
	public List<StockDispatchProduct> getAllStockDispatchProduct() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From StockDispatchProduct").getResultList();
	}

	@Override
	public StockDispatchProduct getStockDispatchProductById(Long id) throws DataServiceException {
		try {

			List<StockDispatchProduct> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From StockDispatchProduct p  where p.id=" + id).getResultList();

			for (StockDispatchProduct stockDispatchProduct : list) {
				return stockDispatchProduct;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;

	}

	@Override
	public void updateStockDispatchProduct(StockDispatchProduct stockDispatchProduct) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(stockDispatchProduct);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

}
