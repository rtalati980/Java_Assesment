package com.Assesment.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Assesment.demo.DAO.UserDAO;
import com.Assesment.demo.DAOImpl.UserDAOImpl;
import com.Assesment.demo.exception.UserNotFoundException;
import com.Assesment.demo.model.User;


@RestController

@RequestMapping("/users")
public class UserListController {

//autowire the UserService class  
	
	@Autowired  
	UserDAOImpl  userImpl;  
	
	
	
	//creating a get mapping that retrieves all the users detail from the database  
	
	@GetMapping("/")
    public String showIndexPage() {
       return "index";
    }
	
	
	 @GetMapping("/create")
	 public String showCreatePage() 
	 { return "create"; }
	 
	 
	
	
	
	@PostMapping("/save")
    public String saveUser(
            @ModelAttribute User user,
            Model model
            ) {
		userImpl.saveUser(user);
		      
		// userImpl.saveUser(user);
		
		
		String message = "Record with  saved successfully !";
        model.addAttribute("message", message);
        return "create";
    }
	
	
	
	@GetMapping("/getAllUser") 
	
	
	public String getAllUser( @RequestParam(value = "message", required = false) String message,
        Model model){
		
		List<User> user = userImpl.getAllUser(); 
	
		model.addAttribute("list", user);
	       model.addAttribute("message", message);
	       return "view";
	    }
	

    @GetMapping("/edit")
    public String getEditPage(
            Model model,
            RedirectAttributes attributes,
            @RequestParam Long id
            ) {
       String page = null; 
       try {
       User user = userImpl.getUserById(id);
       model.addAttribute("user", user);
       page="editpage";
       } catch (UserNotFoundException e) {
           e.printStackTrace();
           attributes.addAttribute("message", e.getMessage());
           page="redirect:getAllUser";
       }
       return page; 
    }

    @PostMapping("/update")
    public String update(
            @ModelAttribute User user,
            RedirectAttributes attributes
            ) {
    	userImpl.update(user);
       long id = user.getId();
       attributes.addAttribute("message", "user is updated successfully !");
       return "redirect:getAllUser";
    } 
	  
	 

    @GetMapping("/delete")
    public String delete(
            @RequestParam Long id,
            RedirectAttributes attributes
            ) {
        try {
        	userImpl.deleteUserById(id);
        attributes.addAttribute("message", "Invoice with Id : '"+id+"' is removed successfully!");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
        }
        return "redirect:getAllUser";
    }
    
    

	}