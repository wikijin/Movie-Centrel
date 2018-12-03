package cmpe275.dos.service.impl;

import cmpe275.dos.dao.GenreDao;
import cmpe275.dos.dao.MovieDao;
import cmpe275.dos.dto.MovieGenreDto;
import cmpe275.dos.entity.Genre;
import cmpe275.dos.entity.Movie;
import cmpe275.dos.mapper.MovieMapper;
import cmpe275.dos.service.MovieGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieGenreServiceImpl implements MovieGenreService {

    @Autowired
    GenreDao genreDao;

    @Autowired
    MovieDao movieDao;

    @Autowired
    MovieMapper movieMapper;

    @Override
    public List<Genre> getAllGenres() {
        return genreDao.findAll();
    }

    @Override
    public List<Genre> getMovieGenres(Integer movieId) {
        return genreDao.findAllByMovieId(movieId);
    }

    @Override
    public List<Genre> addGenre(MovieGenreDto movieGenreDto) {
        Genre genre = genreDao.findGenreByGenreId(movieGenreDto.getGenreId());
        Movie movie = movieDao.findMoviesByMovieId(movieGenreDto.getMovieId());
        if ( genre == null || movie == null) return null;
        if ( !movie.getGenres().contains(genre)) {
            movie.getGenres().add(genre);
            movieDao.save(movie);
        }
        return movie.getGenres();
    }

    @Override
    public List<Genre> removeGenre(MovieGenreDto movieGenreDto) {
        Genre genre = genreDao.findGenreByGenreId(movieGenreDto.getGenreId());
        Movie movie = movieDao.findMoviesByMovieId(movieGenreDto.getMovieId());
        if ( genre == null || movie == null) return null;
        if ( movie.getGenres().contains(genre)) {
            movie.getGenres().remove(genre);
            movieDao.save(movie);
        }
        return movie.getGenres();
    }
}

