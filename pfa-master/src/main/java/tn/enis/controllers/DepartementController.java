package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Departement;
import tn.enis.service.DepartementService;

@RestController
@RequestMapping("/admin/Departements")
public class DepartementController {
	@Autowired
	private DepartementService departementService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("departements", departementService.getAll());

		modelAndView.setViewName("/admin/departements");//admin/annee-academiques.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		departementService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(Departement departement) {
		departementService.update(departement);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(Departement departement) {
		departementService.save(departement);
		return new ModelAndView("redirect:/admin/Departements");
	}

}
