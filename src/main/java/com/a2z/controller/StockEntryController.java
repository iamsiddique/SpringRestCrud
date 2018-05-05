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
import com.a2z.model.StockEntry;
import com.a2z.services.StockEntryService;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.vo.ServiceResponse;

@Controller
@RequestMapping("/stockentry")
public class StockEntryController {

	@Autowired
	StockEntryService stockEntryService;

	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse saveProduct(@RequestBody StockEntry stockEntry) {
		ServiceResponse serviceResponse = null;
		try {
			stockEntryService.doSaveStockEntry(stockEntry);

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", stockEntry);

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
			List<StockEntry> stockEntryList = stockEntryService.doGetAllStockEntries();

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", stockEntryList);

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
	public @ResponseBody ServiceResponse deleteCC( @PathVariable(value = "id") Long id) {
		ServiceResponse serviceResponse = null;
		try {
			StockEntry stockEntry = stockEntryService.doGetStockEntryById(id);
			

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", stockEntry);

		} catch (BusinessServiceException e) {
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}

	@RequestMapping(value = "/couriercenterid/{id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getStockEntryByCourierCenter( @PathVariable(value = "id") Long id) {
		ServiceResponse serviceResponse = null;
		try {
			List<StockEntry> stockEntryList = stockEntryService.doGetStockEntriesByCourierCenter(id);
			

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", stockEntryList);

		} catch (BusinessServiceException e) {
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse updateStockEntry(@RequestBody StockEntry stockEntry) {
		ServiceResponse serviceResponse = null;
		try {
			stockEntryService.doUpdateStockEntry(stockEntry);

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", stockEntry);

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
