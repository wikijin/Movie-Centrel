package cmpe275.dos.dto;

import cmpe275.dos.entity.Movie;
import cmpe275.dos.entity.Genre;
import cmpe275.dos.entity.MovieCharacter;
import cmpe275.dos.entity.MovieDirector;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MovieDto implements Serializable {
    private Integer movieId;

    private String movieTitle;

    private String movieDesc;

    private String trailerUrl;

    private String coverImageUrl;

    private Date releaseDate;

    private String mpaaRating;

    private Float stars = 5.0f;

    private Integer length;

    private List<Genre> genres;

    private List<MovieCharacter> characters;

    private List<MovieDirector> directors;

    private Integer movie_type;

    public Integer getMovie_type() {
        return movie_type;
    }

    public void setMovie_type(Integer movie_type) {
        this.movie_type = movie_type;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public Float getStars() {
        return stars;
    }

    public void setStars(Float stars) {
        this.stars = stars;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<MovieCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(List<MovieCharacter> characters) {
        this.characters = characters;
    }

    public List<MovieDirector> getDirectors() {
        return directors;
    }

    public void setDirectors(List<MovieDirector> directors) {
        this.directors = directors;
    }
}
