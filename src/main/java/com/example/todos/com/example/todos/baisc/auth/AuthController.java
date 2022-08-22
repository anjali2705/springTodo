package com.example.todos.com.example.todos.baisc.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthController {
    
	@GetMapping("/basicAuth")
	public Authentication hello() {
		 return new Authentication("You are Authorized");
	}
}
