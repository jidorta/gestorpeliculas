package net.ibandorta.projects.GestorPeliculas.persistence.service;

import net.ibandorta.projects.GestorPeliculas.dto.request.SaveUser;
import net.ibandorta.projects.GestorPeliculas.dto.response.GetUser;
import net.ibandorta.projects.GestorPeliculas.persistence.entity.User;

import java.util.List;

public interface UserService {

    List<GetUser> findAll();

    List<GetUser> findAllByName(String name);

    GetUser findOneByUsername(String username);

    GetUser saveOne(SaveUser saveDto);

    GetUser updateOneByUsername(String username, SaveUser saveDto);

    void deleteOneByUsername(String username);


}
