package com.example.nexa.service;

import com.example.nexa.dto.ClientDTO;
import com.example.nexa.entity.Client;
import com.example.nexa.repo.ClientRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<ClientDTO> getAllClients() {
        List<Client> clientList = clientRepo.findAll();
        return modelMapper.map(clientList, new TypeToken<List<ClientDTO>>() {}.getType());
    }

    public ClientDTO getClientByClientEmailAndPassword(String email, String password) {
        Client client = clientRepo.getClientByClientEmailAndPassword(email, password);
        return modelMapper.map(client, ClientDTO.class);
    }

    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = modelMapper.map(clientDTO, Client.class);
        client.setUser_group(null); // Ensure user_group is null
        clientRepo.save(client);
        return clientDTO;
    }

    public boolean checkEmailExists(String email) {
        return clientRepo.existsByEmail(email);
    }


}
