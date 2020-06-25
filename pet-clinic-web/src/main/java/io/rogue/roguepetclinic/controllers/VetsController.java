package io.rogue.roguepetclinic.controllers;

import io.rogue.roguepetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetsController {
    private final VetService service;

    public VetsController(VetService service) {
        this.service = service;
    }

    @GetMapping({"", "/"})
    public String listVets(Model model) {
        model.addAttribute("vets", service.findAll());
        return "vets/vetList";
    }
}
