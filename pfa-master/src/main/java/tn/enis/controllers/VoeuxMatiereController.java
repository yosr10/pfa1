package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.VoeuxMatiere;
import tn.enis.service.VoeuxMatiereService;

@RestController
@RequestMapping("/admin/Voeux-Matieres")
public class VoeuxMatiereController {
	@Autowired
	private VoeuxMatiereService voeuxMatiereService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("voeuxMatieres", voeuxMatiereService.getAll());

		modelAndView.setViewName("/admin/voeux-matieres");//admin/voeux-matiere.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		voeuxMatiereService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(VoeuxMatiere voeuxMatiere) {
		voeuxMatiereService.update(voeuxMatiere);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(VoeuxMatiere voeuxMatiere) {
		voeuxMatiereService.save(voeuxMatiere);
		return new ModelAndView("redirect:/admin/Voeux-Matieres");
	}

}
