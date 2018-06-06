package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/smartphones")
public class SmartphoneController {

    @Autowired
    private SmartphoneService smartphoneService;

    //tạo mới
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createSmartphonePage() {
        ModelAndView mav = new ModelAndView("phones/new-phone");
        mav.addObject("sPhone", new Smartphone());
        return mav;
    }

    @RequestMapping(value = "/createnewPhone", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.save(smartphone);
    }

    //list
    @RequestMapping(value = "", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Smartphone> allPhones() {
        return smartphoneService.findAll();
    }

    @GetMapping("")
    public ModelAndView allPhonesPage() {
        ModelAndView modelAndView = new ModelAndView("phones/all-phones");

        modelAndView.addObject("allphones", allPhones());
        return modelAndView;
    }

    //	DElete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone deleteSmartphone(@PathVariable Integer id) {
        return smartphoneService.remove(id);
    }

    //Edit
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editSmartphonePage(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("phones/edit-phone");
        Smartphone smartphone = smartphoneService.findById(id);
        mav.addObject("sPhone", smartphone);
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone editSmartphone(@PathVariable int id,
                                     @RequestBody Smartphone smartphone) {
        smartphone.setId(id);
        return smartphoneService.save(smartphone);
    }
}