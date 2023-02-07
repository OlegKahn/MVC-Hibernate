package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


	@GetMapping(value = "new")
	public String writeNewUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "secondPage";
	}


	@GetMapping(value = "/saveUser")
	public String saveUser(@ModelAttribute User user) {
		userService.add(user);
		return "redirect:/";
	}


	@GetMapping(value = "/delete")
	public String deleteUser(@RequestParam("userId") long id) {
		userService.delete(id);
		return "redirect:/";
	}


	@GetMapping(value = "/update")
	public String updateUser(@RequestParam("userId") long id, Model model) {
		model.addAttribute(userService.getUser(id));
		return "secondPage";
	}
}