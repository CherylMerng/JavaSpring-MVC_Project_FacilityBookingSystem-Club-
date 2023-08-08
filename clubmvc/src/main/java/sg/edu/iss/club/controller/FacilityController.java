package sg.edu.iss.club.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.club.domain.Facility;
import sg.edu.iss.club.service.FacilityService;

@Controller
@RequestMapping("/facility")
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
    
	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("facilities", facilityService.findAllFacilities());
		
		return "facilities";
	}
	
	@RequestMapping(value = "/add")
	public String addForm(Model model) {
		model.addAttribute("facility", new Facility());
		
		return "facility-form";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("facility", facilityService.findFacilityById(id));
		
		return "facility-form";
	}
	
	@RequestMapping(value = "/save")
	public String saveFacility(@ModelAttribute("facility") @Valid Facility facility, 
			BindingResult bindingResult,  Model model) {
		if (bindingResult.hasErrors()) {
			return "facility-form";
		}
		
		facilityService.saveFacility(facility);
		
		return "redirect:/facility/list";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteFacility(@PathVariable("id") Integer id) {
		facilityService.deleteFacility(facilityService.findFacilityById(id));
		
		return "redirect:/facility/list";
	}

}
