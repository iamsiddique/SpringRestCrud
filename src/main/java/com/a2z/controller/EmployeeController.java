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
import com.a2z.model.Employee;
import com.a2z.services.EmployeeService;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.util.FileUtil;
import com.a2z.util.StringUtil;
import com.a2z.vo.ServiceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	FileUtil fileUtil = new FileUtil();
	StringUtil stringUtil = new StringUtil();

	static final Logger logger = Logger.getLogger(EmployeeController.class);
	// String rootDirectory = "C:\\testUpload\\";

	@Value("${files_location}")
	private String rootDirectory;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse addEmployee(@RequestParam(value = "user") String userInfo,
			@RequestParam(value = "dl", required = false) MultipartFile dl, @RequestParam(value = "pan", required = false) MultipartFile pan,
			@RequestParam(value = "photo", required = false) MultipartFile photo) {
		ServiceResponse serviceResponse = null;
		ObjectMapper mapper = new ObjectMapper();

		System.out.println("Root Directory " + rootDirectory);

		try {
			Employee employee = mapper.readValue(userInfo, Employee.class);
			String dlUniqueFileName = null;
			String panUniqueFileName = null;
			String photoUniqueFileName = null;

			if (dl != null) {
				employee.setDlFileName(dl.getOriginalFilename());
				dlUniqueFileName = stringUtil.getUniqueString() + "."
						+ fileUtil.getFileExtension(dl.getOriginalFilename());
				employee.setDlUniqueFileName(dlUniqueFileName);
				dl.transferTo(new File(rootDirectory + dlUniqueFileName));
			}

			if (pan != null) {
				employee.setPanFileName(pan.getOriginalFilename());
				panUniqueFileName = stringUtil.getUniqueString() + "."
						+ fileUtil.getFileExtension(pan.getOriginalFilename());
				employee.setPanUniqueFileName(panUniqueFileName);
				pan.transferTo(new File(rootDirectory + panUniqueFileName));
			}

			if (photo != null) {
				employee.setPhotoFileName(photo.getOriginalFilename());
				photoUniqueFileName = stringUtil.getUniqueString() + "."
						+ fileUtil.getFileExtension(photo.getOriginalFilename());
				employee.setPhotoUniqueFileName(photoUniqueFileName);
				photo.transferTo(new File(rootDirectory + photoUniqueFileName));
			}

			employeeService.doSaveEmployee(employee);
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

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse updateEmployee(@RequestParam(value = "user") String userInfo,
			@RequestParam(value = "dl", required = false) MultipartFile dl,
			@RequestParam(value = "pan", required = false) MultipartFile pan,
			@RequestParam(value = "photo", required = false) MultipartFile photo, HttpServletRequest request) {
		ServiceResponse serviceResponse = null;
		ObjectMapper mapper = new ObjectMapper();
		OutputStream outputStream = null;

		System.out.println("Root Directory " + rootDirectory);

		try {

			Employee employee = mapper.readValue(userInfo, Employee.class);
			String dlUniqueFileName = null;
			String panUniqueFileName = null;
			String photoUniqueFileName = null;

			if (dl != null) {
				employee.setDlFileName(dl.getOriginalFilename());
				dlUniqueFileName = stringUtil.getUniqueString() + "."
						+ fileUtil.getFileExtension(dl.getOriginalFilename());
				employee.setDlUniqueFileName(dlUniqueFileName);
				dl.transferTo(new File(rootDirectory + dlUniqueFileName));
			}

			if (pan != null) {
				employee.setPanFileName(pan.getOriginalFilename());
				panUniqueFileName = stringUtil.getUniqueString() + "."
						+ fileUtil.getFileExtension(pan.getOriginalFilename());
				employee.setPanUniqueFileName(panUniqueFileName);
				pan.transferTo(new File(rootDirectory + panUniqueFileName));
			}

			if (photo != null) {
				employee.setPhotoFileName(photo.getOriginalFilename());
				photoUniqueFileName = stringUtil.getUniqueString() + "."
						+ fileUtil.getFileExtension(photo.getOriginalFilename());
				employee.setPhotoUniqueFileName(photoUniqueFileName);
				photo.transferTo(new File(rootDirectory + photoUniqueFileName));
			}

			employeeService.doUpdateEmployee(employee);

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
	public @ResponseBody ServiceResponse getEmployees() {
		ServiceResponse serviceResponse = null;
		try {
			System.out.println(rootDirectory);
			List<Employee> employeesList = employeeService.doGetAllActiveEmployees();
			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", employeesList);

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
	public @ResponseBody ServiceResponse deactivateEmployee(@PathVariable(value = "id") Long id) {
		ServiceResponse serviceResponse = null;
		try {
			employeeService.deactivateEmployee(id);
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
		Employee employee = null;
		String uniqueFileName = null;
		String fileName = null;
		try {
			employee = employeeService.doGetEmployeeWithUserById(id);
			if (name.equalsIgnoreCase("photo")) {
				uniqueFileName = employee.getPhotoUniqueFileName();
				fileName = employee.getPhotoFileName();
			} else if (name.equalsIgnoreCase("dl")) {
				uniqueFileName = employee.getDlUniqueFileName();
				fileName = employee.getDlFileName();
			} else if (name.equalsIgnoreCase("rc")) {
				uniqueFileName = employee.getPanUniqueFileName();
				fileName = employee.getPanFileName();
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
