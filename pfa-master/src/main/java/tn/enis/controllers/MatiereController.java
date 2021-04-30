package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Matiere;
import tn.enis.service.MatiereService;

@RestController
@RequestMapping("/admin/Matieres")
public class MatiereController {
	@Autowired
	private MatiereService matiereService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("matieres", matiereService.getAll());

		modelAndView.setViewName("admin/matieres");//admin/matieres.html
		return modelAndView;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		matiereService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(Matiere matiere) {
		matiereService.update(matiere);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(Matiere matiere) {
		matiereService.save(matiere);
		return new ModelAndView("redirect:/admin/Matieres");
	}
}
