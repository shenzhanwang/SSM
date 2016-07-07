package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Login {

	@RequestMapping("/loginvalidate")
	public String loginvalidate(@RequestParam("username") String username,@RequestParam("password") String pwd,Model model){
		if(username==null)
			return "login";
		if(username.equals("wsz"))
		{
			return "showactor";
		}else
			return "fail";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
 }
