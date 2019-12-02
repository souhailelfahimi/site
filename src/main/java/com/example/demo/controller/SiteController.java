package com.example.demo.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.PhotoDao;
import com.example.demo.dao.SiteDao;
import com.example.demo.module.Photo;
import com.example.demo.module.Site;

@Controller
public class SiteController {
	public String fileLocation = System.getProperty("user.dir")+"/uploadingDir/";

	@Autowired
	public SiteDao siteDao;
	@Autowired
	public PhotoDao photoDao;
	
	
//	@PostMapping("/")
//	public String insert(@RequestBody Site s)
//	{
//		sitrep.save(s);
//		return "NewFile.html";
//	}

	@GetMapping("/")
	public String insert()
	{
		//sitrep.save(s);
		return "NewFile";
	}
	
	
	@RequestMapping(value = "/site/addsite" ,method = RequestMethod.POST)
	public String addSiteform(Model model,@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles,Site site) {
			
		siteDao.save(site);
			
		for(MultipartFile uploadedFile : uploadingFiles) {
			String filename=uploadedFile.getOriginalFilename();
			Photo picture=new Photo(filename,site);
            File file = new File("../var/tmp/" + filename);
            try {
				uploadedFile.transferTo(file);
				photoDao.save(picture);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        return "redirect:/";
	}
	
	
}
