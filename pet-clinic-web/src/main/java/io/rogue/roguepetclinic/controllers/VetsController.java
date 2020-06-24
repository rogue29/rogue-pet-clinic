package io.rogue.roguepetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetsController {

    @GetMapping({"", "/"})
    public String listVets() {
        return "vets/index";
    }
}
