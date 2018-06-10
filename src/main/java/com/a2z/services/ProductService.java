package com.a2z.services;

import java.util.List;

import com.a2z.model.Product;
import com.a2z.services.exception.BusinessServiceException;

public interface ProductService {
	void doSaveProduct(Product product) throws BusinessServiceException;
	List<Product> doGetAllProducts() throws BusinessServiceException;
	List<Product> doGetProductsByCourierCenter(Long courierCenterId) throws BusinessServiceException;
	Product doGetProductById(Long id) throws BusinessServiceException;
	void doUpdateProduct(Product product) throws BusinessServiceException;
}
