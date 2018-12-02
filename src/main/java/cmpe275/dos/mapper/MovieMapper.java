package cmpe275.dos.mapper;

import cmpe275.dos.dto.MovieDto;
import cmpe275.dos.dto.MovieSearchDto;
import cmpe275.dos.dto.MovieSimpleDto;
import cmpe275.dos.entity.Movie;

public interface MovieMapper {
    public MovieDto toDto(Movie pojo);

    public MovieSimpleDto toSimpleDto(Movie pojo);

    public MovieSearchDto toSearchDto(Movie pojo);

    public Movie toPojo(MovieDto dto);

    public Movie toPojo(MovieSimpleDto dto);

    public Movie updPojo (MovieSimpleDto dto, Movie pojo);
}
