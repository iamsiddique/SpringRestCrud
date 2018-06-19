package com.a2z.dao;

import java.util.List;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.StockDispatch;

public interface StockDispatchDAO {
	void saveStockDispatch(StockDispatch stockDispatch) throws DataServiceException;
	List<StockDispatch> getAllStockDispatch() throws DataServiceException;
	StockDispatch getStockDispatchById(Long id) throws DataServiceException;
	void updateStockDispatch(StockDispatch stockDispatch) throws DataServiceException;
	List<StockDispatch> getStockDispatchesByCourierCenter(Long id) throws DataServiceException;
}
