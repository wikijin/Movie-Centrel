package cmpe275.dos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="MOVIE")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private Integer movieId;

    @Column(name="movie_title")
    private String movieTitle;

    @Column(name="movie_desc")
    private String movieDesc;

    @Column(name="trailer_url")
    private String trailerUrl;

    @Column(name="cover_image_url")
    private String coverImageUrl;

    @Column(name="release_date")
    private Date releaseDate;

    @Column(name="mpaa_id")
    private Integer mpaaId;

    @Column(name="mpaa_rating")
    private String mpaaRating;

    private Float stars = 5.0f;

    @Column(name="movie_price")
    private Float price;

    private Integer length;

    private String studio;

    private String country;

    @Column(name="type")
    private Integer movie_type = 1;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="MOVIE_GENRE",
            joinColumns = @JoinColumn(name="movie_id", referencedColumnName = "movie_id"),
            inverseJoinColumns = @JoinColumn(name="genre_id", referencedColumnName = "genre_id"))
    @JsonIgnore
    private List<Genre> genres;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<MovieCharacter> characters;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<MovieDirector> directors;

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

    public Date getReleaseDate() {
        return releaseDate;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getMpaaId() {
        return mpaaId;
    }

    public void setMpaaId(Integer mpaaId) {
        this.mpaaId = mpaaId;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getMovie_type() {
        return movie_type;
    }

    public void setMovie_type(Integer movie_type) {
        this.movie_type = movie_type;
    }
}
