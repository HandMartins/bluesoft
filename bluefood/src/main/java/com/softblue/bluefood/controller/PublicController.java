package com.softblue.bluefood.controller;


import com.softblue.bluefood.domain.cliente.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/public")
public class PublicController {

    @GetMapping("/cliente/new")
    public String newClient(Model model){

        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "cliente-cadastro";
    }
}
