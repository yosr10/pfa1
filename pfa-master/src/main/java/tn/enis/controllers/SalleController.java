package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Salle;
import tn.enis.entities.Salle;
import tn.enis.service.SalleService;

@RestController
@RequestMapping("/admin/Salles")
public class SalleController {
	@Autowired
	private SalleService salleService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("salles", salleService.getAll());

		modelAndView.setViewName("admin/salles");//admin/salles.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		salleService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(Salle salle) {
		salleService.update(salle);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(Salle salle) {
		salleService.save(salle);
		return new ModelAndView("redirect:/admin/Salles");
	}


}
