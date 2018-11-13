package fr.registration.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.registration.model.Section;
import fr.registration.service.ChapitreService;
import fr.registration.service.SectionService;


@Controller
public class SectionController {
	
	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private ChapitreService chapitreService;
	

	@GetMapping("/section/{id}")
    public String showSectionById(Model model, @PathVariable("id") Integer id) {
    	Section section = sectionService.findSectionById(id);
    	model.addAttribute("section", section);
        return "/section/section";
    }
	
	
	
	@RequestMapping(value="/admin/creer-section", method=RequestMethod.GET)
	public String formSection(Model model) {
		model.addAttribute("section", new Section());
		
		model.addAttribute("chapitreList", chapitreService.findAllChapitres());
		return "/admin/createformsection";
	}
	
	@RequestMapping(value="/admin/saveSection", method=RequestMethod.POST)
	public String saveSection(@Valid Section section, BindingResult bindingResult) throws IllegalStateException, IOException {
		if(bindingResult.hasErrors()) {
			return "/admin/createformsection";
		}
		
		section.setDateCreation(LocalDate.now());
		section.setDateModification(LocalDate.now());
		
		sectionService.createSection(section);

		return "redirect:/admin";
	}
	

	
	@RequestMapping(value="/admin/editer-section")
	public String showFormEdit(Integer id, Model model) {
		Section section = sectionService.findSectionById(id);		
		model.addAttribute("section", section);
		model.addAttribute("chapitreList", chapitreService.findAllChapitres());
		return "/admin/editformsection";
	}
	
	@RequestMapping(value="/admin/updateSection", method=RequestMethod.POST)
	public String updateSection(@Valid Section section, BindingResult bindingResult) throws IllegalStateException, IOException {
		if(bindingResult.hasErrors()) {
			return "/admin/editformsection";
		}
		
		section.setDateModification(LocalDate.now());
		
		sectionService.updateSection(section);
		
		return "redirect:/admin";
	}
	
	
	
	@RequestMapping(value="/admin/supprimer-section")
	public String supprimer(Integer id) {
		sectionService.deleteSectionById(id);
		return "redirect:/admin";
	}
	
	
	
	
}