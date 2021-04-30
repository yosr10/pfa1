package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.service.UniteService;

@RestController
@RequestMapping("/admin/")
public class UniteController {
	@Autowired
	private UniteService uniteService;

	@GetMapping("/Unites")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("unites", uniteService.getAll());

		modelAndView.setViewName("admin/unites");//admin/unites.html
		return modelAndView;
	}

}
