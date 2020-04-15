package com.ms.board.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/security")
public class SecurityController {

	@GetMapping("/home")
	public ModelAndView home(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("security/index");
		
		String user = (String) session.getAttribute("user");
		model.addObject("user", user);
		
		return model;
	}
	
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required=false) String logout,
			Model model) {
				
		if(error != null) {
			model.addAttribute("error", "Login Fail");
		}
		if(logout != null) {
			model.addAttribute("logout", "Logout Success");
		}
		
		return "security/login";
	}

}
