package org.krams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MediatorController {

	@RequestMapping()
	public String getLogin() {
		return "access/login";
	}

	@RequestMapping(value = "/home")
	public String getHomePage() {
		return "home";
	}

	@RequestMapping(value = "/user")
	public String getUserPage() {
		return "user";
	}

	@RequestMapping(value = "/admin")
	public String getAdminPage() {
		return "admin";
	}

	@RequestMapping(value = "/hr")
	public String getHRPage() {
		return "hr";
	}
}
