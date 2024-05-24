package com.funolympics.servlet;

import com.funolympics.dao.ThreadDAO;
import com.funolympics.model.Thread;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewThreadsServlet")
public class ViewThreadsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThreadDAO threadDAO = new ThreadDAO();
        try {
            List<Thread> threadList = threadDAO.getAllThreads();
            request.setAttribute("threadList", threadList);
            request.getRequestDispatcher("forum.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while retrieving threads.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
