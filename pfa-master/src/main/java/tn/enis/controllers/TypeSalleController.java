package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.TypeSalle;
import tn.enis.service.TypeSalleService;

@RestController
@RequestMapping("/admin/Type-Salles")
public class TypeSalleController {
	@Autowired
	private TypeSalleService typeSalleService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("typeSalles", typeSalleService.getAll());

		modelAndView.setViewName("/admin/type-salles");//admin/type-salles.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		typeSalleService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(TypeSalle typeSalle) {
		typeSalleService.update(typeSalle);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(TypeSalle typeSalle) {
		typeSalleService.save(typeSalle);
		return new ModelAndView("redirect:/admin/Type-Salles");
	}

}
