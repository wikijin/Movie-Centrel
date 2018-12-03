package cmpe275.dos.dao;

import cmpe275.dos.entity.MovieCharacter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieCharacterDao extends CrudRepository<MovieCharacter, Integer> {

    @Query("select mc from MovieCharacter mc where mc.movie.movieId = :movieId")
    List<MovieCharacter> findAllByMovieId(@Param("movieId") Integer movieId);

    @Query("select mc from MovieCharacter mc where lower(mc.characterName) like lower(concat('%',:pattern,'%'))")
    Page<MovieCharacter> searchCharactersByPattern(@Param("pattern") String pattern, Pageable pageable);

    MovieCharacter findMovieCharacterByCharacterId(Integer characterId);
}
