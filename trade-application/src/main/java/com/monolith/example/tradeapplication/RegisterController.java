package com.monolith.example.tradeapplication;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
	Map<String, User> hm  = new HashMap<>();
	public RegisterController() {
		// TODO Auto-generated constructor stub
		User user = new User("govind","123","govin@gmail.com");
		hm.put("govind", user);
	}
	@RequestMapping(value = "/users/register", method=RequestMethod.POST)
	@ResponseBody
	public String registerUser(@ModelAttribute("userId")String userId, @ModelAttribute("password")
	String password,@ModelAttribute("email")String email){
		User user = new User(userId,password,email);
		hm.put(userId, user);
		
		
		return "<html><body bgcolor='Azure'>Registered Successfully "
				+" "+ "<a href= 'http://localhost:8080/index.html'> home to login</a></body></html>";
	}
	@RequestMapping(value = "/users/login", method=RequestMethod.POST)

	public String loginUser(@ModelAttribute("userId")String userId, @ModelAttribute("password") String password
			, HttpServletRequest request){
		
		User user = hm.get(userId);
		request.getSession().setAttribute("user", user);
		if(user!= null){
			if(user.getPassword().equals(password)){
				return "trade";
			}
			else{
				return "passwordError";
			}
		}
		else{
			return "sorry";
		}
		
	}
	@RequestMapping(value="/user/all", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, User> getAllRegisteredUser(){
		
		return hm;
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable("id") String userId){
		User user = hm.get(userId);
		return user;
	}
}
