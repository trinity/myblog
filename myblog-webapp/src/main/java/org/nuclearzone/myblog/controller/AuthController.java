package org.nuclearzone.myblog.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/auth")
public class AuthController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@RequestParam(required=false,value="error") boolean error,
			Map<String, Object> model) {
		return "login";
	}
	
	@RequestMapping(value="/denied", method=RequestMethod.GET)
	public String denied(Map<String, Object> model) {
		return "denied";
	}
}
