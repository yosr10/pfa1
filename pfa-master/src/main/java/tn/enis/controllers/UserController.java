package tn.enis.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.User;
import tn.enis.service.UserService;


@RestController
@RequestMapping("/admin/")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@Value("${myapp.role.admin}")
	private String adminRole;

	@Value("${myapp.role.user}")
	private String userRole;

	@RequestMapping(value = { "/users" }, method = RequestMethod.GET)
	public ModelAndView listUsers() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("users", userService.userList());

		modelAndView.setViewName("admin/users");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/appels" }, method = RequestMethod.GET)
	public ModelAndView listUsersaa() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("users", userService.userList());

		modelAndView.setViewName("admin/appelsAdmin");
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete_user", method = RequestMethod.POST)
	public void deleteUser(@RequestParam(value = "id", required = true) long id) {
		LOGGER.info("Delete user with Id: {}", id);
		userService.delete(id);
	}
	
	@RequestMapping(value="/update_user", method = RequestMethod.POST)
	public void updateUser(@RequestParam(value = "id", required = true) long id, @RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName, @RequestParam(value = "email", required = true) String email) {
		User user = userService.findUser(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		userService.update(user);
		LOGGER.info("Updated user with id : {} and name : {}", user.getId(), user.getFirstName());
	}
	
	@RequestMapping(value="/new_user", method = RequestMethod.POST)
	@ResponseBody
	public long newUser(@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName, @RequestParam(value = "email", required = true) String email) {
		Date now = new Date();
		User user = new User(0, email, "azerty", firstName, lastName, "address", true , null, false, now, now);
		userService.save(user, userRole);
		LOGGER.info("Create new user with id : {} and name : {}", user.getId(), user.getFirstName());
		return user.getId();
	}

	@RequestMapping(value = "/find_by_email", method = RequestMethod.POST)
	@ResponseBody
	public String findUserByEmail(@RequestParam(value = "email", required = true) String emailAddress) {
		Boolean res = true;

		if (emailAddress != null) {

			if (emailAddress != "") {

				User userList = userService.findUserByEmail(emailAddress);
				if (userList != null) {
					res = false;
				}

			} else {
				res = true;
			}

		} else {
			res = true;
		}
		return res.toString();

	}

}
