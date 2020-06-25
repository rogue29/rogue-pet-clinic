package io.rogue.roguepetclinic.controllers;

import io.rogue.roguepetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnersController {
    private final OwnerService service;

    public OwnersController(OwnerService service) {
        this.service = service;
    }

    @GetMapping({"", "/"})
    public String listOwners(Model model) {
        model.addAttribute("owners", service.findAll());
        return "owners/ownersList";
    }
}
