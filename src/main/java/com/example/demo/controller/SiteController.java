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
	
	
//	@RequestMapping(value = "/site/addsite" ,method = RequestMethod.POST)
//	public String addSiteform(Model model,@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles,Site site) {
//			
//		siterepository.save(site);
//			
//		for(MultipartFile uploadedFile : uploadingFiles) {
//			String filename=uploadedFile.getOriginalFilename();
//			Picture picture=new Picture(filename,site);
//            File file = new File(fileLocation + filename);
//            try {
//				uploadedFile.transferTo(file);
//				picturerepository.save(picture);
//			}catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        }
//
//        return "redirect:/";
//	}
	
	
}
