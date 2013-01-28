package org.nuclearzone.myblog.controller;

import java.util.Map;

import org.bson.types.ObjectId;
import org.nuclearzone.myblog.domain.BlogUser;
import org.nuclearzone.myblog.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private BlogUserService userService;
	
	@RequestMapping(value="/user/add", method=RequestMethod.GET)
	public String addUser(Map<String, Object> map) {
		map.put("user", new BlogUser());
		return "adduser";
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") BlogUser user, BindingResult result) {
		user.setId(ObjectId.get());
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		userService.save(user);
		return "redirect:/posts";
	}
}
