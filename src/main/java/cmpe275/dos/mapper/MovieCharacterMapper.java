package cmpe275.dos.mapper;

import cmpe275.dos.dto.MovieCharacterDto;
import cmpe275.dos.entity.MovieCharacter;
import org.springframework.stereotype.Component;

@Component
public class MovieCharacterMapper extends GenericMapper {

    public MovieCharacterDto toDto (MovieCharacter pojo){
        MovieCharacterDto dto = mapT1toT2(pojo, new MovieCharacterDto());
        dto.setMovieId(pojo.getMovie().getMovieId());
        return dto;
    }

}
