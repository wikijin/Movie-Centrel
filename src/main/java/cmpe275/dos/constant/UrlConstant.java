package cmpe275.dos.constant;

public interface UrlConstant {
    String USER = "/user";
    String USERS = "/users";
    String USER_USERID = "/user/{userId}";
    String LOGIN = "/login";

    String MOVIE = "/movie";
    String MOVIES = "/movies";
    String MOVIE_ID = "/movie/{movieId}";
    String SEARCH_MOVIES = "/search-movies/{pattern}";

    String MOVIE_CHARACTER = "/movie-character";
    String MOVIE_CHARACTER_MOVIEID = "/movie-character/{movieId}";
    String SEARCH_MOVIES_CHARACTER = "/search-characters/{pattern}";
}
