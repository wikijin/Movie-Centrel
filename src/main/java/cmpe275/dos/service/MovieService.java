package cmpe275.dos.service;

import cmpe275.dos.dto.MovieDto;
import cmpe275.dos.dto.MovieSimpleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MovieService {
    MovieSimpleDto CreateMovie (MovieSimpleDto movieSimpleDto);

    MovieSimpleDto UpdateMovie (Integer movieId, MovieSimpleDto movieSimpleDto);

    Page<MovieSimpleDto> getAllMovies (Pageable pageable, Float minStars, Float maxStars, Integer genreId);

    MovieDto getMovie(Integer movieId);

    Page<MovieSimpleDto> searchMoviesByPattern(String pattern, Pageable pageable);

    Boolean deleteMovie(Integer movieId);
}
