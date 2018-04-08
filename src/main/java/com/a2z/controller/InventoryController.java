package com.a2z.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a2z.controller.util.ServiceResponseUtils;
import com.a2z.model.Inventory;
import com.a2z.services.InventoryService;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.vo.ServiceResponse;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;

	static final Logger logger = Logger.getLogger(UserController.class);

	
	@RequestMapping(value = "/couriercenterid/{id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getStockEntryByCourierCenter( @PathVariable(value = "id") Long id) {
		ServiceResponse serviceResponse = null;
		try {
			List<Inventory> inventoryList = inventoryService.doGetInventoryByCourierCenter(id);
			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", inventoryList);
		} catch (BusinessServiceException e) {
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}
	
	
}
