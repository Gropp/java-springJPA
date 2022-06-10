package com.gropp.springJPA;

import com.gropp.springJPA.model.User;
import com.gropp.springJPA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired //injecao de dependencia
    private UserRepository repository;
    @Override //sobrescreve o metodo, muito similar ao main
    public void run(String... args) throws Exception {
        //List<User> users = repository.filtrarPorNome("Fernando");
        List<User> users = repository.findByNameContaining("Fernando");
        for(User u: users){
            System.out.println(u);
        }
    }
    private  void insertUser(){
        //criamos um usuario
        //instanciamos o metodo usuario
        User user = new User();
        user.setName("Fernando");
        user.setUsername("Gropp");
        user.setPassword("dio123");
        repository.save(user);

        for (User u: repository.findAll()){
            System.out.println(u);
        }
    }
}
