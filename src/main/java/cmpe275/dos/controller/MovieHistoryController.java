package cmpe275.dos.controller;

import cmpe275.dos.response.JsonResponse;
import cmpe275.dos.service.MovieHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static cmpe275.dos.constant.JsonConstant.KEY_CONTENT;
import static cmpe275.dos.constant.JsonConstant.KEY_MOVIE_HISTORY;
import static cmpe275.dos.constant.UrlConstant.MOVIE_HISTORY;
import static cmpe275.dos.constant.UrlConstant.MOVIE_HISTORY_USERID;


@RestController
@Api(tags = {"Movie History"})
@Transactional(rollbackFor = Exception.class)
public class MovieHistoryController extends AbstractController {
    @Autowired
    MovieHistoryService movieHistoryService;

    @ApiOperation(value = "Get All Genres [Topic: movies]", response = JsonResponse.class)
    @GetMapping(MOVIE_HISTORY)
    public ResponseEntity<JsonResponse> getGenres() {
        return success(KEY_CONTENT, movieHistoryService.getAllMovieHistory());
    }

    @ApiOperation(value = "Get All Movie History of a User [Topic: movies]", response = JsonResponse.class)
    @GetMapping(MOVIE_HISTORY_USERID)
    public ResponseEntity<JsonResponse> getMovieGenres(@PathVariable Integer userId) {
        return success(KEY_MOVIE_HISTORY, movieHistoryService.getMovieHistoryByUserId(userId));
    }

}
