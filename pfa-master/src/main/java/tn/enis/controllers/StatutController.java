package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.service.StatutService;

@RestController
@RequestMapping("/admin/")
public class StatutController {
	@Autowired
	private StatutService StatutService;

	@GetMapping("/Statuts")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("Statuts", StatutService.getAll());

		modelAndView.setViewName("admin/statuts");//admin/statuts.html
		return modelAndView;
	}

}
