package com.a2z.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.dao.InventoryDAO;
import com.a2z.dao.StockDispatchDAO;
import com.a2z.dao.StockDispatchProductDAO;
import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.Inventory;
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
			System.out.println(stockDispatchVO.getInvoiceDetails());
			
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}

	}

}
