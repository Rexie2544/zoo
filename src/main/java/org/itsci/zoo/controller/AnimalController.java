package org.itsci.zoo.controller;

import org.itsci.zoo.model.Animal;
import org.itsci.zoo.model.Tram;
import org.itsci.zoo.service.AnimalTypeService;
import org.itsci.zoo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/animal")
public class AnimalController {
    private String title = "สัตว์";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @Autowired
    private AnimalService animalService;

    @Autowired
    private AnimalTypeService animalTypeService;

    @GetMapping("/list")
    public String listAnimal(Model model) {
        model.addAttribute("title", "รายการ" + title);
        model.addAttribute("animals", animalService.getAnimals());
        return "animal/list";
    }

    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("animaltypes", animalTypeService.getAnimalTypes());
        model.addAttribute("animal", new Animal());
        return "animal/animal-form";
    }

    @RequestMapping(path="/save", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("animal") Animal animal,
                              BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "มีข้อผิดพลาดในการบนัทึก" + title);
            model.addAttribute("animaltypes", animalTypeService.getAnimalTypes());
            return "animal/animal-form";
        } else {
            Animal animalEntity = animalService.getAnimal(animal.getId());
            if (animalEntity != null) {
                animalService.updateAnimal(animalEntity, animal);
            } else {
                animalService.saveAnimal(animal);
            }
            return "redirect:/animal/list";
        }
    }
    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable ("id") int id, Model model) {
        Animal animal = animalService.getAnimal(Integer.valueOf(id));
        model.addAttribute("title", "แก้ไข" + title);
        model.addAttribute("animaltypes", animalTypeService.getAnimalTypes());
        model.addAttribute("animal", animal);
        return "animal/animal-form";
    }

    @GetMapping("/{id}/delete")
    public String deleteAnimal(@PathVariable("id") int id) {
        animalService.deleteAnimal(id);
        return "redirect:/animal/list";
    }

    @GetMapping("/{id}/view-trams")
    public String animalViewTram(@PathVariable("id") int id, Model model) {
        Animal animal = animalService.getAnimal(id);
        model.addAttribute("title", title + " - รายการร้านค้า");
        model.addAttribute("animal", animal);
        model.addAttribute("trams", animal.getTrams());
        return "animal/animal-view-trams";
    }

    @GetMapping("/{id}/tram/add")
    public String showTramForAdd(@PathVariable("id") int id, Model model) {
        Animal animal = animalService.getAnimal(id);
        List<Tram> trams = animalService.getTramDoesNotHaveAnimal(id);
        model.addAttribute("title", "เพิ่มร้านค้า");
        model.addAttribute("animal", animal);
        model.addAttribute("trams", trams);
        return "animal/tram-list";
    }

    @PostMapping("/{id}/tram/add")
    public String addTram(@PathVariable("id") int animalId,
                          @RequestParam("tram") int tramId) {
        animalService.addTramToAnimal(animalId, tramId);
        return "redirect:/animal/" + animalId + "/tram/add";
    }

    @GetMapping("/{id}/tram/{tram}/remove")
    public String animalRemoveTram(@PathVariable("id") int animalId,
                                    @PathVariable("tram") int tramId) {
        animalService.removeTramFromAnimal(animalId, tramId);
        return "redirect:/animal/" + animalId + "/view-trams";
    }
}
