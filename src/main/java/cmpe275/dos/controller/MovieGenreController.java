package cmpe275.dos.controller;

import cmpe275.dos.dto.MovieGenreDto;
import cmpe275.dos.entity.Genre;
import cmpe275.dos.response.JsonResponse;
import cmpe275.dos.service.MovieGenreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import cmpe275.dos.constant.*;

import java.util.List;

import static cmpe275.dos.constant.JsonConstant.KEY_CONTENT;
import static cmpe275.dos.constant.JsonConstant.KEY_GENRES;
import static cmpe275.dos.constant.UrlConstant.GENRES;
import static cmpe275.dos.constant.UrlConstant.MOVIE_GENRE;
import static cmpe275.dos.constant.UrlConstant.MOVIE_GENRE_MOVIEID;

@RestController
@Api(tags = {"Movie Genres"})
@Transactional(rollbackFor = Exception.class)
public class MovieGenreController extends AbstractController{

    @Autowired
    MovieGenreService movieGenreService;

    @ApiOperation(value = "Get All Genres [Topic: movies]", response = JsonResponse.class)
    @GetMapping(GENRES)
    public ResponseEntity<JsonResponse> getGenres() {
        return success(KEY_CONTENT, movieGenreService.getAllGenres());
    }


    @ApiOperation(value = "Get All Genres of a Movie [Topic: movies]", response = JsonResponse.class)
    @GetMapping(MOVIE_GENRE_MOVIEID)
    public ResponseEntity<JsonResponse> getMovieGenres(@PathVariable Integer movieId) {
        return success(KEY_GENRES, movieGenreService.getMovieGenres(movieId));
    }


    @ApiOperation(value="Add Genre [Topic: movies]", response = JsonResponse.class)
    @CacheEvict(value={"get-schedules-by-city-id", "get-all-schedules-by-city-id",
            "get-schedules-by-zipcode", "get-all-schedules-by-zipcode", "get-schedules-in-theater"}, allEntries = true)

    @PostMapping(MOVIE_GENRE)
    public ResponseEntity<JsonResponse> addGenre(@RequestBody MovieGenreDto movieGenreDto){
        if ( movieGenreDto.getGenreId() == null || movieGenreDto.getMovieId() == null)
            return badRequest("Movie ID or Genre ID Cannot Be Empty");

        List<Genre> genres = movieGenreService.addGenre(movieGenreDto);
        if ( genres != null)
            return success(KEY_GENRES, genres);
        else
            return notFound();
    }

    @ApiOperation(value="Remove MovieGenre [Topic: movies]", response = JsonResponse.class)
    @CacheEvict(value={"get-schedules-by-city-id", "get-all-schedules-by-city-id",
            "get-schedules-by-zipcode", "get-all-schedules-by-zipcode", "get-schedules-in-theater"}, allEntries = true)
    @DeleteMapping(MOVIE_GENRE)
    public ResponseEntity<JsonResponse> deleteGenre(@RequestBody MovieGenreDto movieGenreDto){
        if ( movieGenreDto.getGenreId() == null || movieGenreDto.getMovieId() == null)
            return badRequest("Movie ID or Genre ID Cannot Be Empty");

        List<Genre> genres = movieGenreService.removeGenre(movieGenreDto);
        if ( genres != null)
            return success(KEY_GENRES, genres);
        else
            return notFound();
    }
}

