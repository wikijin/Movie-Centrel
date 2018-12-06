package cmpe275.dos.service.impl;

import cmpe275.dos.dao.MovieCharacterDao;
import cmpe275.dos.dao.MovieDao;
import cmpe275.dos.dao.MpaaRatingDao;
import cmpe275.dos.dto.MovieDto;
import cmpe275.dos.dto.MovieSimpleDto;
import cmpe275.dos.entity.Movie;
import cmpe275.dos.entity.MovieCharacter;
import cmpe275.dos.entity.MpaaRating;
import cmpe275.dos.mapper.MovieMapper;
import cmpe275.dos.service.MovieCharacterService;
import cmpe275.dos.service.MovieService;
import cmpe275.dos.service.UserService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;

    @Autowired
    private MpaaRatingDao mpaaRatingDao;

    @Autowired
    MovieMapper movieMapper;

    @Autowired
    private MovieCharacterDao movieCharacterDao;

    @Override
    public MovieSimpleDto CreateMovie(MovieSimpleDto movieSimpleDto) {
        Movie movie = movieMapper.toPojo(movieSimpleDto);
        movie = updMpaaRating(movieSimpleDto, movie);
        movie = movieDao.save(movie);
        return movieMapper.toSimpleDto(movie);
    }

    @Override
    public MovieSimpleDto UpdateMovie(Integer movieId, MovieSimpleDto dto) {
        Movie movie = movieDao.findMoviesByMovieId(movieId);
        if ( movie == null ) return null;
        movie = movieMapper.updPojo(dto, movie);
        movie = updMpaaRating(dto, movie);
        movieDao.save(movie);
        return movieMapper.toSimpleDto(movie);
    }

    @Override
    public Page<MovieSimpleDto> getAllMovies(Pageable pageable, Float minStars, Float maxStars, Integer genreId) {

        Page<Movie> movies;
        minStars = minStars == null ? 0.0f : minStars;
        maxStars = maxStars == null ? 5.0f : maxStars;

        if (genreId == null) {
            movies =  movieDao.findAllBy(pageable, minStars, maxStars);
        } else {
            movies =  movieDao.SelectAllMoviesByGenre(pageable, genreId, minStars, maxStars);
        }

        return new PageImpl<>(StreamSupport
                .stream(movies.spliterator(), false)
                .map(movieMapper::toSimpleDto).collect(Collectors.toList()), pageable, movies.getTotalElements());

    }

    @Override
    public MovieDto getMovie(Integer movieId) {
        Movie movie = movieDao.findMoviesByMovieId(movieId);
        if (movie != null) {
            MovieDto movieDto = movieMapper.toDto(movie);
            return movieDto;
        }
        return null;
    }

    private Movie updMpaaRating(MovieSimpleDto dto, Movie movie){
        if ( dto.getMpaaId() != null){
            MpaaRating mpaaRating = mpaaRatingDao.findMpaaRatingByMpaaId(dto.getMpaaId());
            if (mpaaRating != null)
                movie.setMpaaRating(mpaaRating.getMpaaName());
        }
        return movie;
    }

    @Override
    public Page<MovieSimpleDto> searchMoviesByPattern(String pattern, Pageable pageable) {
        Page<Movie> movies = movieDao.searchMoviesByPattern(pattern, pageable);

        return new PageImpl<>(StreamSupport
                .stream(movies.spliterator(), false)
                .map(movieMapper::toSimpleDto).collect(Collectors.toList()), pageable, movies.getTotalElements());
    }

    @Override
    public Boolean deleteMovie(Integer movieId) {
        if (movieDao.findMoviesByMovieId(movieId) == null) {
            return false;
        }
        List<MovieCharacter> movieCharacterList = movieCharacterDao.findAllByMovieId(movieId);
        for (MovieCharacter movieCharacter : movieCharacterList) {
            movieCharacterDao.delete(movieCharacter);
        }
        movieDao.deleteById(movieId);
        return true;
    }
}
