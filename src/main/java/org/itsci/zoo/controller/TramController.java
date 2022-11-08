package org.itsci.zoo.controller;

import org.itsci.zoo.model.Animal;
import org.itsci.zoo.model.Tram;
import org.itsci.zoo.service.TramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tram")
public class TramController {
    private String title = "รถราง";

    @Autowired
    private TramService tramService;

    @GetMapping("/list")
    public String listTram(Model model) {
        model.addAttribute("title", "รายการ" + title);
        model.addAttribute("trams", tramService.getTrams());
        return "tram/list";
    }

    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("tram", new Tram());
        return "tram/tram-form";
    }

    @RequestMapping(path="/save", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("tram") Tram tram,
                              BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "มีข้อผิดพลาดในการบันทึก" + title);
            return "tram/tram-form";
        } else {
            Tram tramEntity = tramService.getTram(tram.getId());
            if (tramEntity != null) {
                tramService.updateTram(tramEntity, tram);
            } else {
                tramService.saveTram(tram);
            }
            return "redirect:/tram/list";
        }
    }

    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        Tram tram = tramService.getTram(Integer.valueOf(id));
        model.addAttribute("title", "แก้ไข" + title);
        model.addAttribute("tram", tram);
        return "tram/tram-form";
    }

    @GetMapping("/{id}/delete")
    public String deleteTram(@PathVariable("id") int id) {
        tramService.deleteTram(id);
        return "redirect:/tram/list";
    }

    @GetMapping("/{id}/view-animals")
    public String tramViewAnimal(@PathVariable("id") int id, Model model) {
        Tram tram = tramService.getTram(id);
        model.addAttribute("title", title + " - รายการสัตว์");
        model.addAttribute("tram", tram);
        model.addAttribute("animals", tram.getAnimals());
        return "tram/tram-view-animals";
    }

    @GetMapping("/{id}/animal/add")
    public String showAnimalForAdd(@PathVariable("id") int id, Model model) {
        Tram tram = tramService.getTram(id);
        List<Animal> animals = tramService.getAnimalDoesNotHaveTram(id);
        model.addAttribute("title", "เพิมรถราง");
        model.addAttribute("tram", tram);
        model.addAttribute("animals", animals);
        return "tram/animal-list";
    }
    @PostMapping("/{id}/animal/add")
    public String addAnimal(@PathVariable("id")  int tramId ,
                             @RequestParam("animal") int animalId ) {
        tramService.addAnimalToTram(tramId,animalId);
        return "redirect:/tram/" + tramId+ "/animal/add";
    }

    @GetMapping("/{id}/animal/{animal}/remove")
    public String tramRemoveAnimal(@PathVariable("id") int tramId,
                                    @PathVariable("animal") int animalId) {
        tramService.removeAnimalFromTram(tramId,animalId);
        return "redirect:/tram/" + tramId + "/view-animals";
    }
}
