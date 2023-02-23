package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import java.util.List;

@Controller
public class HelloController {

	@Autowired
	UserService userService;


	@GetMapping(value = "/")
	public String showUsers(ModelMap modelMap) {

		List<User> users = userService.listUsers();
		modelMap.addAttribute("users", users);
		return "index";
	}

}