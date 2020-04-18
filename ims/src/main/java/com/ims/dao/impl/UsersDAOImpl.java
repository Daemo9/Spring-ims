package com.ims.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ims.beans.Category;
import com.ims.beans.users;
import com.ims.dao.UsersDAO;

@Repository("userDAO")
public class UsersDAOImpl implements UsersDAO {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean loginWithEmail(String email, String pass) {
		boolean found = false;
		Session session = sessionFactory.openSession();
		String qry = "from users u where u.email =?0 and u.password = ?1";
		Query query = session.createQuery(qry);
		query.setParameter(0, email);
		query.setParameter(1, pass);
		List list = query.list();
		if(list!=null && list.size()>0)
			found = true;
		session.close();
		return found;
	}
}
