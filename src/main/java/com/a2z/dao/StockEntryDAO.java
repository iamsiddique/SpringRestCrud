package com.a2z.dao;

import java.util.List;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.StockEntry;

public interface StockEntryDAO {
	void saveStockEntry(StockEntry stockEntry) throws DataServiceException;
	List<StockEntry> getAllStockEntries() throws DataServiceException;
	StockEntry getStockEntryById(Long id) throws DataServiceException;
	void updateStockEntry(StockEntry stockEntry) throws DataServiceException;
}
