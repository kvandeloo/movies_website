package dao;

import model.Movie;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utility.DBUtility;
import utility.WorkbookUtility;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao{

    final static String DROP_TABLE = "drop table if exists movie;";
    final static String CREATE_TABLE = "create table movie (id integer primary key autoincrement, title text, director text, lengthInMInutes integer);";
    final static String SELECT_ALL_FROM_MOVIE = "select * from movie;";

    @Override
    public void populate(String filePath) throws MovieDaoException {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBUtility.createConnection();
            statement = connection.createStatement();

            statement.setQueryTimeout(DBUtility.TIMEOUT);

            statement.executeUpdate(DROP_TABLE);
            statement.executeUpdate(CREATE_TABLE);

            //populate the database from the WorkbookUtility
            final File inputFile = new File(filePath);
            final List<Movie> movies = WorkbookUtility.retrieveMoviesFromWorkbook(inputFile);

            for(final Movie movie : movies){
                final String insertValues = "insert into movie (title,director,lengthInMinutes) " +
                        "values ('" + movie.getTitle().replace("'","''") + "', '"
                        + movie.getDirector().replace("'","''") + "', "
                        + movie.getLengthInMinutes()
                        + ");";
                System.out.println(insertValues); //NOTES log the sql that we execute

                statement.executeUpdate(insertValues);
            }

        } catch (ClassNotFoundException | SQLException | IOException | InvalidFormatException e){
            e.printStackTrace();
            throw new MovieDaoException("Error: Unable to populate database.");
        }
    }

    @Override
    public List<Movie> retrieveMovies() throws MovieDaoException {
        //create the list of movies
        final List<Movie> movies = new ArrayList<Movie>();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBUtility.createConnection();
            statement = connection.createStatement();

            statement.setQueryTimeout(DBUtility.TIMEOUT);

            //fetch all from the movie table
            final ResultSet results = statement.executeQuery(SELECT_ALL_FROM_MOVIE);

            //loop through the result
            while(results.next()){
                final String title = results.getString("title");
                final String director = results.getString("director");
                final int lengthInMinutes = results.getInt("lengthInMinutes");

                movies.add(new Movie(title,director,lengthInMinutes));

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new MovieDaoException("Error: Unable to retrieve list of movies.");
        }

        return movies;
    }

    @Override
    public void insertMovie(Movie movie) throws MovieDaoException {

        //set up database connection and statement
        Connection connection = null;
        PreparedStatement insertStatement = null;


        try {
            connection = DBUtility.createConnection();
            final String sqlString = "insert into movie (title, director, lengthInMinutes) values (?,?,?);";

            insertStatement = connection.prepareStatement(sqlString);
            insertStatement.setString(1,movie.getTitle());
            insertStatement.setString(2,movie.getDirector());
            insertStatement.setInt(3,movie.getLengthInMinutes());

            insertStatement.setQueryTimeout(DBUtility.TIMEOUT);

            insertStatement.executeUpdate();


        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
            throw new MovieDaoException("Error: Unable to insert movie.");
        }
    }
}
