package com.softblue.bluefood.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/public")
public class PublicController {

    @GetMapping("/cliente/new")
    public String newClient(){

        return "cliente-cadastro";
    }
}
