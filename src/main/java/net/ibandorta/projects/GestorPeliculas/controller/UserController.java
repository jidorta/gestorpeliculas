package net.ibandorta.projects.GestorPeliculas.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import net.ibandorta.projects.GestorPeliculas.dto.request.SaveUser;
import net.ibandorta.projects.GestorPeliculas.dto.response.GetUser;
import net.ibandorta.projects.GestorPeliculas.exception.ObjectNotFoundException;
import net.ibandorta.projects.GestorPeliculas.mapper.UserMapper;
import net.ibandorta.projects.GestorPeliculas.persistence.entity.User;
import net.ibandorta.projects.GestorPeliculas.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping
    public ResponseEntity<List<GetUser>> findAll(@RequestParam(required = false)String name){

        List<GetUser> users = null;
        if(StringUtils.hasText(name)){
            users = userService.findAllByName(name);
        }else{
         }            users = userService.findAll();



        return ResponseEntity.ok(users);
    }
    @GetMapping(value="/{user}")
    public ResponseEntity<GetUser> findOneByUsername(@PathVariable("user") String username){

        try{
            return ResponseEntity.ok(userService.findOneByUsername(username));
        }catch(ObjectNotFoundException exception){
            return ResponseEntity.notFound().build();
        }

    }


    @PostMapping
    public ResponseEntity<GetUser> createOne(@RequestBody @Valid SaveUser saveDto,
                                          HttpServletRequest request){


        GetUser createdUser = userService.saveOne(saveDto);
        String baseURL = request.getRequestURL().toString();
        URI newLocation = URI.create(baseURL + "/" + saveDto.username());

        return ResponseEntity.created(newLocation).body(createdUser);
    }






    @PutMapping(value = "/{username}")
    public ResponseEntity<GetUser> updateOneByUsername(@PathVariable String username,
                                                    @RequestBody  @Valid SaveUser saveDto){

       try{
           GetUser updateUser = userService.updateOneByUsername(username, saveDto);
           return ResponseEntity.ok(updateUser);
       }catch (ObjectNotFoundException exception){
           return ResponseEntity.notFound().build();
       }


    }

    @DeleteMapping(value ="{username}")
    public ResponseEntity<Void>deleteOnByUsername(@PathVariable String username){
        try{
            userService.deleteOneByUsername(username);
            return ResponseEntity.noContent().build();

        }catch (ObjectNotFoundException exception){
            return ResponseEntity.notFound().build();
        }
    }

}
