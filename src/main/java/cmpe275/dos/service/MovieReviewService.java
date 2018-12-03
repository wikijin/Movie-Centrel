package cmpe275.dos.service;

import cmpe275.dos.dto.MovieReviewDto;
import cmpe275.dos.dto.ParamCreateReview;
import cmpe275.dos.dto.ParamUpdateReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieReviewService {
    MovieReviewDto getMovieReviews (Integer movieId);

    MovieReviewDto addReview(ParamCreateReview dto);

    Boolean removeReview(Integer reviewId);

    MovieReviewDto updateReview(Integer userId, Integer reviewId, ParamUpdateReview dto);

    Page<MovieReviewDto> pageSearchMovieReview(Pageable pageable, Integer movieId, Integer userId);
}
