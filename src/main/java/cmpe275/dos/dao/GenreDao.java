package cmpe275.dos.dao;

import cmpe275.dos.entity.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreDao extends CrudRepository<Genre, Integer> {
    List<Genre> findAll();

    @Query("select g from Genre g join g.movies gm where gm.movieId = :movieId")
    List<Genre> findAllByMovieId(@Param("movieId") Integer movieId);

    Genre findGenreByGenreId(Integer genreId);
}
