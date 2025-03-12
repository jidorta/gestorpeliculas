package net.ibandorta.projects.GestorPeliculas.mapper;

import net.ibandorta.projects.GestorPeliculas.dto.request.SaveUser;
import net.ibandorta.projects.GestorPeliculas.dto.response.GetUser;
import net.ibandorta.projects.GestorPeliculas.persistence.entity.User;

import java.util.List;

public class UserMapper {

    public static GetUser toGetDto(User entity){
        if(entity == null)return null;

        return new GetUser(
                entity.getUsername(),
                entity.getName(),
                null
        );
    }

    public static List<GetUser> toGetDtoList(List<User> entities){
        if(entities == null)return null;

        return entities.stream()
                .map(UserMapper::toGetDto)
                .toList();
    }

    public static User toEntity(SaveUser saveDto){
        if(saveDto == null)return null;

        User newUser = new User();
        newUser.setUsername(saveDto.username());
        newUser.setName(saveDto.name());
        newUser.setPassword(saveDto.password());

        return newUser;
    }


}
