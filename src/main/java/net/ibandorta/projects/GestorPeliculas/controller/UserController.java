package net.ibandorta.projects.GestorPeliculas.controller;


import net.ibandorta.projects.GestorPeliculas.persistence.entity.User;
import net.ibandorta.projects.GestorPeliculas.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(method= RequestMethod.GET)
    public List<User> findAll(@RequestParam(required = false)String name){

            List<User> users = null;
            if(StringUtils.hasText(name)){
                users = userService.findAllByName(name);
            }else{
                users = userService.findAll();
            }

        return users;
    }
    @RequestMapping(method= RequestMethod.GET, path="/{user}")
    public User findOneByUsername(@PathVariable("user") String username){
        return userService.findOneByUsername(username);
    }

}
