package com.a2z.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.dao.CourierBoyDAO;
import com.a2z.dao.UserDAO;
import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.CourierBoy;
import com.a2z.model.SeedRole;
import com.a2z.model.User;
import com.a2z.services.exception.BusinessServiceException;
import com.a2z.vo.CourierBoyDetailsVO;

@Service
public class CourierBoyServiceImpl implements CourierBoyService {
	@Autowired
	CourierBoyDAO courierBoyDAO; 
	@Autowired
	UserDAO userDAO; 
	
	@Override
	@Transactional
	public void doSaveCourierBoy(CourierBoy courierBoy) throws BusinessServiceException {
		try{
			User user = courierBoy.getUser();
			SeedRole seedRole = new SeedRole();
			seedRole.setId(2);
			user.setSeedRole(seedRole);
			userDAO.saveUser(user);
			
			courierBoy.setUser(user);
			courierBoy.setEnable(1);
			courierBoyDAO.saveCourierBoy(courierBoy);
			
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
	}

	
	@Override
	@Transactional
	public void doUpdateCourierBoy(CourierBoy courierBoy) throws BusinessServiceException {
		try{
			String password = courierBoy.getUser().getPassword();
			CourierBoy courierBoyFromDao = courierBoyDAO.getCourierBoyWithUserById(courierBoy.getId());
			courierBoy.setUser(courierBoyFromDao.getUser());
			courierBoy.getUser().setPassword(password);
			courierBoy.setEnable(courierBoyFromDao.getEnable());
			if(courierBoy.getDlFileName()==null){
				courierBoy.setDlFileName(courierBoyFromDao.getDlFileName());
				courierBoy.setDlUniqueFileName(courierBoyFromDao.getDlUniqueFileName());
			}if(courierBoy.getInsuranceFileName()==null){
				courierBoy.setInsuranceFileName(courierBoyFromDao.getInsuranceFileName());
				courierBoy.setInsuranceUniqueFileName(courierBoyFromDao.getInsuranceUniqueFileName());
			}if(courierBoy.getPhotoFileName()==null){
				courierBoy.setPhotoFileName(courierBoyFromDao.getPhotoFileName());
				courierBoy.setPhotoUniqueFileName(courierBoyFromDao.getPhotoUniqueFileName());
			}if(courierBoy.getRcFileName()==null){
				courierBoy.setRcFileName(courierBoyFromDao.getRcFileName());
				courierBoy.setRcUniqueFileName(courierBoyFromDao.getRcUniqueFileName());
			}if(courierBoy.getRoadtaxFileName()==null){
				courierBoy.setRoadtaxFileName(courierBoyFromDao.getRoadtaxFileName());
				courierBoy.setRoadtaxUniqueFileName(courierBoyFromDao.getRoadtaxUniqueFileName());
			}
			userDAO.saveUser(courierBoy.getUser());
			User user = new User();
			user.setId(courierBoy.getUser().getId());
			courierBoy.setUser(user);
			courierBoyDAO.updateCourierBoy(courierBoy);
			
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
	}
	

	@Override
	@Transactional
	public List<CourierBoy> doGetAllCourierBoys() throws BusinessServiceException {
		// TODO Auto-generated method stub
		List<CourierBoy> courierBoysList =null;
		try{
			courierBoysList = courierBoyDAO.getAllCourierBoys();
			
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		return courierBoysList;
	}
	
	
	@Override
	public List<CourierBoy> doGetAllActiveCourierBoys() throws BusinessServiceException {
		// TODO Auto-generated method stub
		List<CourierBoy> courierBoysList =null;
		List<CourierBoy> finalCourierBoysList =new ArrayList<CourierBoy>();
		try{
			courierBoysList = courierBoyDAO.getAllActiveCourierBoys();
			for(CourierBoy courierBoy : courierBoysList){
				if(courierBoy.getUser()!=null)
				courierBoy.getUser().setPassword(null);
				
				finalCourierBoysList.add(courierBoy);
			}
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		return finalCourierBoysList;
	}
	
	@Override
	public List<CourierBoyDetailsVO> doGetAllCourierBoysWithCourierDetails() throws BusinessServiceException {
		// TODO Auto-generated method stub
		List<CourierBoyDetailsVO> courierBoysList =null;
		List<CourierBoyDetailsVO> finalCourierBoysList =new ArrayList<CourierBoyDetailsVO>();
		try{
			courierBoysList = courierBoyDAO.getAllCourierBoysWithCourierDetails();
			for(CourierBoyDetailsVO courierBoyDetailsVO : courierBoysList){
				if(courierBoyDetailsVO.getCourierBoy().getUser()!=null)
					courierBoyDetailsVO.getCourierBoy().getUser().setPassword(null);
				finalCourierBoysList.add(courierBoyDetailsVO);
			}
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		return finalCourierBoysList;
	}
	
	
	@Override
	@Transactional
	public CourierBoy deactivateCourierBoy(Long id) throws BusinessServiceException {
		// TODO Auto-generated method stub
		CourierBoy courierBoy =null;
		try{
			courierBoy = courierBoyDAO.getCourierBoyWithUserById(id);
			courierBoy.setEnable(0);
			courierBoyDAO.saveCourierBoy(courierBoy);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		return courierBoy;
	}


	@Override
	@Transactional
	public CourierBoy doGetCourierBoyWithUserById(Long id) throws BusinessServiceException {
		CourierBoy courierBoy =null;
		try{
			courierBoy = courierBoyDAO.getCourierBoyWithUserById(id);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
		return courierBoy;
	}
	
	
}




