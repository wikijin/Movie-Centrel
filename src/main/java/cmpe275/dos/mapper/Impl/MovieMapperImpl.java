package cmpe275.dos.mapper.Impl;

import cmpe275.dos.dto.MovieDto;
import cmpe275.dos.dto.MovieSearchDto;
import cmpe275.dos.dto.MovieSimpleDto;
import cmpe275.dos.entity.Movie;
import cmpe275.dos.mapper.GenericMapper;
import cmpe275.dos.mapper.MovieMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapperImpl extends GenericMapper implements MovieMapper {
    public MovieDto toDto(Movie pojo) {
        return mapT1toT2(pojo, new MovieDto());
    }

    public MovieSimpleDto toSimpleDto(Movie pojo){
        return mapT1toT2(pojo, new MovieSimpleDto());
    }

    public MovieSearchDto toSearchDto(Movie pojo) { return mapT1toT2(pojo, new MovieSearchDto ());}

    public Movie toPojo(MovieDto dto) {
        return mapT1toT2(dto, new Movie());
    }

    public Movie toPojo(MovieSimpleDto dto){
        if (dto == null) return null;
        return mapT1toT2(dto, new Movie());
    }

    public Movie updPojo (MovieSimpleDto dto, Movie pojo) {
        if ( dto == null ) return pojo;
        updateValue(pojo::setCoverImageUrl, dto.getCoverImageUrl());
        updateValue(pojo::setLength, dto.getLength());
        updateValue(pojo::setMovieDesc, dto.getMovieDesc());
        updateValue(pojo::setMovieTitle, dto.getMovieTitle());
        updateValue(pojo::setReleaseDate, dto.getReleaseDate());
        updateValue(pojo::setTrailerUrl, dto.getTrailerUrl());
        updateValue(pojo::setMovie_type, dto.getMovie_type());
        updateValue(pojo::setStudio, dto.getStudio());
        updateValue(pojo::setCountry, dto.getCountry());


        return pojo;
    }
}
