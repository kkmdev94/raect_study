package org.example.egov.controller;

import org.example.egov.sevice.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "hello";
    }
}
