package net.ibandorta.projects.GestorPeliculas.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import net.ibandorta.projects.GestorPeliculas.dto.request.SaveMovie;
import net.ibandorta.projects.GestorPeliculas.dto.response.GetMovie;
import net.ibandorta.projects.GestorPeliculas.exception.ObjectNotFoundException;
import net.ibandorta.projects.GestorPeliculas.persistence.entity.Movie;
import net.ibandorta.projects.GestorPeliculas.persistence.service.MovieService;
import net.ibandorta.projects.GestorPeliculas.util.MovieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping
    public ResponseEntity<List<GetMovie>> findAll(@RequestParam(required = false) String title, @RequestParam(required = false) MovieGenre genre){

         List<GetMovie> movies = null;

         if(StringUtils.hasText(title) && genre != null){
             movies = movieService.findAllByGenreAndTitle(genre,title);
         } else if (StringUtils.hasText(title)){
             movies = movieService.findAllByTitle(title);
         }else if (genre != null){
             movies = movieService.findAllByGenre(genre);
         }else{
             movies = movieService.findAll();
         }

         return ResponseEntity.ok(movies);
    }

  @GetMapping(value ="/{id}")
    public ResponseEntity<GetMovie> findOneById(@PathVariable Long id){

        try {
            return ResponseEntity.ok(movieService.findOneById(id));
        }catch (ObjectNotFoundException exception){
            return ResponseEntity.notFound().build();

        }


    }


    @PostMapping
    public ResponseEntity<GetMovie>createOne( @RequestBody @Valid SaveMovie saveDto,

                                          HttpServletRequest request) {


      //  System.out.println("Fecha: " + saveDto.availabilityEndTime());
        GetMovie movieCreated = movieService.createOne(saveDto);

        String baseUrl = request.getRequestURL().toString();

        URI newLocation = URI.create(baseUrl + "/" + movieCreated.id());

        return ResponseEntity
                .created(newLocation)
                .body(movieCreated);
    }

    @PutMapping (value="/{id}")
    public ResponseEntity<GetMovie> updateOneById(@PathVariable Long id, @Valid @RequestBody SaveMovie saveDto){

        try{

            GetMovie updateMovie = movieService.updateOneById(id,saveDto);
            return ResponseEntity.ok(updateMovie);

        }catch (ObjectNotFoundException exception){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void>deleteOneById(@PathVariable Long id){
        try {
            movieService.deleteOneById(id);
            return ResponseEntity.noContent().build();
        }catch (ObjectNotFoundException exception){
            return ResponseEntity.notFound().build();
        }
    }
}
