package com.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by volodymyr on 11/08/15.
 */
@Controller
public class PagesController {

    @RequestMapping("/")
    public String getIndex(ModelMap modelMap) {
        modelMap.addAttribute("date", new Date().toString());
        modelMap.addAttribute("text", "Test123");
        return "index";
    }
}
