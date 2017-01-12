package com.cakeshop.dao;

import java.util.List;

import com.cakeshop.model.User;

public interface UserDAO  {
public List<User> getUsers();
public User getUserById(String id);
public User isValid(String id, String password);
public boolean save(User user);
public boolean delete(User user);
public boolean update(User user);

}
