package sg.edu.iss.club.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.club.domain.Booking;
import sg.edu.iss.club.domain.BookingStatus;
import sg.edu.iss.club.domain.Facility;
import sg.edu.iss.club.domain.Member;
import sg.edu.iss.club.service.BookingService;
import sg.edu.iss.club.service.FacilityService;
import sg.edu.iss.club.service.MemberService;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("bookings", bookingService.listBooking());
		
		return "bookings";
	}
	
	@RequestMapping(value = "/add")
	public String addForm(Model model) {
		model.addAttribute("booking", new Booking());
		
		List<Member> memberList = memberService.findAllMembers();
		List<Facility> facilityList = facilityService.findAllFacilities();
		model.addAttribute("memberList", memberList);
		model.addAttribute("facilityList", facilityList);
		
		return "booking-form";
	}
	
	@RequestMapping(value = "/save")
	public String saveBooking(@ModelAttribute("booking") @Valid Booking booking, 
			BindingResult bindingResult,  Model model) {
		
		if (bindingResult.hasErrors()) {
		  List<Member> memberList = memberService.findAllMembers();
	    List<Facility> facilityList = facilityService.findAllFacilities();
	    model.addAttribute("memberList", memberList);
	    model.addAttribute("facilityList", facilityList);
	    
			return "booking-form";
		}
		
		Member member = memberService.findMemberById(booking.getMember().getId());
		booking.setMember(member);
		
		Facility facility = facilityService.findFacilityById(booking.getFacility().getId());
		booking.setFacility(facility);
		
		booking.setStatus(BookingStatus.BOOKED);
		
		if (!bookingService.isAvailable(booking)) {
		  model.addAttribute("errorMessage", "The Facility is not available for booking in this date range.");
		  
		  return "booking-form";
		}
		  
	  bookingService.addBooking(booking);
    return "redirect:/booking/list";
	}
	
	@RequestMapping(value = "/cancel/{id}")
	public String cancelBooking(@PathVariable("id") Integer id) {
		bookingService.cancelBooking(bookingService.findBookingById(id));
		
		return "redirect:/booking/list";
	}
}
