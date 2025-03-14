package net.ibandorta.projects.GestorPeliculas.persistence.service.impl;

import net.ibandorta.projects.GestorPeliculas.dto.request.SaveUser;
import net.ibandorta.projects.GestorPeliculas.dto.response.GetUser;
import net.ibandorta.projects.GestorPeliculas.exception.ObjectNotFoundException;
import net.ibandorta.projects.GestorPeliculas.mapper.UserMapper;
import net.ibandorta.projects.GestorPeliculas.persistence.entity.User;
import net.ibandorta.projects.GestorPeliculas.persistence.repository.UserCrudRepository;
import net.ibandorta.projects.GestorPeliculas.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public List<GetUser> findAll() {
        List<User>entities = userCrudRepository.findAll();
        return UserMapper.toGetDtoList(entities);
    }

    @Override
    public List<GetUser> findAllByName(String name) {
        List<User> entities=  userCrudRepository.findByNameContaining(name);
        return UserMapper.toGetDtoList(entities);
    }

    @Override
    public GetUser findOneByUsername(String username) {

        return UserMapper.toGetDto(this.findOneEntityByUsername(username));
    }



    private User findOneEntityByUsername(String username) {

        return userCrudRepository.findByUsername(username)
                .orElseThrow( () -> new ObjectNotFoundException("[user: " + username  + "]"));
    }



    @Override
    public GetUser saveOne(SaveUser saveDto) {
        User newUser =  UserMapper.toEntity(saveDto);
        return UserMapper.toGetDto(userCrudRepository.save(newUser));
    }



    public GetUser updateOneByUsername(String username, SaveUser saveDto) {
        User oldUser = this.findOneEntityByUsername(username);

        if(saveDto == null)return null;

        UserMapper.updateEntity(oldUser, saveDto);

        return UserMapper.toGetDto(userCrudRepository.save(oldUser));


    }


    @Override
    public void deleteOneByUsername(String username) {

        if (userCrudRepository.deleteByUsername(username) == null) {
            throw new ObjectNotFoundException("[user: " + username + "]");
        }


    }
}
