package com.example.nexa.repo;

import com.example.nexa.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepo extends JpaRepository<Client,String> {
//    @Query(value = "SELECT * FROM Client WHERE ID = ?1",nativeQuery = true)
//    Client getClientByEmail(String userId);
//
    @Query(value = "SELECT * FROM client WHERE email =?1 AND password =?2",nativeQuery = true)
    Client getClientByClientEmailAndPassword(String email,String password);
}
