
package com.ims.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.beans.Category;
import com.ims.dao.ItemsDAO;
import com.ims.dao.UsersDAO;

@Service("authService")
public class AuthService {
	@Autowired
	private UsersDAO userDAO;

	public boolean checkUser(String email, String pass) {
		return userDAO.loginWithEmail(email, pass);
	}

	public void setUserDAO(UsersDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UsersDAO getUserDAO() {
		return userDAO;
	}
	
}
