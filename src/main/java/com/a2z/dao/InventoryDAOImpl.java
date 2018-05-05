package com.a2z.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.a2z.dao.exception.DataServiceException;
import com.a2z.model.Inventory;
import com.a2z.model.Product;

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

	@Override
	public List<Inventory> getInventoryByCouriercenterid(Long courierCenterId) throws DataServiceException {
		String hql = "From Inventory i where i.courierCenter.id = :courierCenterId";
	
		List<Inventory> list = this.sessionFactory.getCurrentSession().createQuery(hql)
		.setParameter("courierCenterId", courierCenterId)
		.getResultList();
		
		return list;
	}

	@Override
	public List<Inventory> getAllInventoriesSql() throws DataServiceException {
		try {
			SQLQuery query =this.sessionFactory.getCurrentSession().createSQLQuery("select inventory.product_id,inventory.quantity,p.name,p.code from (select entry.product_id,entry.courier_center_id,entry.quantity-ifnull(dispatch.quantity,0) as quantity FROM (select courier_center_id,product_id,expiry_date,SUM(quantity) as quantity from stock_entry group by courier_center_id,product_id,expiry_date) AS entry left join (select sd.courier_center_id as courier_center_id,sdp.product_id as product_id,sdp.expiry_date as expiry_date,SUM(sdp.quantity) as quantity from stock_dispatch sd, stock_dispatch_products sdp where sd.Id = sdp.stock_dispatch_id group by courier_center_id,product_id,expiry_date) AS dispatch on entry.courier_center_id=dispatch.courier_center_id and entry.product_id = dispatch.product_id and entry.expiry_date=dispatch.expiry_date) as inventory, products p where p.Id=inventory.product_id");
			List<Object[]> rows = query.list();
			System.out.println(rows);
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}
	
	@Override
	public List<Inventory> getInventoryByCouriercenteridSql(Long courierCenterId) throws DataServiceException {
		
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		try {
			SQLQuery query =this.sessionFactory.getCurrentSession().createSQLQuery("select inventory.product_id,inventory.quantity,p.name,p.code,inventory.expiry_date from (select entry.product_id,entry.courier_center_id,entry.expiry_date,entry.quantity-ifnull(dispatch.quantity,0) as quantity FROM (select courier_center_id,product_id,expiry_date,SUM(quantity) as quantity from stock_entry group by courier_center_id,product_id,expiry_date) AS entry left join (select sd.courier_center_id as courier_center_id,sdp.product_id as product_id,sdp.expiry_date as expiry_date,SUM(sdp.quantity) as quantity from stock_dispatch sd, stock_dispatch_products sdp where sd.Id = sdp.stock_dispatch_id group by courier_center_id,product_id,expiry_date) AS dispatch on entry.courier_center_id=dispatch.courier_center_id and entry.product_id = dispatch.product_id and entry.expiry_date=dispatch.expiry_date) as inventory, products p where p.Id=inventory.product_id and inventory.courier_center_id="+courierCenterId);
			List<Object[]> rows = query.list();
			for(Object[] row : rows){
				Inventory inventory = new Inventory();
				inventory.setQuantity(Long.parseLong(row[1].toString()));
				Product product = new Product();
				product.setId(Long.parseLong(row[0].toString()));
				product.setName(row[2].toString());
				product.setCode(row[3].toString());
				inventory.setProduct(product);
				inventory.setExpiryDate((Date)row[4]);
				inventoryList.add(inventory);
			}
			
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return inventoryList;
	}

}
