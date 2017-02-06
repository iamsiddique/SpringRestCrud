package com.a2z.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.dao.StockEntryDAO;
import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.Product;
import com.a2z.model.StockEntry;
import com.a2z.services.exception.BusinessServiceException;

@Service
public class StockEntryServiceImpl implements StockEntryService {
	@Autowired
	StockEntryDAO stockEntryDAO;

	@Override
	@Transactional
	public void doSaveStockEntry(StockEntry stockEntry) throws BusinessServiceException {
		try{
			stockEntryDAO.saveStockEntry(stockEntry);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
	}

	@Override
	@Transactional
	public List<StockEntry> doGetAllStockEntries() throws BusinessServiceException {
		List<StockEntry> stockEntryList = null;
		try {
			stockEntryList = stockEntryDAO.getAllStockEntries();

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return stockEntryList;

	}

	@Override
	@Transactional
	public StockEntry doGetStockEntryById(Long id) throws BusinessServiceException {
		StockEntry stockEntry =null;
		try{
			stockEntry = stockEntryDAO.getStockEntryById(id);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
		return stockEntry;
	}

	@Override
	@Transactional
	public void doUpdateStockEntry(StockEntry stockEntry) throws BusinessServiceException {
		try{
			stockEntryDAO.updateStockEntry(stockEntry);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
	}

}




