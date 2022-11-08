package org.itsci.zoo.controller;

import org.itsci.zoo.service.AnimalService;
import org.itsci.zoo.service.AnimalTypeService;
import org.itsci.zoo.service.TramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebHomeController {

    @Autowired
    private TramService tramService;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private AnimalTypeService animalTypeService;

    @RequestMapping("/")

    public String showHome (Model model) {
        model.addAttribute("trams", tramService.getTrams());
        model.addAttribute("animals", animalService.getAnimals());
        model.addAttribute("animalTypes", animalTypeService.getAnimalTypes());
        return "home";
    }
}

