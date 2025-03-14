package net.ibandorta.projects.GestorPeliculas.persistence.repository;

import net.ibandorta.projects.GestorPeliculas.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends JpaRepository<User,Long> {

    List<User> findByNameContaining(String name);

    Optional<User> findByUsername(String username);

    @Modifying
    @Transactional
    User deleteByUsername(String username);
}
