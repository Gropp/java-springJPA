package com.gropp.springJPA.repository;

import com.gropp.springJPA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    //query method
    List<User> findByNameContaining(String name);

    //query method
    User findByUsername(String username);

    //query override
    @Query("SELECT u  FROM User u WHERE u.name LIKE %:name%")
    List<User> filtrarPorNome(@Param("name")String name);
}
