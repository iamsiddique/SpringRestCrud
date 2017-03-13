package com.a2z.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a2z.controller.util.ServiceResponseUtils;
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

		
	
}
