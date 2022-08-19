package com.niit.authenticationservice.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.authenticationservice.domain.User;
import com.niit.authenticationservice.exception.UserNotFoundException;
import com.niit.authenticationservice.service.SecurityTokenGenerator;
import com.niit.authenticationservice.service.UserService;


@RestController
public class UserController {

 
  private UserService userService;
  private SecurityTokenGenerator securityTokenGenerator;


  @Autowired
  public UserController(UserService userService , SecurityTokenGenerator securityTokenGenerator)
  {
    this.userService = userService;
    this.securityTokenGenerator = securityTokenGenerator;
  }


  //Should only give username and password
  @PostMapping("/login")
  public ResponseEntity loginUser(@RequestBody User user) throws UserNotFoundException {

    Map<String, String> map = null;
    ResponseEntity responseEntity;
	try {
      User userObj = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
      if (userObj.getUsername().equals(user.getUsername())) {
        map = securityTokenGenerator.generateToken(user);
      }
      responseEntity = new ResponseEntity(map, HttpStatus.OK);
    }
  catch(UserNotFoundException e){
      throw new UserNotFoundException();
  }
    catch (Exception e){
      responseEntity = new ResponseEntity("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return responseEntity;
  }

  // first step - register the user
  @PostMapping("/register")
  public ResponseEntity saveUser(@RequestBody User user) {

    User createdUser = userService.saveUser(user);
      return new ResponseEntity("User Created" , HttpStatus.CREATED);
  }

  @GetMapping("/api/v1/userservice/users")
  public ResponseEntity getAllUsers(HttpServletRequest request){

    List<User> list =  userService.getAllUsers();
    return new ResponseEntity(list,HttpStatus.OK);
    

  }



}
