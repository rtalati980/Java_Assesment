package com.Assesment.demo.DAOImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Assesment.demo.DAO.UserDAO;
import com.Assesment.demo.model.User;
import com.Assesment.demo.repository.UserRepository;


@Service
public class UserDAOImpl implements UserDAO {
	
	
	@Autowired
    private UserRepository repo;

    @Override
    public List < User > getAllUser() {
        return repo.findAll();
    }

    @Override
    public void saveUser(User user) {
        this.repo.save(user);
    }

    @Override
    public User getUserById(long id) {
        Optional < User > optional = repo.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" User not found for id :: " + id);
        }
        return user;
    }

    
    
    @Override
    public void deleteUserById(long id) {
        this.repo.deleteById(id);
    }
    
    @Override
    public void update(User user)   
    {  
    this.repo.save(user);  
    }  
    
}
