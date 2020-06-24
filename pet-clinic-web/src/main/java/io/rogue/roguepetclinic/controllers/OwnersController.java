package io.rogue.roguepetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnersController {

    @GetMapping({"", "/"})
    public String listOwners() {
        return "owners/index";
    }
}
