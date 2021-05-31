package com.launchcode.springproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CarouselController {

    @GetMapping("/gallery")
    public String viewCarouselPage() {
        return "gallery";
    }
}
