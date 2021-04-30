package tn.enis.controllers;

import java.util.List;

import javax.validation.Valid;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Enseignant;
import tn.enis.entities.Etudiant;
import tn.enis.entities.Matiere;
import tn.enis.repositories.EnseignantRepository;
import tn.enis.repositories.EtudiantRepository;
import tn.enis.repositories.MatiereRepository;
import tn.enis.service.EtudiantService;
import tn.enis.service.MatiereService;
@Controller
@RequestMapping(value="/admin")
public class EnseignantController {
	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private EnseignantRepository  enseignantRepository;
	
	
	@RequestMapping(value={ "/enseignants" },method=RequestMethod.GET)
	public ModelAndView list(@RequestParam(name="page", defaultValue = "0")int p) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("enseignants",enseignantRepository.findAll());

		modelAndView.setViewName("admin/enseignants");//admin/matieres.html
		return modelAndView;
	}
	/*
	@RequestMapping(value={ "/etudiants" },method=RequestMethod.GET)
	public String list(Model model, @RequestParam(name="page", defaultValue = "0")int p) {
		Page<Etudiant> et=enseignantRepository.findAll(new PageRequest(p, 5));
		int pageCount = et.getTotalPages();
		int [] pages =new int[pageCount];
		for(int i=0 ; i<pageCount; i++) 
			 pages[i]=i;
		model.addAttribute("pages",pages);
		model.addAttribute("pageEtudiants",et);
		model.addAttribute("pageCourante",p);
		return "admin/etudiants";
		
		
	}
	*/
	
}
