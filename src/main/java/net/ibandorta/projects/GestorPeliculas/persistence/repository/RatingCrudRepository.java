package net.ibandorta.projects.GestorPeliculas.persistence.repository;

import net.ibandorta.projects.GestorPeliculas.persistence.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingCrudRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByMovieId(Long id);

    @Query("SELECT r FROM  Rating r JOIN r.user u WHERE u.username=?1")
    List<Rating> findByUserUsername(String username);



}
