package com.a2z.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a2z.controller.util.ServiceResponseUtils;
import com.a2z.model.StockDispatch;
import com.a2z.services.StockDispatchService;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.vo.ServiceResponse;
import com.a2z.vo.StockDispatchVO;

@Controller
@RequestMapping("/stockdispatch")
public class StockDispatchController {
	
	@Autowired
	StockDispatchService stockDispatchService;
	

	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse saveProduct(@RequestBody StockDispatchVO stockDispatchVO) {
		ServiceResponse serviceResponse = null;
		try {
			stockDispatchService.doSaveStockDispatch(stockDispatchVO);
			

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", stockDispatchVO);

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
	public @ResponseBody ServiceResponse getEmployees() {
		ServiceResponse serviceResponse = null;
		try {
			
			List<StockDispatch> stockDispatchList=stockDispatchService.doGetAllStockDispatch();	
			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", stockDispatchList);

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
	
	@RequestMapping(value = "/list/couriercenter/{id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getStockDispatchListByCCId(@PathVariable(value = "id") Long id) {
		ServiceResponse serviceResponse = null;
		try {
			
			List<StockDispatch> stockDispatchList=stockDispatchService.getStockDispatchesByCourierCenter(id);	
			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", stockDispatchList);

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
	
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse deactivateCourierBoy(@PathVariable(value = "id") Long id) {
		ServiceResponse serviceResponse = null;
		try {
			StockDispatchVO stockDispatchVO = stockDispatchService.doGetStockDispatchById(id);
			
			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrieved successfully", stockDispatchVO);
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
