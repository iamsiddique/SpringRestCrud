package com.a2z.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

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
import com.a2z.services.CourierBoyService;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.util.FileUtil;
import com.a2z.util.StringUtil;
import com.a2z.vo.ServiceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/courierboy")
public class CourierBoyController {

	@Autowired
	CourierBoyService courierBoyService;

	FileUtil fileUtil = new FileUtil();
	StringUtil stringUtil = new StringUtil();

	static final Logger logger = Logger.getLogger(CourierBoyController.class);
	// String rootDirectory = "C:\\testUpload\\";

	@Value("${files_location}")
	private String rootDirectory;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse addCourierBoy(@RequestParam(value = "user") String userInfo,
			@RequestParam(value = "dl") MultipartFile dl, @RequestParam(value = "rc") MultipartFile rc,
			@RequestParam(value = "insurance") MultipartFile insurance, @RequestParam(value = "rt") MultipartFile rt,
			@RequestParam(value = "photo") MultipartFile photo) {
		ServiceResponse serviceResponse = null;
		ObjectMapper mapper = new ObjectMapper();

		System.out.println("Root Directory " + rootDirectory);

		try {
			CourierBoy courierBoy = mapper.readValue(userInfo, CourierBoy.class);
			courierBoy.setDlFileName(dl.getOriginalFilename());
			courierBoy.setRcFileName(rc.getOriginalFilename());
			courierBoy.setInsuranceFileName(insurance.getOriginalFilename());
			courierBoy.setPhotoFileName(photo.getOriginalFilename());
			courierBoy.setRoadtaxFileName(rt.getOriginalFilename());
			String dlUniqueFileName = stringUtil.getUniqueString() + "."
					+ fileUtil.getFileExtension(dl.getOriginalFilename());
			String rcUniqueFileName = stringUtil.getUniqueString() + "."
					+ fileUtil.getFileExtension(rc.getOriginalFilename());
			String insuranceUniqueFileName = stringUtil.getUniqueString() + "."
					+ fileUtil.getFileExtension(insurance.getOriginalFilename());
			String photoUniqueFileName = stringUtil.getUniqueString() + "."
					+ fileUtil.getFileExtension(photo.getOriginalFilename());
			String roadtaxUniqueFileName = stringUtil.getUniqueString() + "."
					+ fileUtil.getFileExtension(rt.getOriginalFilename());
			courierBoy.setDlUniqueFileName(dlUniqueFileName);
			courierBoy.setRcUniqueFileName(rcUniqueFileName);
			courierBoy.setInsuranceUniqueFileName(insuranceUniqueFileName);
			courierBoy.setPhotoUniqueFileName(photoUniqueFileName);
			courierBoy.setRoadtaxUniqueFileName(roadtaxUniqueFileName);

			courierBoyService.doSaveCourierBoy(courierBoy);
			serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", null);
			UUID.randomUUID().toString();
			dl.transferTo(new File(rootDirectory + dlUniqueFileName));
			rc.transferTo(new File(rootDirectory + rcUniqueFileName));
			insurance.transferTo(new File(rootDirectory + insuranceUniqueFileName));
			rt.transferTo(new File(rootDirectory + roadtaxUniqueFileName));
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

	
		
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse updateCourierBoy(@RequestParam(value = "user") String userInfo,@RequestParam(value = "dl", required=false) MultipartFile dl, @RequestParam(value = "rc", required=false) MultipartFile rc,
			@RequestParam(value = "insurance", required=false) MultipartFile insurance, @RequestParam(value = "rt", required=false) MultipartFile rt,
			@RequestParam(value = "photo", required=false) MultipartFile photo,
			HttpServletRequest request) {
		ServiceResponse serviceResponse = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			CourierBoy courierBoy = mapper.readValue(userInfo, CourierBoy.class);
			String dlUniqueFileName = null;
			String rcUniqueFileName = null;
			String insuranceUniqueFileName = null;
			String photoUniqueFileName = null;
			String roadtaxUniqueFileName = null;
			if (dl != null) {
				courierBoy.setDlFileName(dl.getOriginalFilename());
				dlUniqueFileName = stringUtil.getUniqueString() + "."
						+ fileUtil.getFileExtension(dl.getOriginalFilename());
				courierBoy.setDlUniqueFileName(dlUniqueFileName);
				dl.transferTo(new File(rootDirectory + dlUniqueFileName));
			}

			if (rc != null) {
				courierBoy.setRcFileName(rc.getOriginalFilename());
				rcUniqueFileName = stringUtil.getUniqueString() + "."
						+ fileUtil.getFileExtension(rc.getOriginalFilename());
				courierBoy.setRcUniqueFileName(rcUniqueFileName);
				rc.transferTo(new File(rootDirectory + rcUniqueFileName));
			}

			if (insurance != null) {
				courierBoy.setInsuranceFileName(insurance.getOriginalFilename());
				insuranceUniqueFileName = stringUtil.getUniqueString() + "."
						+ fileUtil.getFileExtension(insurance.getOriginalFilename());
				courierBoy.setInsuranceUniqueFileName(insuranceUniqueFileName);
				insurance.transferTo(new File(rootDirectory + insuranceUniqueFileName));
			}

			if (photo != null) {
				courierBoy.setPhotoFileName(photo.getOriginalFilename());
				photoUniqueFileName = stringUtil.getUniqueString() + "."
						+ fileUtil.getFileExtension(photo.getOriginalFilename());
				courierBoy.setPhotoUniqueFileName(photoUniqueFileName);
				photo.transferTo(new File(rootDirectory + photoUniqueFileName));
			}

			if (rt != null) {
				courierBoy.setRoadtaxFileName(rt.getOriginalFilename());
				roadtaxUniqueFileName = stringUtil.getUniqueString() + "."
						+ fileUtil.getFileExtension(rt.getOriginalFilename());
				courierBoy.setRoadtaxUniqueFileName(roadtaxUniqueFileName);
				rt.transferTo(new File(rootDirectory + roadtaxUniqueFileName));
			}

			courierBoyService.doUpdateCourierBoy(courierBoy);
			
			
			
			
			
			
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
	public @ResponseBody ServiceResponse getCourierBoys() {
		ServiceResponse serviceResponse = null;
		try {
			List<CourierBoy> courierBoysList = courierBoyService.doGetAllActiveCourierBoys();
			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", courierBoysList);

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

	@RequestMapping(value = "/deactivate/{id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse deactivateCourierBoy(@PathVariable(value = "id") Long id) {
		ServiceResponse serviceResponse = null;
		try {
			courierBoyService.deactivateCourierBoy(id);
			serviceResponse = ServiceResponseUtils.dataResponse("1", "user deactivated successfully", null);
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

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public Object saveUserDataAndFile(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {

		String rootDirectory = "D:\\testUpload\\";
		System.out.println("Root Directory " + rootDirectory);
		try {
			file.transferTo(new File(rootDirectory + file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/download/{name}/{id}", method = RequestMethod.GET)
	public void doDownload(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value = "id") Long id, @PathVariable(value = "name") String name) throws IOException {
		int BUFFER_SIZE = 4096;
		CourierBoy courierBoy = null;
		String uniqueFileName = null;
		String fileName = null;
		try {
			courierBoy = courierBoyService.doGetCourierBoyWithUserById(id);
			if (name.equalsIgnoreCase("photo")) {
				uniqueFileName = courierBoy.getPhotoUniqueFileName();
				fileName = courierBoy.getPhotoFileName();
			} else if (name.equalsIgnoreCase("dl")) {
				uniqueFileName = courierBoy.getDlUniqueFileName();
				fileName = courierBoy.getDlFileName();
			} else if (name.equalsIgnoreCase("rt")) {
				uniqueFileName = courierBoy.getRoadtaxUniqueFileName();
				fileName = courierBoy.getRoadtaxFileName();
			} else if (name.equalsIgnoreCase("rc")) {
				uniqueFileName = courierBoy.getRcUniqueFileName();
				fileName = courierBoy.getRcFileName();
			} else if (name.equalsIgnoreCase("insurance")) {
				uniqueFileName = courierBoy.getInsuranceUniqueFileName();
				fileName = courierBoy.getInsuranceFileName();
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
