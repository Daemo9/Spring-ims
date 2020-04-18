package com.ims.dao;


import com.ims.beans.Category;

public interface UsersDAO {
	public boolean loginWithEmail(String email, String pass);
	
}
