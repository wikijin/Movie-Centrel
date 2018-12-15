package cmpe275.dos.dto;

import java.io.Serializable;

public class MovieHistoryDto implements Serializable {

    private Integer movieId;

    private Integer userId;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
