package controller;

import java.io.*;

import dao.MovieDao;
import dao.MovieDaoException;
import dao.MovieDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException.*;
import utility.DBUtility;
import utility.WorkbookUtility;

@WebServlet(name = "PopulateServlet", urlPatterns = "/Populate")
public class PopulateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        final String filePath = request.getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);

        final MovieDao movieDao = new MovieDaoImpl();

        String message = "";
        try {
            movieDao.populate(filePath);
            message = "The database was successfully populated.";
        } catch (MovieDaoException e) {
            e.printStackTrace();
            message = "There was an error. The database was not populated.";
        }

        request.setAttribute("message",message);
        try {
            request.getServletContext().getRequestDispatcher("/populate.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
