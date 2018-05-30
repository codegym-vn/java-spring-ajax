package com.codegym.controller;

import java.util.ArrayList;
import java.util.List;

import com.codegym.service.SmartphoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.codegym.model.Smartphone;
import com.codegym.service.SmartphoneService;

@Controller
@RequestMapping(value="/smartphones")
public class SmartphoneController {

//	@Autowired
//	private SmartphoneService smartphoneService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createSmartphonePage() {
		ModelAndView mav = new ModelAndView("phones/new-phone");
		mav.addObject("sPhone", new Smartphone());
		return mav;
	}
	
	@RequestMapping(value="/createnewPhone", method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
	    System.out.println("#####");
	    SmartphoneService smartphoneService = new SmartphoneServiceImpl();
		return smartphoneService.create(smartphone);
	}
}