package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.userDao;
import com.example.demo.model.User;

@Service
public class UserService {
	
	@Autowired
	userDao userdao;
	
	
	public void addNewUser(User user) {
		userdao.save(user);
	}
	
	public List<User> getAllUsers() {
		return userdao.findAll();
	}
	public List<User> deleteByUsername(String usernm) {
		userdao.deleteByUsername(usernm);
		return userdao.findAll();
	}	
	public User findByUserName(String usrnm) {
		return userdao.findByUsername(usrnm);
	}
}
