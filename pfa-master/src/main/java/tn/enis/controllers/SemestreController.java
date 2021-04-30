package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.service.SemestreService;

@RestController
@RequestMapping("/admin/")
public class SemestreController {
	@Autowired
	private SemestreService semestreService;

	@GetMapping("/Semestres")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("semestres", semestreService.getAll());

		modelAndView.setViewName("admin/semestres");//admin/semestres.html
		return modelAndView;
	}

}
