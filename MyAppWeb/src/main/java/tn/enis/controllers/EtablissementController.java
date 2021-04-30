package tn.enis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.enis.entities.Etablissement;
import tn.enis.entities.Etudiant;
import tn.enis.repositories.EtablissementRepository;
import tn.enis.repositories.EtudiantRepository;
import tn.enis.service.EtablissementService;

@Controller
@RequestMapping("/admin/Etablissements")
public class EtablissementController {
	@Autowired
	private EtablissementService etablissementService;
	@Autowired
	private EtablissementRepository etablissementRepository;
/*	@GetMapping("/indexEtudiant")
	public String listEtudiants(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Etudiant> pageEtudiants = etudiantRepository.findByNomContains(mc, new PageRequest(page, 5));
		model.addAttribute("ListEtudiants", pageEtudiants.getContent());
		model.addAttribute("pages", new int[pageEtudiants.getTotalPages()]);
		model.addAttribute("pageCourante", page);
		model.addAttribute("motCle", mc);
		return "/admin/etudiants";
	}
*/
	@GetMapping("/Searchtab")

	public String listEtab(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "keyword", defaultValue = "") String mc) {
		Page<Etablissement> pageEtablissements = etablissementRepository.findByNomContains(mc, new PageRequest(page, 5));
		model.addAttribute("ListEtablissements", pageEtablissements.getContent());
		model.addAttribute("pages", new int[pageEtablissements.getTotalPages()]);
		model.addAttribute("CurrentPage", page);
		model.addAttribute("keyword", mc);
		return "redirect:/admin/Etablissements?page=" + page + "&keyword=" + mc;
	}
	@GetMapping()
	
	public String listEtab1(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "keyword", defaultValue = "") String mc) {
		Page<Etablissement> pageEtablissements = etablissementRepository.findByNomContains(mc, new PageRequest(page, 5));
		model.addAttribute("ListEtablissements", pageEtablissements.getContent());
		model.addAttribute("pages", new int[pageEtablissements.getTotalPages()]);
		model.addAttribute("CurrentPage", page);
		model.addAttribute("keyword", mc);
		return "/admin/etablissements";
	}
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	public String delete(Long id, int page, String motCle) {
//		etablissementRepository.delete(id);
//		return "redirect:/admin/Etablissements/Searchtab?page=" + page + "&motCle=" + motCle;
//	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = true) long id) {
		etablissementService.delete(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(Etablissement etablissement) {
		etablissementService.update(etablissement);
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(Etablissement etablissement) {
		etablissementService.save(etablissement);
		return new ModelAndView("redirect:/admin/Etablissements");
	}

}
