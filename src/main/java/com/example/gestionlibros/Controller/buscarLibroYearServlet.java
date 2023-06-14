package com.example.gestionlibros.Controller;

import com.example.gestionlibros.Model.Categoria;
import com.example.gestionlibros.Model.Data.DBGenerator;
import com.example.gestionlibros.Model.Libro;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "buscarLibroYearServlet", value = "/buscarLibroYear")
public class buscarLibroYearServlet extends HttpServlet{
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("GestorLibro");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher respuesta = request.getRequestDispatcher("/buscarLibroAño.jsp");
        respuesta.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(request.getParameter("año").length() == 0){
            RequestDispatcher respuesta = request.getRequestDispatcher("/errorBuscarLibroAño.jsp");
            respuesta.forward(request, response);
        }
        else{
            int año = Integer.parseInt(request.getParameter("año"));

            RequestDispatcher respuesta = request.getRequestDispatcher("/index.jsp");
            respuesta.forward(request, response);
        }
    }
}
