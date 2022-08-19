package com.niit.authenticationservice.service;

import com.niit.authenticationservice.domain.User;
import com.niit.authenticationservice.exception.UserNotFoundException;

import java.util.List;


public interface UserService {

  public User saveUser(User user);
  public User findByUsernameAndPassword(String username , String password) throws UserNotFoundException;
  List<User> getAllUsers();

//  boolean validateUser(String username, String password) throws UserNotFoundException;

}
