package com.example.Controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.userService;
import com.example.entity.UserDetailsModel;

@RestController
public class HomeController {
	
	@Autowired
	private userService userService;
	
	@PostMapping(value="/saveUser")
	public Map<String,Object> saveUserDetails(@RequestBody UserDetailsModel userDetailsModel) {
		
		
		return userService.saveUserDetails(userDetailsModel);
		
	}
	
	@GetMapping(value="/getUser")
	public Iterable<UserDetailsModel> getUserDetails() {
		
		
		return userService.getUserDetails();
		
	}

}
