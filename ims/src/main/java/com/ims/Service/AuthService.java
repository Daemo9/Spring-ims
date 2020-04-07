
package com.ims.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
