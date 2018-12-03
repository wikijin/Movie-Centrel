package cmpe275.dos.controller;

import cmpe275.dos.dto.MovieCharacterDto;
import cmpe275.dos.entity.MovieCharacter;
import cmpe275.dos.response.JsonResponse;
import cmpe275.dos.service.MovieCharacterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cmpe275.dos.constant.JsonConstant.*;
import static cmpe275.dos.constant.UrlConstant.*;

@RestController
@Api(tags = {"Movie Characters"})
@Transactional(rollbackFor = Exception.class)
public class MovieCharacterController extends AbstractController {

    @Autowired
    MovieCharacterService movieCharacterService;

    @ApiOperation(value = "Get Characters of a Movie [Topic: movies]", response = JsonResponse.class)
    @GetMapping(MOVIE_CHARACTER_MOVIEID)
    public ResponseEntity<JsonResponse> getMovieCharacters(@PathVariable Integer movieId) {
        List<MovieCharacter> movieCharacters = movieCharacterService.getMovieCharacters(movieId);
        if (movieCharacters != null)
            return success(KEY_MOVIE_CHARACTERS, movieCharacters);
        return notFound();
    }

    @ApiOperation(value = "Add New Character to Movie [Topic: movies]", response = JsonResponse.class,
            notes = "characterId field is ignored")
    @CacheEvict(value = {"get-schedules-by-city-id", "get-all-schedules-by-city-id",
            "get-schedules-by-zipcode", "get-all-schedules-by-zipcode", "get-schedules-in-theater"}, allEntries = true)
    @PostMapping(MOVIE_CHARACTER)
    public ResponseEntity<JsonResponse> addMovieCharacter(@RequestBody MovieCharacterDto movieCharacterDto) {
        if (movieCharacterDto.getMovieId() == null || movieCharacterDto.getCharacterName() == null)
            return badRequest("Movie ID or Character Name Cannot Be Empty!");
        List<MovieCharacter> movieCharacters = movieCharacterService.addCharacter(movieCharacterDto);
        if (movieCharacters != null)
            return created(KEY_MOVIE_CHARACTERS, movieCharacters);
        else
            return notFound();
    }

    @ApiOperation(value = "Delete a Character from Movie [Topic: movies]", response = JsonResponse.class,
            notes = "characterName field is ignored")
    @CacheEvict(value = {"get-schedules-by-city-id", "get-all-schedules-by-city-id",
            "get-schedules-by-zipcode", "get-all-schedules-by-zipcode", "get-schedules-in-theater"}, allEntries = true)
    @DeleteMapping(MOVIE_CHARACTER)
    public ResponseEntity<JsonResponse> removeMovieCharacter(@RequestBody MovieCharacterDto movieCharacterDto) {
        if (movieCharacterDto.getMovieId() == null || movieCharacterDto.getCharacterId() == null)
            return badRequest("Movie ID or Character ID Cannot Be Empty!");
        List<MovieCharacter> movieCharacters = movieCharacterService.removeCharacter(movieCharacterDto);
        if (movieCharacters != null)
            return success(KEY_MOVIE_CHARACTERS, movieCharacters);
        else
            return notFound();
    }

    @ApiOperation(value = "Search character by pattern[Topic: movies]", response = JsonResponse.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")
    })
    @GetMapping(SEARCH_MOVIES_CHARACTER)
    public Page<MovieCharacterDto> getMovies(@PathVariable String pattern, Pageable pageable) {
        return movieCharacterService.searchCharacterByPattern(pattern, pageable);
    }
}
