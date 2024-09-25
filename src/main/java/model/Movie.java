package model;

import java.io.Serializable;

public class Movie implements Serializable {
    private String title;
    private String director;
    private int lengthInMinutes;

    public Movie() {
    }
    public Movie(String title, String director, Integer lengthInMinutes) {
        this.title = title;
        this.director = director;
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public Integer getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLengthInMinutes(Integer lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", lengthInMinutes=" + lengthInMinutes +
                '}';
    }

    //compare a movie's properties with the list of filters provided
    //return true if the following is true for each filter; otherwise return false
    // - either no data was provided for the property (-1 for integer, "" for string)
    // - OR the data provided matches the property for the movie provided (exact match for integer, movie property contains search string for string)
    public boolean checkAllFilters (String titleFilterString, String directorFilterString, Integer lengthInMinutesFilterInteger){
        boolean filterMatch = true;
        if (!titleFilterString.isEmpty() && !this.getTitle().toLowerCase().contains(titleFilterString.toLowerCase())){
            filterMatch = false;
        }
        if (!directorFilterString.isEmpty() && !this.getDirector().toLowerCase().contains(directorFilterString.toLowerCase())){
            filterMatch = false;
        }
        if (lengthInMinutesFilterInteger >= 0 && !this.getLengthInMinutes().equals(lengthInMinutesFilterInteger)){
            filterMatch = false;
        }
        return filterMatch;
    }
}
