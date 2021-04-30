package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.PlanEtude;
import tn.enis.service.PlanEtudeService;

@RestController
@RequestMapping("/admin/Plan-Etudes")
public class PlanEtudeController {
	@Autowired
	private PlanEtudeService planEtudeService;

	@GetMapping()
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("planEtudes", planEtudeService.getAll());

		modelAndView.setViewName("/admin/plan-etudes");//admin/plan-etudes.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		planEtudeService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(PlanEtude planEtude) {
		planEtudeService.update(planEtude);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(PlanEtude planEtude) {
		planEtudeService.save(planEtude);
		return new ModelAndView("redirect:/admin/Plan-Etudes");
	}

}
