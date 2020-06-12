package com.softblue.bluefood.controller;


import com.softblue.bluefood.application.ClienteService;
import com.softblue.bluefood.domain.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/public")
public class PublicController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/new")
    public String newClient(Model model){

        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        ControllerHelper.setEditMode(model,false);
        return "cliente-cadastro";
    }

    @PostMapping("/cliente/save")
    public String saveCliente(@ModelAttribute("cliente") @Valid Cliente cliente,
                              Errors errors,
                              Model model){
        if(!errors.hasErrors()){
            clienteService.saveCliente(cliente);
            model.addAttribute("msg", "Cliente gravado com sucesso");
        }

        ControllerHelper.setEditMode(model,false);
        return "cliente-cadastro";
    }
}
