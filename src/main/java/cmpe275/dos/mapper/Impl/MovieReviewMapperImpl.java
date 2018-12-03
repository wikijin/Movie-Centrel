package cmpe275.dos.mapper.Impl;

import cmpe275.dos.dto.AggMovieReviewDto;
import cmpe275.dos.dto.MovieReviewDto;
import cmpe275.dos.dto.ParamCreateReview;
import cmpe275.dos.dto.ParamUpdateReview;
import cmpe275.dos.entity.Movie;
import cmpe275.dos.entity.MovieReview;
import cmpe275.dos.mapper.GenericMapper;
import cmpe275.dos.mapper.MovieMapper;
import cmpe275.dos.mapper.ReviewMapper;
import cmpe275.dos.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieReviewMapperImpl extends GenericMapper implements ReviewMapper {

    @Autowired
    MovieMapper movieMapper;

    private UserMapper userMapper = new UserMapper();

    public MovieReviewDto toDto(MovieReview pojo) {
        MovieReviewDto dto = mapT1toT2(pojo, new MovieReviewDto());
        dto.setMovie(movieMapper.toSimpleDto(pojo.getMovie()));
        dto.setUser(userMapper.toSimpleDto(pojo.getUser()));
        return dto;
    }

    public MovieReview toPojo (ParamCreateReview dto){
        return mapT1toT2(dto, new MovieReview());
    }

    public MovieReview updPojo(ParamUpdateReview dto, MovieReview pojo) {
        if (dto == null) {
            return pojo;
        }
        updateValue(pojo::setReviewTitle, dto.getReviewTitle());
        updateValue(pojo::setComment, dto.getComment());
        updateValue(pojo::setStars, dto.getStars());
        return pojo;
    }

    @Override
    public AggMovieReviewDto toAggMovieReviewDto(Object row) {

        Object[] fields = (Object[]) row;

        AggMovieReviewDto dto = new AggMovieReviewDto();
        dto.setMovie(movieMapper.toSimpleDto((Movie) fields[0]));
        dto.setReivewNum((Long) fields[1]);
        dto.setMinStars((Integer) fields[2]);
        dto.setMaxStars((Integer) fields[3]);

        return dto;

    }
}

