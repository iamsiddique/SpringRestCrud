package com.a2z.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.a2z.controller.util.ServiceResponseUtils;
import com.a2z.model.Product;
import com.a2z.services.ProductService;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.util.FileUtil;
import com.a2z.util.StringUtil;
import com.a2z.vo.ServiceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@Value("${files_location}")
	private String rootDirectory;

	StringUtil stringUtil = new StringUtil();
	FileUtil fileUtil = new FileUtil();
	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse addCourierBoy(@RequestParam(value = "product") String productStr,
			@RequestParam(value = "photo") MultipartFile photo) {
		ServiceResponse serviceResponse = null;
		ObjectMapper mapper = new ObjectMapper();

		System.out.println("Root Directory " + rootDirectory);

		try {
			Product product = mapper.readValue(productStr, Product.class);
			product.setPhotoFileName(photo.getOriginalFilename());
			
			String photoUniqueFileName = stringUtil.getUniqueString() + "."
					+ fileUtil.getFileExtension(photo.getOriginalFilename());
			
			product.setPhotoUniqueFileName(photoUniqueFileName);
			
			productService.doSaveProduct(product);
			
			serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", null);
			UUID.randomUUID().toString();
			
			photo.transferTo(new File(rootDirectory + photoUniqueFileName));
		} catch (BusinessServiceException e) {
			// e.printStackTrace();
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getCause().getMessage());
			if (e.getCause().getMessage().contains("unique_username")) {
				serviceResponse = ServiceResponseUtils.dataResponse("0", "duplicate username", null);
			} else {
				serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);
			}

		} catch (Throwable e) {
			e.printStackTrace();
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);
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
