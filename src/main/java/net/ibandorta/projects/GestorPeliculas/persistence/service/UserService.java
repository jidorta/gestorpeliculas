package net.ibandorta.projects.GestorPeliculas.persistence.service;

import net.ibandorta.projects.GestorPeliculas.persistence.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    List<User> findAllByName(String name);

    User findOneByUsername(String username);

    User saveOne(User user);

    User updateOneByUsername(String username, User user);

    void deleteOneByUsername(String username);


}
