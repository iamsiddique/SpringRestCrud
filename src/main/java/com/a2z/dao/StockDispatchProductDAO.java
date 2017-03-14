package com.a2z.dao;

import java.util.List;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.StockDispatchProduct;

public interface StockDispatchProductDAO {
	void saveStockDispatchProduct(StockDispatchProduct stockDispatchProduct) throws DataServiceException;

	List<StockDispatchProduct> getAllStockDispatchProduct() throws DataServiceException;

	StockDispatchProduct getStockDispatchProductById(Long id) throws DataServiceException;

	void updateStockDispatchProduct(StockDispatchProduct stockDispatchProduct) throws DataServiceException;

	List<StockDispatchProduct> getStockDispatchProductsByStockDispatchId(Long stockDispatchId)
			throws DataServiceException;
}
