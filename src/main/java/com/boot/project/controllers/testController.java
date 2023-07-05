package com.boot.project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.boot.project.dao.DonationRepository;
import com.boot.project.entities.Donation;
import com.boot.project.entities.Signup;
import com.boot.project.service.UserService;

@Controller
public class testController {

	@Autowired
	private UserService userService;

	@Autowired
	private DonationRepository repository;

	// handler for home
	@GetMapping("/")
	public String run() {
		return "home";
	}

	// handler for about
	@GetMapping("/about")
	public String about() {
		return "about";
	}

	// handler for login form
	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	// handler for signup
	@GetMapping("/signup")
	public String register() {
		return "signup";
	}

	@PostMapping("/process")
	public String processRegister(@ModelAttribute Signup user, HttpSession session) {

		boolean f = userService.checkEmail(user.getEmail());
		if (f) {
			session.setAttribute("msg", "Email id already exists");
			return "redirect:/signup";
		} else {
			Signup sign = userService.createUser(user);
			if (sign != null) {
				session.setAttribute("msg", "Registered Successfully");
			} else {
				session.setAttribute("msg", "Something went wrong");
				return "redirect:/signup";
			}
		}
		return "redirect:/signup";
	}

	// handler for donation page
	@GetMapping("/donation")
	public String donation_form(Model m) {
		m.addAttribute("donation", new Donation());
		return "user/donation";
	}

	// handler for donation_processing
	@PostMapping("/process_don")
	public String donation_process(Donation don, Model model) {
		repository.save(don);
		List<Donation> listUsers = repository.findAll();
		model.addAttribute("listUsers", listUsers);
		return "user/donation_view";
	}

//	// handler for donation_view
//	@PostMapping("/process_don")
//	public String listUsers(Model model) {
//		List<Donation> listUsers = repository.findAll();
//		model.addAttribute("listUsers", listUsers);
//		return "user/donation_view";
//	}
}