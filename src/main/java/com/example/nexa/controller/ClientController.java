package com.example.nexa.controller;

import com.example.nexa.dto.ClientDTO;
import com.example.nexa.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/client")
@CrossOrigin
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/getClients")
    public List<ClientDTO> getClients(){
        return clientService.getAllClients();
    }
    @GetMapping("/getClientByClientEmailAndPassword/{clientEmail}/{password}")
    public ClientDTO getClientByClientEmailAndPassword(@PathVariable String clientEmail , @PathVariable String password){
        System.out.println("Client Email :"+ clientEmail +"Password :" +password);
        return clientService.getClientByClientEmailAndPassword(clientEmail,password);
    }

    @PostMapping("/saveClient")
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        return clientService.saveClient(clientDTO);

    }
}
