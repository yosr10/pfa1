package tn.enis.controllers;

import java.util.ArrayList;
import java.util.List;


import javax.validation.Valid;

import tn.enis.repositories.EtudiantRepository;
import tn.enis.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EtudiantController {
	@Autowired
	private EtudiantRepository etudiantRepository;

	// Ancienne
	// Annotation//@RequestMapping(value="/indexEtudiant",method=RequestMethod.GET)

	@GetMapping("/indexEtudiant")
	public String listEtudiants(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Etudiant> pageEtudiants = etudiantRepository.findByNomContains(mc, new PageRequest(page, 5));
		model.addAttribute("ListEtudiants", pageEtudiants.getContent());
		model.addAttribute("pages", new int[pageEtudiants.getTotalPages()]);
		model.addAttribute("pageCourante", page);
		model.addAttribute("motCle", mc);
		return "/admin/etudiants";
	}

	
	@GetMapping("/delete")
	public String delete(Long id, int page, String motCle) {
		etudiantRepository.delete(id);
		return "redirect:/indexEtudiant?page=" + page + "&motCle=" + motCle;
	}
	
	@GetMapping("/formEtudiant")
	public String form(Model model) {
		model.addAttribute("etudiant", new Etudiant());
		return "admin/FormEtudiant";
	}

	@GetMapping("/edit")
	public String edit(Model model, Long id) {
		Etudiant etudiant = etudiantRepository.findOne(id);
		model.addAttribute("etudiant", etudiant);
		return "/admin/EditEtudiant";
	}
	
	@PostMapping("/save")
	public String save(Model model, @Valid Etudiant etudiant, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "admin/FormEtudiant";
		etudiantRepository.save(etudiant);

		return "redirect:/indexEtudiant";
	}
	/*
	@GetMapping("/")
	public String def() {

		return "redirect:/indexEtudiant";
	}
	
	@GetMapping("/403")
	public String NotAuthorized() {

		return "403";
	}
	@GetMapping("/login")
	public String login() {

		return "login";
	}
	*/
}
