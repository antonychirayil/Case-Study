package com.userservice.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;




	@RestController
	@RequestMapping("/users")
	public class UserController {

		@Autowired
		private UserRepository userRepository;
		
		 @Autowired
		 RestTemplate restTemplate;

		  	//getusers
		    @GetMapping(value = "/userlist")
		    public List<User> getAllUsers(){
		        return userRepository.findAll();
		    }
		    //addUsers
		    @PostMapping(value = "/addUser")
		    public String addUser(@RequestBody User user){
		        userRepository.save(user);
		        return "user Added Succesfully";
		    }
		    //deleteUsers
		    @DeleteMapping(value = "/delete/{userID}")
		    public String deleteUser(@PathVariable String userID) {
		        System.out.println("Delete method called");
		        userRepository.deleteById(userID);
		        return "Deleted Successfully";
		    }
		    //updateUser
		    @PutMapping(value = "/update/{userID}")
		    public String updateUser(@RequestBody User user, @PathVariable String userID){
		        userRepository.save(user);
		        return "user is Updated Succesfully";
		    }
	}

