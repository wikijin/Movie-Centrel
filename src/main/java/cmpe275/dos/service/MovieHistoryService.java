package cmpe275.dos.service;

import cmpe275.dos.entity.Movie;
import cmpe275.dos.entity.MovieHistory;

import java.util.List;

public interface MovieHistoryService {
    List<MovieHistory> getAllMovieHistory();

    List<Movie> getMovieHistoryByUserId(Integer userId);
}
