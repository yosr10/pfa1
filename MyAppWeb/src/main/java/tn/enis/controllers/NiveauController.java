package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Niveau;
import tn.enis.entities.Niveau;
import tn.enis.service.NiveauService;

@RestController
@RequestMapping("/admin/Niveaux")
public class NiveauController {
	@Autowired
	private NiveauService niveauService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("niveaux", niveauService.getAll());

		modelAndView.setViewName("admin/niveaux");//admin/niveaux.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		niveauService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(Niveau niveau) {
		niveauService.update(niveau);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(Niveau niveau) {
		niveauService.save(niveau);
		return new ModelAndView("redirect:/admin/Niveaux");
	}


}
