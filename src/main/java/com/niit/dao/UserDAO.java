package com.niit.dao;

import java.util.List;

//import com.niit.model.Category;
import com.niit.model.UserDetail;

public interface UserDAO {
	public boolean registerUser(UserDetail userDetail);
	public boolean updateUserDetail(UserDetail userDetail);
	public UserDetail getUserDetail(String username);
	public List<UserDetail> listUserDetails();
}
