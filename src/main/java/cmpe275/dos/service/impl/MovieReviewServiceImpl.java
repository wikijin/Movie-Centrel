package cmpe275.dos.service.impl;

import cmpe275.dos.dao.MovieDao;
import cmpe275.dos.dao.MovieReviewDao;
import cmpe275.dos.dao.UserDao;
import cmpe275.dos.dto.MovieReviewDto;
import cmpe275.dos.dto.ParamCreateReview;
import cmpe275.dos.dto.ParamUpdateReview;
import cmpe275.dos.entity.Movie;
import cmpe275.dos.entity.MovieReview;
import cmpe275.dos.entity.User;
import cmpe275.dos.mapper.MovieMapper;
import cmpe275.dos.mapper.ReviewMapper;
import cmpe275.dos.mapper.UserMapper;
import cmpe275.dos.service.MovieReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MovieReviewServiceImpl implements MovieReviewService {
    @Autowired
    MovieReviewDao movieReviewDao;

    @Autowired
    MovieDao movieDao;

    @Autowired
    UserDao userDao;

    @Autowired
    MovieMapper movieMapper;

    @Autowired
    ReviewMapper movieReviewMapper;

    private UserMapper userMapper = new UserMapper();

    @Override
    public MovieReviewDto getMovieReviews(Integer reviewId) {
        MovieReview movieReview = movieReviewDao.findMovieReviewByReviewId(reviewId);
        if (movieReview != null) {
            MovieReviewDto movieReviewDto = movieReviewMapper.toDto(movieReview);
            movieReviewDto.setMovie(movieMapper.toSimpleDto(movieReview.getMovie()));
            movieReviewDto.setUser(userMapper.toSimpleDto(movieReview.getUser()));
            return movieReviewDto;
        }
        return null;
    }

    public MovieReviewDto addReview(ParamCreateReview dto) {
        Movie movie = movieDao.findMoviesByMovieId(dto.getMovieId());
        User user = userDao.findUserByUserId(dto.getUserId());
        if (movie == null || user == null) return null;

        MovieReview movieReview = movieReviewMapper.toPojo(dto);
        movieReview.setMovie(movie);
        movieReview.setUser(user);
        movieReview.setPostDate(new Date());
        return movieReviewMapper.toDto(movieReviewDao.save(movieReview));

    }

    public Boolean removeReview(Integer reviewId) {
        MovieReview movieReview = movieReviewDao.findMovieReviewByReviewId(reviewId);
        if (movieReview == null) return false;
        movieReviewDao.deleteById(reviewId);
        return true;
    }

    @Override
    public MovieReviewDto updateReview(Integer userId, Integer reviewId, ParamUpdateReview dto) {
        MovieReview movieReview = movieReviewDao.findMovieReviewByReviewId(reviewId);
        if (movieReview == null || ! movieReview.getUser().getUserId().equals(userId)) return null;
        movieReview = movieReviewMapper.updPojo(dto, movieReview);
        return movieReviewMapper.toDto(movieReviewDao.save(movieReview));
    }

    @Override
    public Page<MovieReviewDto> pageSearchMovieReview(Pageable pageable, Integer movieId, Integer userId) {

        Page<MovieReview> movieReviews;

        if (movieId != null && userId != null)
            movieReviews = movieReviewDao.findAllByMovieIdAndUserId(pageable, movieId, userId);
        else if (movieId != null)
            movieReviews = movieReviewDao.findAllByMovieId(pageable, movieId);
        else if (userId != null)
            movieReviews = movieReviewDao.findAllByUserId(pageable, userId);
        else
            movieReviews = movieReviewDao.findAll(pageable);

        List<MovieReviewDto> result = new ArrayList<>();
        for (MovieReview movieReview : movieReviews) {
            result.add( movieReviewMapper.toDto(movieReview));
        }
        return new PageImpl<>(result, pageable, movieReviews.getTotalElements());
    }

}
