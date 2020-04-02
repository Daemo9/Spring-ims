package com.ims.dao;

import com.ims.model.users;

public interface UsersDAO {
	public boolean loginWithEmail(String email, String pass);
}
