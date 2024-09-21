package vn.iostar.services;

import vn.iostar.dao.impl.UserDaoImpl;
import vn.iostar.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	
	UserModel findByUserName(String username);
	
	void insert(UserModel user);
	
	boolean register(String email, String password, String username, String
	fullname, String phone);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);

}
