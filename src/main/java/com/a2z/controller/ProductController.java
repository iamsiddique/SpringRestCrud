package com.a2z.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.a2z.controller.util.ServiceResponseUtils;
import com.a2z.model.CourierBoy;
import com.a2z.model.Product;
import com.a2z.services.CourierBoyService;
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
	
	@Autowired
	CourierBoyService courierBoyService;

	StringUtil stringUtil = new StringUtil();
	FileUtil fileUtil = new FileUtil();
	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse updateCourierBoy(@RequestParam(value = "product") String productInfo,@RequestParam(value = "dl", required=false) MultipartFile dl, 	
			@RequestParam(value = "photo", required=false) MultipartFile photo,
			HttpServletRequest request) {
		ServiceResponse serviceResponse = null;
		ObjectMapper mapper = new ObjectMapper();
		OutputStream outputStream = null;

		System.out.println("Root Directory " + rootDirectory);

		try {
			
			Product product = mapper.readValue(productInfo, Product.class);
			String dlUniqueFileName = null;
			String photoUniqueFileName = null;
	
			

	
			if (photo != null) {
				product.setPhotoFileName(photo.getOriginalFilename());
				photoUniqueFileName = stringUtil.getUniqueString() + "."
						+ fileUtil.getFileExtension(photo.getOriginalFilename());
				product.setPhotoUniqueFileName(photoUniqueFileName);
				photo.transferTo(new File(rootDirectory + photoUniqueFileName));
			}

	
			productService.doSaveProduct(product);
			
			
			
			
			
			
			
			serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", null);
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
	
	@RequestMapping(value = "/download/{name}/{id}", method = RequestMethod.GET)
	public void doDownload(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value = "id") Long id, @PathVariable(value = "name") String name) throws IOException {
		int BUFFER_SIZE = 4096;
		Product product = null;
		String uniqueFileName = null;
		String fileName = null;
		try {
			product = productService.doGetProductById(id);
			if (name.equalsIgnoreCase("photo")) {
				uniqueFileName = product.getPhotoUniqueFileName();
				fileName = product.getPhotoFileName();
			} 
		} catch (BusinessServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		ServletContext context = request.getServletContext();
		String fullPath = rootDirectory + uniqueFileName;
		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);

		// get MIME type of the file
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());
		System.out.println(downloadFile.length());

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", fileName);
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outStream.close();

	}


}
