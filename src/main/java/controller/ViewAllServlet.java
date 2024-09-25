package controller;

import java.io.*;
import java.util.Collections;
import java.util.List;

import comparator.DirectorComparator;
import comparator.LengthInMinutesComparator;
import comparator.TitleComparator;
import dao.MovieDao;
import dao.MovieDaoException;
import dao.MovieDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException.*;
import model.Movie;
import utility.WorkbookUtility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

@WebServlet(name = "ViewAllServlet", urlPatterns = "/ViewAll")
public class ViewAllServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String target = "/view-all.jsp";
        //get access to our spreadsheet
        //final String filePath = request.getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);
        //final File inputFile = new File(filePath);

        //fetch the information and use it to populate the model
        try {
            //final List<Movie> movies = WorkbookUtility.retrieveMoviesFromWorkbook(inputFile);

            final MovieDao movieDao = new MovieDaoImpl();
            final List<Movie> movies = movieDao.retrieveMovies();
            //put new entries by user at the top if unsorted list is chosen
            Collections.reverse(movies);

            String sortType = request.getParameter("sortType");
            if(null != sortType && sortType.equals("title")){
                Collections.sort(movies,new TitleComparator());
            } else if(null != sortType && sortType.equals("director")){
                Collections.sort(movies,new DirectorComparator());
            } else if(null != sortType && sortType.equals("lengthInMinutes")){
                Collections.sort(movies,new LengthInMinutesComparator());
            }
            //attach the model to the request
            request.setAttribute("movies", movies);

        } catch (MovieDaoException e) {
            throw new RuntimeException(e);
        }

        //forward the request to the view

        request.getServletContext().getRequestDispatcher(target).forward(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
