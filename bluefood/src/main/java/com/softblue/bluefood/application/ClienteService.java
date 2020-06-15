package com.softblue.bluefood.application;

import com.softblue.bluefood.domain.cliente.Cliente;
import com.softblue.bluefood.domain.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void saveCliente(Cliente cliente) throws ValidationException {

        if(!validateEmail(cliente.getEmail(), cliente.getId())){
            throw new ValidationException("O Email está duplicado");
        }
        clienteRepository.save(cliente);
    }

    private boolean validateEmail(String email, Integer id){

        Cliente cliente = clienteRepository.findByEmail(email);

        //verificando se o cliente já existe
        if (cliente != null ){
            //se existe e está tentando criar um novo, não pode deixar
            if (id == null){
                return false;
            }

            if (!cliente.getId().equals(id));
            return false;
        }
        return true;
    }
}
