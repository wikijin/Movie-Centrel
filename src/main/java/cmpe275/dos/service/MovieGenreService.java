package cmpe275.dos.service;

import cmpe275.dos.dto.MovieGenreDto;
import cmpe275.dos.entity.Genre;

import java.util.List;

public interface MovieGenreService {

    List<Genre> getAllGenres();

    List<Genre> getMovieGenres (Integer movieId);

    List<Genre> addGenre (MovieGenreDto movieGenreDto);

    List<Genre> removeGenre (MovieGenreDto movieGenreDto);

}