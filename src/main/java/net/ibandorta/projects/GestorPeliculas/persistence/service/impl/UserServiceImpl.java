package net.ibandorta.projects.GestorPeliculas.persistence.service.impl;

import net.ibandorta.projects.GestorPeliculas.exception.ObjectNotFoundException;
import net.ibandorta.projects.GestorPeliculas.persistence.entity.User;
import net.ibandorta.projects.GestorPeliculas.persistence.repository.UserCrudRepository;
import net.ibandorta.projects.GestorPeliculas.persistence.service.UserService;
import org.hibernate.cfg.QuerySecondPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public List<User> findAll() {
        return userCrudRepository.findAll();
    }

    @Override
    public List<User> findAllByName(String name) {
        return userCrudRepository.findByNameContaining(name);
    }

    @Override
    public User findOneByUsername(String username) {
        return userCrudRepository.findByUsername(username)
                .orElseThrow( () -> new ObjectNotFoundException("[user: " + username  + "]"));
    }


    @Override
    public User saveOne(User user) {
        return userCrudRepository.save(user);
    }

    @Override
    public User updateOneByUsername(String username, User user) {
        User oldUser = this.findOneByUsername(username);
        oldUser.setName(user.getName());
        oldUser.setPassword(user.getPassword());



        return userCrudRepository.save(oldUser);


    }


    @Override
    public void deleteOneByUsername(String username) {
        User user = this.findOneByUsername(username);
        userCrudRepository.delete(user);

    }
}
