package tn.enis.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import tn.enis.repositories.MatiereRepository;
import tn.enis.service.MatiereService;

@Controller
@RequestMapping(value = "/admin")
public class MatiereController {
	@Autowired
	private MatiereService matiereService;
	@Autowired
	private MatiereRepository matiereRepository;

	@RequestMapping(value={ "/matieres" },method=RequestMethod.GET)
	public String list(Model model, @RequestParam(name="page", defaultValue = "0")int p) {
		Page<Matiere> et=matiereRepository.findAll(new PageRequest(p, 5));
		int pageCount = et.getTotalPages();
		int [] pages =new int[pageCount];
		for(int i=0 ; i<pageCount; i++) 
			 pages[i]=i;
		model.addAttribute("pages",pages);
		model.addAttribute("pagematieres",et);
		model.addAttribute("pageCourante",p);
		return "admin/matieres";
		
		
	}

	@RequestMapping(value ="/delete")
	public String delete( long id) {
		matiereRepository.delete(id);
		return "redirect:matieres";
	}
		@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String formMat(Model model) {
		model.addAttribute("matiere", new Matiere());
		return "admin/FormMat";
	}

	@RequestMapping(value = "/SaveMat", method = RequestMethod.POST)
	public ModelAndView save(Matiere mat) {
		matiereService.save(mat);
		return new ModelAndView("redirect:/admin/matieres");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)

	public String update(Matiere matiere) {

		matiereRepository.save(matiere);
		return "redirect:/admin/matieres";
	}

	@RequestMapping(value = "/edit")
	public String edit(Long id, Model model) {
		Matiere mat = matiereRepository.getOne(id);
		model.addAttribute("matiere", mat);
		return "/admin/editMat";
	}

}
