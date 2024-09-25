package controller;

import java.io.*;

import com.google.common.base.Strings;
import dao.MovieDao;
import dao.MovieDaoException;
import dao.MovieDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException.*;
import model.Movie;

@WebServlet(name = "AddNewMovieServlet", urlPatterns = "/AddNewMovie")
public class AddNewMovieServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String target = "/add-movie.jsp";

        //get the information submitted by the user
        try {
            final String title = request.getParameter("title");
            final String director = request.getParameter("director");
            final String lengthInMinutesString = request.getParameter("lengthInMinutes");

            //input validation
            if (Strings.isNullOrEmpty(title)
                    || Strings.isNullOrEmpty(director)
                    || Strings.isNullOrEmpty(lengthInMinutesString)) {

                //user did nto submit all the necessary information
                request.setAttribute("message", "You must complete all fields to enter a new movie.");
                target = "/addFailure.jsp";
            } else {
                //user submitted all necessary data

                final int lengthInMinutes = Integer.parseInt(lengthInMinutesString);

                final MovieDao movieDao = new MovieDaoImpl();

                //create movie object using the submitted info
                final Movie movie = new Movie(title, director, lengthInMinutes);

                //insert that movie object into the DB using MovieDao
                movieDao.insertMovie(movie);
                request.setAttribute("message", "The movie has been added.");
                target = "/addSuccess.jsp";
            }

        } catch (MovieDaoException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            target = "/addFailure.jsp";
        } catch (NumberFormatException e){
            request.setAttribute("message","Please enter an integer for \"Length (in minutes)\".");
            target = "/addFailure.jsp";
        }

        try {
            request.getServletContext().getRequestDispatcher(target).forward(request,response);
        } catch (ServletException|IOException e) {
            e.printStackTrace();
        }
    }

}
