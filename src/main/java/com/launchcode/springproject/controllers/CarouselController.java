package com.launchcode.springproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarouselController {

    @GetMapping("/carousel")
    public String viewCarouselPage() {
        return "carousel";
    }
}
