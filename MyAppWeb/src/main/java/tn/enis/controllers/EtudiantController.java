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

import tn.enis.entities.Etudiant;
import tn.enis.entities.Matiere;
import tn.enis.repositories.EtudiantRepository;
import tn.enis.repositories.MatiereRepository;
import tn.enis.service.EtudiantService;
import tn.enis.service.MatiereService;
@Controller
@RequestMapping(value="/admin")
public class EtudiantController {
	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	/*
	@RequestMapping(value={ "/etudiants" },method=RequestMethod.GET)
	public ModelAndView list(@RequestParam(name="page", defaultValue = "0"),int p) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("etudiants",etudiantService.getAll());

		modelAndView.setViewName("admin/etudiants");//admin/matieres.html
		return modelAndView;
	
	}*/
	@RequestMapping(value={ "/etudiants" },method=RequestMethod.GET)
	public String list(Model model, @RequestParam(name="page", defaultValue = "0")int p) {
		Page<Etudiant> et=etudiantRepository.findAll(new PageRequest(p, 5));
		int pageCount = et.getTotalPages();
		int [] pages =new int[pageCount];
		for(int i=0 ; i<pageCount; i++) 
			 pages[i]=i;
		model.addAttribute("pages",pages);
		model.addAttribute("pageEtudiants",et);
		model.addAttribute("pageCourante",p);
		return "admin/etudiants";
		
		
	}
	
	@RequestMapping(value ="/del")
	public String delete( long id) {
		etudiantRepository.delete(id);
		return "redirect:etudiants";
	}
	
	@RequestMapping(value="/formEtudiant",method=RequestMethod.GET)
	public String formMat( Model model ) {
		model.addAttribute("etudiant", new Etudiant());
		return "admin/FormEtudiant";
	} 
	
	@RequestMapping(value="/SaveEtud",method=RequestMethod.POST)
	public ModelAndView save ( Etudiant etud ) {
		etudiantService.save(etud);
		return new ModelAndView("redirect:/admin/etudiants");
	} 
	
	
	@RequestMapping(value="/updateEtud", method = RequestMethod.POST)

	
	public String update(Etudiant etudiant)  {
			   
			   etudiantRepository.save(etudiant);
			    return "redirect:/admin/etudiants" ;
			}
	
	
	@RequestMapping(value="/editEtud")
	public String edit(Long id ,Model model ) {
		Etudiant etudiant =etudiantRepository.getOne(id);
		model.addAttribute("etudiant",etudiant);
		return "/admin/editEtudiant";
	} 
	
	
	
	
	
}
