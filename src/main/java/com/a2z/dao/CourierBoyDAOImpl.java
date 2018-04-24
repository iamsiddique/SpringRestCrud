package com.a2z.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.CourierBoy;
import com.a2z.vo.CourierBoyDetailsVO;

@Repository
public class CourierBoyDAOImpl implements CourierBoyDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveCourierBoy(CourierBoy courierBoy) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(courierBoy);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
	}
	
	@Override
	public void updateCourierBoy(CourierBoy courierBoy) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(courierBoy);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
	}

	@Override
	public List<CourierBoy> getAllCourierBoys() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From CourierBoy").getResultList();
	}

	@Override
	@Transactional
	public List<CourierBoy> getAllActiveCourierBoys() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From CourierBoy where enable=1").getResultList();
	}

	@Override
	public CourierBoy getCourierBoyWithUserById(Long id) throws DataServiceException {
		try {

			List<CourierBoy> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From CourierBoy cb join fetch cb.user where cb.id=" + id).getResultList();

			for (CourierBoy courierBoy : list) {
				return courierBoy;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}

	@Override
	public Long getCourierBoyIdByUserById(Long id) throws DataServiceException {
		try {

			List<Object> list = this.sessionFactory.getCurrentSession()
					.createQuery("Select cb.id From CourierBoy cb where cb.user.id=" + id).getResultList();

			for (Object obj : list) {
				return (Long)obj;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}

	@Override
	@Transactional
	public List<CourierBoyDetailsVO> getAllCourierBoysWithCourierDetails() throws DataServiceException {
		List<CourierBoyDetailsVO> courierBoyDetailsVOList = new ArrayList<CourierBoyDetailsVO>();
		try {		
			List<Object[]> list = this.sessionFactory.getCurrentSession()
					.createQuery("Select cb,(select count(*) from CourierBoyInvoices cbi where cbi.courierBoy.id = cb.id and cbi.courierStatus='A'),(select count(*) from CourierBoyInvoices cbi where cbi.courierBoy.id = cb.id and cbi.courierStatus='D'),(select count(*) from CourierBoyInvoices cbi where cbi.courierBoy.id = cb.id and cbi.courierStatus='P') From CourierBoy cb where cb.enable=1").getResultList();
			System.out.println(list);
			for (Object[] obj : list) {
				CourierBoy cb = (CourierBoy)obj[0];
				Long assigned= (Long)obj[1];
				Long delivered= (Long)obj[2];
				Long paid= (Long)obj[3];
				CourierBoyDetailsVO courierBoyDetailsVO = new CourierBoyDetailsVO();
				courierBoyDetailsVO.setCourierBoy(cb);
				courierBoyDetailsVO.setAssigned(assigned);
				courierBoyDetailsVO.setDelivered(delivered);
				courierBoyDetailsVO.setPaid(paid);
				courierBoyDetailsVOList.add(courierBoyDetailsVO);
			}
			
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return courierBoyDetailsVOList;
	}
}
