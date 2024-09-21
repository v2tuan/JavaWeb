package vn.iostar.dao;

import java.util.List;

import vn.iostar.models.UserModel;

public interface IUserDao {
	
	List<UserModel> findAll();
	
	UserModel findByID(int id);
	
	void insert(UserModel user);
	
	UserModel findByUserName(String username);

	boolean checkExistUsername(String username);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistPhone(String phone);
}
