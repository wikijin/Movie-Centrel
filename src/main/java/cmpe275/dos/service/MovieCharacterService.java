package cmpe275.dos.service;

import cmpe275.dos.dto.MovieCharacterDto;
import cmpe275.dos.dto.MovieSimpleDto;
import cmpe275.dos.entity.MovieCharacter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieCharacterService {
    List<MovieCharacter> getMovieCharacters(Integer movieId);

    List<MovieCharacter> addCharacter(MovieCharacterDto movieCharacterDto);

    List<MovieCharacter> removeCharacter(MovieCharacterDto movieCharacterDto);

    Page<MovieCharacterDto> searchCharacterByPattern(String pattern, Pageable pageable);
}
