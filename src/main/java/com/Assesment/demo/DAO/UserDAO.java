package com.Assesment.demo.DAO;

import java.util.List;

import com.Assesment.demo.model.User;

public interface UserDAO {
	
	   List < User > getAllUser();
	    void saveUser(User user);
	    User getUserById(long id);
	    public void update(User user);
	    void deleteUserById(long id);

}
