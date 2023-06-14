package com.example.gestionlibros.Controller;

import com.example.gestionlibros.Model.Categoria;
import com.example.gestionlibros.Model.Data.DAO.CategoriaDAO;
import com.example.gestionlibros.Model.Data.DAO.LibroDAO;
import com.example.gestionlibros.Model.Data.DBConnector;
import com.example.gestionlibros.Model.Data.DBGenerator;
import com.example.gestionlibros.Model.Libro;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;
import org.jooq.Results;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "agregarLibroServlet", value = "/agregarLibro")
public class agregarLibroServlet extends HttpServlet{
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("GestorLibro");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher respuesta = request.getRequestDispatcher("/agregarLibro.jsp");
        respuesta.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/errorAgregarLibro.jsp");
        if(req.getParameter("nombre").length()!=0 || req.getParameter("editorial").length() != 0 || req.getParameter("año").length() != 0
                || req.getParameter("nombreCategoria").length() != 0 || req.getParameter("tipoLibro").length() != 0){
            String nombre = req.getParameter("nombre");
            String editorial = req.getParameter("editorial");
            int año = Integer.parseInt(req.getParameter("año"));
            String categoria = req.getParameter("nombreCategoria");
            String tipoLibro = req.getParameter("tipoLibro");

            Libro libro = new Libro(nombre, editorial, año, categoria , tipoLibro);

            try {
                if(agregarLibro(libro)){
                    req.setAttribute("Libro",libro);
                    respuesta = req.getRequestDispatcher("/exitoAgregarLibro.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarLibro(Libro libro) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("GestorLibro");
        List<Libro> libros = LibroDAO.obtenerLibro(query,"nombre_libro",libro.getNombre());
        if(libros.size()!=0){
            return false;
        }
        else{
            LibroDAO.agregarLibro(query,libro);
            return true;
        }
    }
}
