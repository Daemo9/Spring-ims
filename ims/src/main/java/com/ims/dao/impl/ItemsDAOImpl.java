package com.ims.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ims.beans.Category;
import com.ims.beans.Items;
import com.ims.dao.ItemsDAO;

@Repository("itemsDAO")
public class ItemsDAOImpl implements ItemsDAO {
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		List<Category> catList = new ArrayList<Category>();
		Session session = sessionFactory.openSession();
		String qry = "select cat_id, cat_nm from category cat where cat.cat_actv ='Y'";
		Query query = session.createSQLQuery(qry);
		List list = query.list();
		if (list != null && list.size() > 0) {
			for (Object o : list) {
				Object[] oArr = (Object[]) o;
				// System.out.println(" Class : " + o.getClass() + " oArr[0] : " + oArr[0]);
				catList.add(new Category((int) oArr[0], (String) oArr[1]));
			}
		}
		// System.out.println("Category list in DAO : " + catList.size());
		session.close();
		return catList;

	}

	@Override
	public List<Items> getAllItems(int pageId, int max) {
		List<Items> items = new ArrayList<Items>();
		Session session = sessionFactory.openSession();
		String qry = "select i.itm_id, i.itm_desc, i.itm_actv, i.itm_created_dt, c.cat_nm,i.itm_cat_id from items i , category c\r\n"
				+ "where i.itm_cat_id = c.cat_id and\r\n" + "i.itm_actv ='Y' and\r\n"
				+ "c.cat_actv = 'Y' order by  i.itm_id  limit "+(pageId-1)+","+max ;
		 System.out.println(" Query : "+qry);
		Query query = session.createSQLQuery(qry);
		List list = query.list();
		if (list != null && list.size() > 0) {
			int srNo = 1;
			for (Object o : list) {
				Object[] oArr = (Object[]) o;
				Items itmObj = new Items();
				// System.out.println(" Class : " + o.getClass() + " oArr[0] : " + oArr[0]);
				// items.add(new Items(srNo++, (String)oArr[0], (String)oArr[1],
				// (String)oArr[2],(Date)oArr[3], (String)oArr[4]));
				// int srNo,String itmId, String itmDesc, String itmActv, Date itmCreatedDt,
				// String catName
				itmObj.setSrNo(srNo++);
				itmObj.setItmId((String) oArr[0]);
				itmObj.setItmDesc((String) oArr[1]);
				itmObj.setItmActv((String) oArr[2]);
				itmObj.setItmCreatedDt((Date) oArr[3]);
				itmObj.setCatName((String) oArr[4]);
				itmObj.setItmCatId(Integer.parseInt(oArr[5].toString()));
				items.add(itmObj);
			}
		}
		// System.out.println("Category list in DAO : " + items.size());
		session.close();
		return items;
	}

	@Override
	public void addItems(Items item) {
		// TODO Auto-generated method stub
		Date d = new Date(Calendar.getInstance().getTime().getTime());

		System.out.println("addItems called.. ..." + d);
		Session session = sessionFactory.openSession();
		Items obj = new Items();
		obj.setItmId(item.getItmId());
		obj.setItmCreatedDt(d);
		obj.setItmDesc(item.getItmDesc());
		obj.setItmCatId(item.getItmCatId());

		obj.setItmActv(item.getItmActv() != null ? (item.getItmActv().equals("on") ? "Y" : "N") : "N");
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteItems(String id) {
		System.out.println(" Itm Id to be deleted : " + id);
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Items itmObj = session.get(Items.class, id);
			if (itmObj != null)
				session.delete(itmObj);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public void editItems(Items item,String id) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Items itmObj = session.get(Items.class, id);
			System.out.println(id + "Before Item name : " + itmObj.getItmDesc());

			if (itmObj != null) {
				itmObj.setItmCatId(item.getItmCatId());
				itmObj.setItmDesc(item.getItmDesc());
				itmObj.setItmActv(item.getItmActv() != null ? (item.getItmActv().equals("on") ? "Y" : "N") : "N");
				session.saveOrUpdate(itmObj);
			}
			//System.out.println(id + "After Item name : " + itmObj.getItmDesc());

			 session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public Items editItemDetails(String id) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		Items itmObj = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			//itmObj = session.get(Items.class, id);
			itmObj = session.load(Items.class, id);
			System.out.println(id + " Item name : " + itmObj.getItmDesc());
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null)
				session.close();
		}
		return itmObj;
	}

	@Override
	public int getTotalRecords() {
		int count = 0;
		Session session = sessionFactory.openSession();
		String qry = "select count(*) from items i where i.itm_actv ='Y'";
		// System.out.println(" Query : "+qry);
		Query query = session.createSQLQuery(qry);
		
		List list = query.list();
		if (list != null && list.size() > 0) {
			
			count =Integer.parseInt(list.get(0).toString());
		}
		session.close();
		return count;
	}
}
