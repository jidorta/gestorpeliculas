package net.ibandorta.projects.GestorPeliculas.persistence.service.impl;

import net.ibandorta.projects.GestorPeliculas.dto.request.SaveMovie;
import net.ibandorta.projects.GestorPeliculas.dto.response.GetMovie;
import net.ibandorta.projects.GestorPeliculas.exception.ObjectNotFoundException;
import net.ibandorta.projects.GestorPeliculas.mapper.MovieMapper;
import net.ibandorta.projects.GestorPeliculas.persistence.entity.Movie;
import net.ibandorta.projects.GestorPeliculas.persistence.repository.MovieCrudRepository;
import net.ibandorta.projects.GestorPeliculas.persistence.service.MovieService;
import net.ibandorta.projects.GestorPeliculas.util.MovieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieCrudRepository movieCrudRepository;

    @Override
    public List<GetMovie> findAll() {
        List<Movie> entities = movieCrudRepository.findAll();
       return MovieMapper.toGetDtoList(entities);
    }

    @Override
    public List<GetMovie> findAllByTitle(String title) {
        List<Movie> entities = movieCrudRepository.findByTitleContaining(title);
        return MovieMapper.toGetDtoList(entities);
    }

    @Override
    public List<GetMovie> findAllByGenre(MovieGenre genre) {
        List<Movie> entities= movieCrudRepository.findByGenre(genre);
        return MovieMapper.toGetDtoList(entities);
    }



    @Override
    public List<GetMovie> findAllByGenreAndTitle(MovieGenre genre, String title) {
        List<Movie> entities = movieCrudRepository.findByGenreAndTitleContaining(genre, title);
        return MovieMapper.toGetDtoList(entities);
    }

    @Override
    public GetMovie findOneById(Long id) {
        return MovieMapper.toGetDto(this.findOneEntityById(id));
    }




    private Movie findOneEntityById(Long id) {

            return movieCrudRepository.findById(id)
                    .orElseThrow(()-> new ObjectNotFoundException("[movie: "+ Long.toString(id)+"]"));

    }

    @Override
    public GetMovie createOne(SaveMovie saveDto) {

        Movie newMovie = MovieMapper.toEntity(saveDto);

        return MovieMapper.toGetDto(
                movieCrudRepository.save(newMovie)
        );
    }

    @Override
    public GetMovie updateOneById(Long id, SaveMovie saveDto) {
        Movie oldMovie = this.findOneEntityById(id);

        MovieMapper.updateEntity(oldMovie, saveDto);


        return MovieMapper.toGetDto(
                movieCrudRepository.save(oldMovie)
        );
    }

    @Override
    public void deleteOneById(Long id) {
        Movie movie = this.findOneEntityById(id);
        movieCrudRepository.delete(movie);

    }
}
