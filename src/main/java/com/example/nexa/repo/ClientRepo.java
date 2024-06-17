package com.example.nexa.repo;

import com.example.nexa.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, String> {

    Client findByEmail(String email);

    @Query(value = "SELECT * FROM client WHERE email = ?1 AND password = ?2", nativeQuery = true)
    Client getClientByClientEmailAndPassword(String email, String password);

    @Query(value = "SELECT COUNT(*) > 0 FROM client WHERE email = ?1", nativeQuery = true)
    boolean existsByEmail(String email);
}
