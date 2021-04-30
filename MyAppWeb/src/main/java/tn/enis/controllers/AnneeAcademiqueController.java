package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.AnneeAcademique;
import tn.enis.service.AnneeAcademiqueService;

@RestController
@RequestMapping("/admin/Annee-Academiques")
public class AnneeAcademiqueController {
	@Autowired
	private AnneeAcademiqueService anneeAcademiqueService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("anneeAcademiques", anneeAcademiqueService.getAll());

		modelAndView.setViewName("/admin/annee-academiques");//admin/annee-academiques.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		anneeAcademiqueService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(AnneeAcademique anneeAcademique) {
		anneeAcademiqueService.update(anneeAcademique);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(AnneeAcademique anneeAcademique) {
		anneeAcademiqueService.save(anneeAcademique);
		return new ModelAndView("redirect:/admin/Annee-Academiques");
	}

}
