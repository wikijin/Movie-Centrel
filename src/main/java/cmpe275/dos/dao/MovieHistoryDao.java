package cmpe275.dos.dao;

import cmpe275.dos.entity.Movie;
import cmpe275.dos.entity.MovieHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieHistoryDao extends CrudRepository <MovieHistory, Integer> {
    List<MovieHistory> findAll();

    @Query("select m from Movie m join m.users mu where mu.userId = :userId")
    List<Movie> findAllByUserId(@Param("userId") Integer userId);


}
