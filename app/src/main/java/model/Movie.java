package model;

import java.util.Date;

public class Movie {
    private String title;
    private String poster_path;
    private String overview;
    private Double vote_average;
    private String release_date;



public Movie(){}
     public Movie(String title, String poster_path, String overview, Double vote_average, String release_date) {
            this.title = title;
            this.poster_path = poster_path;
            this.overview = overview;
            this.vote_average = vote_average;
            this.release_date = release_date;
        }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;

    }

}
