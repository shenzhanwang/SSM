package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pagemodel.User;
import service.LoginService;
import web.CaptchaUtil;
import pagemodel.MSG;

@Controller
public class Login {
	@Autowired
	LoginService loginservice;
	
	@RequestMapping(value="/loginvalidate",method = RequestMethod.POST)
	@ResponseBody
	public MSG loginvalidate(@ModelAttribute User u,HttpSession httpSession){
		String picode=(String) httpSession.getAttribute("rand");
		if(!picode.equalsIgnoreCase(u.getPic()))
			return new MSG("error code");
		if(u.getUsername()==null)
			return new MSG("username is null");
		String realpwd=loginservice.getpwdbyname(u.getUsername());
		if(realpwd!=null&&realpwd.equals(u.getPassword()))
		{
			httpSession.setAttribute("username", u.getUsername());
			return new MSG("success");
		}else
			return new MSG("error password");
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(){
		return "/html/login.html";
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(HttpSession httpSession){
		httpSession.removeAttribute("username");
		return "/html/login.html";
	}
	
	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        CaptchaUtil.outputCaptcha(request, response);
    }
	
	@RequestMapping(value="/current",method = RequestMethod.GET)
	@ResponseBody
	public MSG currentuser(HttpSession httpSession){
		String username=(String)httpSession.getAttribute("username");
		return new MSG(username);
	}
  }
