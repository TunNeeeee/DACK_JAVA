package com.dacs.HoiThaoHutech.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String index(){
        return "redirect:/admin/";
    }
    @GetMapping("/")
    public  String admin(){
        return "admin/index";
    }
    @GetMapping("/logout")
    public String adminlogout() {
        return "redirect:/login";
    }


}