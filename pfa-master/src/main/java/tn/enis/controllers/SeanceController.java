package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Seance;
import tn.enis.service.SeanceService;

@RestController
@RequestMapping("/admin/Seances")
public class SeanceController {
	@Autowired
	private SeanceService seanceService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("seances", seanceService.getAll());

		modelAndView.setViewName("/admin/seances");//admin/annee-academiques.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		seanceService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(Seance seance) {
		seanceService.update(seance);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(Seance seance) {
		seanceService.save(seance);
		return new ModelAndView("redirect:/admin/Seances");
	}

}
