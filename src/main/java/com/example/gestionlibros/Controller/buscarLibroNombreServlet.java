package com.example.gestionlibros.Controller;

import com.example.gestionlibros.Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "buscarLibroNombreServlet", value = "/buscarLibroNombre")
public class buscarLibroNombreServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("GestorLibro");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher respuesta = request.getRequestDispatcher("/buscarLibroNombre.jsp");
        respuesta.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("nombre").length() == 0) {
            RequestDispatcher respuesta = request.getRequestDispatcher("/errorBuscarLibroNombre.jsp");
            respuesta.forward(request, response);
        } else {
            String nombre = request.getParameter("nombre");

            RequestDispatcher respuesta = request.getRequestDispatcher("/index.jsp");
            respuesta.forward(request, response);
        }
    }
}
