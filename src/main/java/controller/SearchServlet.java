package controller;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import dao.MovieDao;
import dao.MovieDaoException;
import dao.MovieDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException.*;
import model.Movie;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utility.WorkbookUtility;

@WebServlet(name = "SearchServlet", urlPatterns = "/Search")
public class SearchServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        //get access to our spreadsheet
        //final String filePath = request.getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);
        //final File inputFile = new File(filePath);

        //fetch the list of people
        try {
            //final List<Movie> movies = WorkbookUtility.retrieveMoviesFromWorkbook(inputFile);

            final MovieDao movieDao = new MovieDaoImpl();
            final List<Movie> movies = movieDao.retrieveMovies();

            boolean invalidInputFlag = false;
            //get the input from the user
            String titleFilterString = request.getParameter("title");
            String directorFilterString = request.getParameter("director");
            String lengthInMinutesFilterString = request.getParameter("lengthInMinutes");

            //input validation
            //populate filterString with '' or -1 if no argument or invalid argument was passed in
            //print to web app "Could not apply all filters due to empty or invalid entry for at least one field"
            if (Strings.isNullOrEmpty(titleFilterString)){
                titleFilterString = "";
                invalidInputFlag = true;
            }
            if (Strings.isNullOrEmpty(directorFilterString)){
                directorFilterString = "";
                invalidInputFlag = true;
            }
            //try to convert age input to Integer from String
            Integer lengthInMinutesFilterInteger = -1;
            try {
                lengthInMinutesFilterInteger = Integer.valueOf(lengthInMinutesFilterString);
            } catch (NumberFormatException AgeEntryException){
                lengthInMinutesFilterInteger = -1;
            }
            if (lengthInMinutesFilterInteger < 0){
                //invalidInputFlag = true; //because we are only letting users search by title and director
            }

            //strings need to be final in order to use them in lambda expression
            String finalTitleFilterString = titleFilterString;
            String finalDirectorFilterString = directorFilterString;
            Integer finalLengthInMinutesFilterInteger = lengthInMinutesFilterInteger;

            //filter the list
            final List<Movie> filtered = movies.stream()
                    .filter( (Movie m) -> m.checkAllFilters(finalTitleFilterString, finalDirectorFilterString, finalLengthInMinutesFilterInteger))
                    .collect(Collectors.toList());

            //attach the list to the request
            request.setAttribute("movies",filtered);

            //create message for invalid input, if needed
            String invalidInputMessage = "";
            if(invalidInputFlag==true){
                invalidInputMessage = "Note that some search filters could not be applied due empty or invalid search input.";
            }
            request.setAttribute("invalidInputMessage",invalidInputMessage);

        } catch (MovieDaoException e) {
            e.printStackTrace();
        }

        //forward the request (to the view)
        try {
            request.getServletContext().getRequestDispatcher("/view-all.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request,response);
    }

}
