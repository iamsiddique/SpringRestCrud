package com.a2z.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.dao.ProductDAO;
import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.CourierBoy;
import com.a2z.model.CourierCenter;
import com.a2z.model.Product;
import com.a2z.services.exception.BusinessServiceException;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO productDAO;

	@Override
	@Transactional
	public void doSaveProduct(Product product) throws BusinessServiceException {
		try{
			productDAO.saveProduct(product);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
	}

	@Override
	@Transactional
	public List<Product> doGetAllProducts() throws BusinessServiceException {
		List<Product> productList = null;
		try {
			productList = productDAO.getAllProducts();

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return productList;
	}

	@Override
	@Transactional
	public Product doGetProductById(Long id) throws BusinessServiceException {
		Product product =null;
		try{
			product = productDAO.getProductById(id);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
		return product;
	}

	@Override
	@Transactional
	public void doUpdateProduct(Product product) throws BusinessServiceException {
		try{
			productDAO.updateProduct(product);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
	} 
	
		
	
}




