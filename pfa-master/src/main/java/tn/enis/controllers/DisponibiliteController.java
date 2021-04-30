package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Disponibilite;
import tn.enis.service.DisponibiliteService;

@RestController
@RequestMapping("/admin/Disponibilites")
public class DisponibiliteController {
	@Autowired
	private DisponibiliteService disponibiliteService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("disponibilites", disponibiliteService.getAll());

		modelAndView.setViewName("/admin/Disponibilites");//admin/annee-academiques.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		disponibiliteService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(Disponibilite disponibilite) {
		disponibiliteService.update(disponibilite);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(Disponibilite disponibilite) {
		disponibiliteService.save(disponibilite);
		return new ModelAndView("redirect:/admin/Disponibilites");
	}

}
