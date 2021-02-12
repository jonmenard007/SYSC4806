package com.example.accessingdatajpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {

    @GetMapping("/test")
    public @ResponseBody
    String test(Model model) {
        return "Test Passed!";
    }


    @GetMapping("/modelAndView")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("app/index");
        return modelAndView;
    }


}
