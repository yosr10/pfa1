package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Groupe;
import tn.enis.service.GroupeService;

@RestController
@RequestMapping("/admin/Groupes")
public class GroupeController {
	@Autowired
	private GroupeService groupeService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("groupes", groupeService.getAll());

		modelAndView.setViewName("/admin/groupes");//admin/groupe.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		groupeService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(Groupe groupe) {
		groupeService.update(groupe);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(Groupe groupe) {
		groupeService.save(groupe);
		return new ModelAndView("redirect:/admin/Groupes");
	}

}
