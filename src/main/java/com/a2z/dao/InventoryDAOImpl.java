package com.a2z.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.Inventory;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveInventory(Inventory inventory) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(inventory);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

	@Override
	public List<Inventory> getAllInventories() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From Inventory").getResultList();
	}

	@Override
	public Inventory getInventoryById(Long id) throws DataServiceException {
		try {

			List<Inventory> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From Inventory p  where p.id=" + id).getResultList();

			for (Inventory inventory : list) {
				return inventory;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;

	}

	@Override
	public Inventory getInventoryByProductidCouriercenteridExpirydate(Long productId,Long courierCenterId,Date expiryDate) throws DataServiceException {
		try {

			
			String hql = "From Inventory i where i.product.id = :productId and i.courierCenter.id = :courierCenterId and i.expiryDate= :expiryDate";
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String finalDateStr=sdf.format(expiryDate);
			Date finalDate = null;
			try{
			finalDate = sdf.parse(finalDateStr)	;
			}catch(Exception e){
				
			}
			List<Inventory> list = this.sessionFactory.getCurrentSession().createQuery(hql)
			.setParameter("productId", productId)
			.setParameter("courierCenterId", courierCenterId)
			.setParameter("expiryDate", finalDate)
			.getResultList();
			
			
			for (Inventory inventory : list) {
				return inventory;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;

	}

	
	@Override
	public void updateInventory(Inventory inventory) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(inventory);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

}
