package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Creneau;
import tn.enis.service.CreneauService;


@RestController
@RequestMapping("/admin/Creneaux")
public class CreneauController {
	@Autowired
	private CreneauService creneauService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("creneaux", creneauService.getAll());

		modelAndView.setViewName("admin/creneaux");//admin/creneaux.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		creneauService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(Creneau creneau) {
		creneauService.update(creneau);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(Creneau creneau) {
		creneauService.save(creneau);
		return new ModelAndView("redirect:/admin/Creneaux");
	}


}
