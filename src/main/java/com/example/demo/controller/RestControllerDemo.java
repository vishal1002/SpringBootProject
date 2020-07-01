package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.userDao;
import com.example.demo.model.User;
import com.example.demo.services.UserService;

@RestController
public class RestControllerDemo {
	
	@Autowired
	UserService userserv;
	
	@PostMapping("save-user")
	public String registerUser(@RequestBody User user) {
		userserv.addNewUser(user);
		return "Hello" + user.getUsername() + "your registration got successful";
	}
	
	@GetMapping("all-users")
	public List<User> getAllUsers(){
		return userserv.getAllUsers();
	}

	@GetMapping("delete-user/{username}")
	@Transactional
	public List<User> deleteUserNameByUsername(@PathVariable String username){
		return userserv.deleteByUsername(username);
	}
	
	@GetMapping("find-user/{username}")
	public User findByUserName(@PathVariable String username) {
		return userserv.findByUserName(username);
	}
	
}
