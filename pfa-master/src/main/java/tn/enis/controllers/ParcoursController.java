package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Parcours;
import tn.enis.service.ParcoursService;

@RestController
@RequestMapping("/admin/Parcours")
public class ParcoursController {
	@Autowired
	private ParcoursService parcoursService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("parcours", parcoursService.getAll());

		modelAndView.setViewName("/admin/parcours");//admin/parcours.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		parcoursService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(Parcours parcours) {
		parcoursService.update(parcours);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(Parcours parcours) {
		parcoursService.save(parcours);
		return new ModelAndView("redirect:/admin/Parcours");
	}

}
