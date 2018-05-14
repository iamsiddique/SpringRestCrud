package com.a2z.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.dao.InventoryDAO;
import com.a2z.dao.StockDispatchDAO;
import com.a2z.dao.StockDispatchProductDAO;
import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.Inventory;
import com.a2z.model.PhoneAddress;
import com.a2z.model.StockDispatch;
import com.a2z.model.StockDispatchProduct;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.vo.StockDispatchVO;

@Service
public class StockDispatchServiceImpl implements StockDispatchService {

	@Autowired
	StockDispatchDAO stockDispatchDAO;
	
	@Autowired
	StockDispatchProductDAO stockDispatchProductDAO;
	
	@Autowired
	InventoryDAO inventoryDAO;
	
	@Autowired
	PhoneAddressService phoneAddressService;

	@Override
	@Transactional
	public void doSaveStockDispatch(StockDispatchVO stockDispatchVO) throws BusinessServiceException {
		// TODO Auto-generated method stub
		try{
			stockDispatchDAO.saveStockDispatch(stockDispatchVO.getInvoiceDetails());
			for(StockDispatchProduct dispatchProduct : stockDispatchVO.getProducts()){
				StockDispatchProduct product = dispatchProduct;
				product.setStockDispatch(stockDispatchVO.getInvoiceDetails());
				stockDispatchProductDAO.saveStockDispatchProduct(product);
				Inventory inventory = inventoryDAO.getInventoryByProductidCouriercenteridExpirydate(product.getProduct().getId(),stockDispatchVO.getInvoiceDetails().getCourierCenter().getId(), product.getExpiryDate());
			    if(inventory==null){
			    	
			    }else{
			    	Long updatedQuatity = inventory.getQuantity()-product.getQuantity();
			    	inventory.setQuantity(updatedQuatity);
			    	inventoryDAO.updateInventory(inventory);
			    }
			}
			PhoneAddress phoneAddress = new PhoneAddress();
			phoneAddress.setPhone(stockDispatchVO.getInvoiceDetails().getMobileNo());
			phoneAddress.setAddress(stockDispatchVO.getInvoiceDetails().getToAddress());
			phoneAddressService.doSavePhoneAddress(phoneAddress);
			System.out.println(stockDispatchVO.getInvoiceDetails());
			
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}

	}
	
	@Override
	@Transactional
	public StockDispatchVO doGetStockDispatchById(Long id) throws BusinessServiceException {
		StockDispatch stockDispatch =null;
		StockDispatchVO stockDispatchVO = null;
		try{
			
			stockDispatch = stockDispatchDAO.getStockDispatchById(id);
			if(stockDispatch!=null){
				stockDispatchVO = new StockDispatchVO();
				stockDispatchVO.setInvoiceDetails(stockDispatch);
				List <StockDispatchProduct> products = stockDispatchProductDAO.getStockDispatchProductsByStockDispatchId(stockDispatch.getId());
				stockDispatchVO.setProducts(products);
			}
			
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
		return stockDispatchVO;
	}

	@Override
	@Transactional
	public List<StockDispatch> doGetAllStockDispatch() throws BusinessServiceException {
		List<StockDispatch> stockDispatchList = null;
		try{
			stockDispatchList = stockDispatchDAO.getAllStockDispatch();
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		return stockDispatchList;
	}

}
