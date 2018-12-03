package cmpe275.dos.mapper;

import cmpe275.dos.dto.AggMovieReviewDto;
import cmpe275.dos.dto.MovieReviewDto;
import cmpe275.dos.dto.ParamCreateReview;
import cmpe275.dos.dto.ParamUpdateReview;
import cmpe275.dos.entity.MovieReview;

public interface ReviewMapper {

    MovieReviewDto toDto(MovieReview pojo);

    MovieReview toPojo (ParamCreateReview dto);

    MovieReview updPojo(ParamUpdateReview dto, MovieReview pojo);

    AggMovieReviewDto toAggMovieReviewDto(Object row);

}
