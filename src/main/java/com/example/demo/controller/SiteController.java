package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SiteDao;
import com.example.demo.module.Site;

@Controller
public class SiteController {

	@Autowired
	public SiteDao sitrep;
	
	@GetMapping("/message")
	public String hello()
	{
		
			return "salamamamamma";
	}
	@PostMapping("/")
	public int insert(@RequestBody Site s)
	{
		sitrep.save(s);
		return 1;
	}

	
	
}
