package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Role;
import tn.enis.entities.Role;
import tn.enis.service.RoleService;

@RestController
@RequestMapping("/admin/Roles")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("roles", roleService.getAll());

		modelAndView.setViewName("admin/roles");//admin/roles.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		roleService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(Role role) {
		roleService.update(role);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(Role role) {
		roleService.save(role);
		return new ModelAndView("redirect:/admin/Roles");
	}


}
