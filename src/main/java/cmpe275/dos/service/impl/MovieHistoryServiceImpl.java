package cmpe275.dos.service.impl;

import cmpe275.dos.dao.MovieDao;
import cmpe275.dos.dao.MovieHistoryDao;
import cmpe275.dos.dao.UserDao;
import cmpe275.dos.entity.Movie;
import cmpe275.dos.entity.MovieHistory;
import cmpe275.dos.service.MovieCharacterService;
import cmpe275.dos.service.MovieHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieHistoryServiceImpl implements MovieHistoryService {
    @Autowired
    MovieDao movieDao;

    @Autowired
    UserDao userDao;

    @Autowired
    MovieHistoryDao movieHistoryDao;

    @Override
    public List<MovieHistory> getAllMovieHistory () {
        return movieHistoryDao.findAll();
    }

    @Override
    public List<Movie> getMovieHistoryByUserId(Integer userId) {
        return movieHistoryDao.findAllByUserId(userId);
    }
}
