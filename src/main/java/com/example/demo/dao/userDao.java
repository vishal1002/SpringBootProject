package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.User;

@Repository
public interface userDao extends JpaRepository<User, Long> {
	
	public List<User> deleteByUsername(String username);
	public User findByUsername(String username);

}
