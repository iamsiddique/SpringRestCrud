package com.a2z.dao;

import java.util.List;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.Product;

public interface ProductDAO {
	void saveProduct(Product product) throws DataServiceException;
	List<Product> getAllProducts() throws DataServiceException;
	Product getProductById(Long id) throws DataServiceException;
	void updateProduct(Product product) throws DataServiceException;
}
