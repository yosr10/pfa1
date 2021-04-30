package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Ressource;
import tn.enis.entities.Ressource;
import tn.enis.service.RessourceService;

@RestController
@RequestMapping("/admin/Ressources")
public class RessourceController {
	@Autowired
	private RessourceService ressourceService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("ressources", ressourceService.getAll());

		modelAndView.setViewName("admin/ressources");//admin/ressources.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		ressourceService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(Ressource ressource) {
		ressourceService.update(ressource);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(Ressource ressource) {
		ressourceService.save(ressource);
		return new ModelAndView("redirect:/admin/Ressources");
	}


}
