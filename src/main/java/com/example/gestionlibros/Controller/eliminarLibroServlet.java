package com.example.gestionlibros.Controller;

import com.example.gestionlibros.Model.Data.DBGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

public class eliminarLibroServlet extends HttpServlet{
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("GestorLibro");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
