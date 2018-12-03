package cmpe275.dos.service.impl;

import cmpe275.dos.dao.MovieCharacterDao;
import cmpe275.dos.dao.MovieDao;
import cmpe275.dos.dto.MovieCharacterDto;
import cmpe275.dos.entity.Movie;
import cmpe275.dos.entity.MovieCharacter;
import cmpe275.dos.mapper.MovieCharacterMapper;
import cmpe275.dos.service.MovieCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieCharacterServiceImpl implements MovieCharacterService {

    @Autowired
    MovieDao movieDao;

    @Autowired
    MovieCharacterDao movieCharacterDao;

    @Autowired
    MovieCharacterMapper movieCharacterMapper;

    @Override
    public List<MovieCharacter> getMovieCharacters(Integer movieId) {
        return movieCharacterDao.findAllByMovieId(movieId);
    }

    @Override
    public List<MovieCharacter> addCharacter(MovieCharacterDto movieCharacterDto) {
        Movie movie = movieDao.findMoviesByMovieId(movieCharacterDto.getMovieId());
        if ( movie == null ) return null;
        MovieCharacter movieCharacter = new MovieCharacter();
        movieCharacter.setCharacterName(movieCharacterDto.getCharacterName());
        movieCharacter.setMovie(movie);
        movieCharacterDao.save(movieCharacter);
        return  movieCharacterDao.findAllByMovieId(movieCharacterDto.getMovieId());
    }

    @Override
    public List<MovieCharacter> removeCharacter(MovieCharacterDto movieCharacterDto) {
        Movie movie = movieDao.findMoviesByMovieId(movieCharacterDto.getMovieId());
        MovieCharacter movieCharacter = movieCharacterDao.findMovieCharacterByCharacterId(movieCharacterDto.getCharacterId());
        if ( movie == null || movieCharacter == null) return null;
        if ( movie.getCharacters().contains(movieCharacter)){
            movieCharacterDao.deleteById(movieCharacterDto.getCharacterId());
        }
        return movieCharacterDao.findAllByMovieId(movieCharacterDto.getMovieId());
    }

    @Override
    public Page<MovieCharacterDto> searchCharacterByPattern(String pattern, Pageable pageable) {
        Page<MovieCharacter> movies = movieCharacterDao.searchCharactersByPattern(pattern, pageable);

        return new PageImpl<>(StreamSupport
                .stream(movies.spliterator(), false)
                .map(movieCharacterMapper::toDto).collect(Collectors.toList()), pageable, movies.getTotalElements());
    }
}
