package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Emploi;
import tn.enis.service.EmploiService;

@RestController
@RequestMapping("/admin/Emplois")
public class EmploiController {
	@Autowired
	private EmploiService emploiService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("emplois", emploiService.getAll());

		modelAndView.setViewName("/admin/emplois");//admin/annee-academiques.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		emploiService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(Emploi emploi) {
		emploiService.update(emploi);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(Emploi emploi) {
		emploiService.save(emploi);
		return new ModelAndView("redirect:/admin/Emplois");
	}

}
