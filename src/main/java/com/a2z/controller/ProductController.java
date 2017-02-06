package com.a2z.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a2z.controller.util.ServiceResponseUtils;
import com.a2z.model.Product;
import com.a2z.services.ProductService;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.vo.ServiceResponse;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse saveProduct(@RequestBody Product product) {
		ServiceResponse serviceResponse = null;
		try {
			productService.doSaveProduct(product);

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", product);

		} catch (BusinessServiceException e) {
			// e.printStackTrace();
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getAllProducts() {
		ServiceResponse serviceResponse = null;
		try {
			List<Product> productList = productService.doGetAllProducts();

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", productList);

		} catch (BusinessServiceException e) {
			// e.printStackTrace();
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}

	
	
}
