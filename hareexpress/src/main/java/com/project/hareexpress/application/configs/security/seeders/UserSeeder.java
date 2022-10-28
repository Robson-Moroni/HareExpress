package com.project.hareexpress.application.configs.security.seeders;

import com.project.hareexpress.domain.models.Endereco;
import com.project.hareexpress.domain.models.User;
import com.project.hareexpress.repositories.EnderecoRepository;
import com.project.hareexpress.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// https://github.com/SeunMatt/spring-blog/blob/master/src/main/java/com/smatt/seeders/DatabaseSeeder.java
@Component
public class UserSeeder {
    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public UserSeeder(
            UserRepository _userRepository,
            EnderecoRepository _enderecoRepository
            ) {
        this.userRepository = _userRepository;
        this.enderecoRepository = _enderecoRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        if (userRepository.findAll().isEmpty()) {
            seedUserTable();
        }
    }

    private void seedUserTable() {
        User user = new User();

        user.setLogin("admin");
        user.setEmail("administrador@gmail.com");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setSenha(bCryptPasswordEncoder.encode("123"));

//        Role roleUser = new Role();
//        roleUser.setId(1);
//        roleUser.setName("ROLE_USER");
//        roleRepository.save(roleUser);
//
//        Role roleAdmin = new Role();
//        roleAdmin.setId(2);
//        roleAdmin.setName("ROLE_ADMIN");
//        roleRepository.save(roleAdmin);
//
//        List<Role> listRole = new ArrayList<Role>();
//        listRole.add(roleAdmin);
//
//        user.setRoles(listRole);

        user = userRepository.save(user);

        System.out.println("Seed User Done");

        Endereco endereco = new Endereco();
        endereco.setCep("01049-000");
        endereco.setPais("Brasil");
        endereco.setEstado("São Paulo");
        endereco.setCidade("São Paulo");
        endereco.setEndereco("Rua Formosa 367, Centro");
        endereco.setComplemento("30º andar");


    }

}

