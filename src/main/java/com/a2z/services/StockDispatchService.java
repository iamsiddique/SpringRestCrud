package com.a2z.services;

import java.util.List;

import com.a2z.model.StockDispatch;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.vo.StockDispatchVO;

public interface StockDispatchService {
	void doSaveStockDispatch(StockDispatchVO stockDispatchVO) throws BusinessServiceException;

	StockDispatchVO doGetStockDispatchById(Long id) throws BusinessServiceException;
	
	List<StockDispatch> doGetAllStockDispatch() throws BusinessServiceException;
	
}
