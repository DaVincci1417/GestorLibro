package com.example.gestionlibros.Controller;

import com.example.gestionlibros.Model.Categoria;
import com.example.gestionlibros.Model.Data.DAO.CategoriaDAO;
import com.example.gestionlibros.Model.Data.DAO.LibroDAO;
import com.example.gestionlibros.Model.Data.DBGenerator;
import com.example.gestionlibros.Model.Libro;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "agregarCategoriaServlet", value = "/agregarCategoria")
public class agregarCategoriaServlet extends HttpServlet {
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
        RequestDispatcher respuesta = request.getRequestDispatcher("/agregarCategoria.jsp");
        respuesta.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher respuesta = req.getRequestDispatcher("/errorAgregarCategoria.jsp");
        if(req.getParameter("nombre").length()!=0){
            String nombre = req.getParameter("nombre");

            Categoria categoria = new Categoria(nombre);

            try {
                if(agregarCategoria(categoria)){
                    req.setAttribute("Categoria",categoria);
                    respuesta = req.getRequestDispatcher("/exitoAgregarCategoria.jsp");
                }else{
                    RequestDispatcher  errorRepetido = req.getRequestDispatcher("/errorAgregarCategoriaRepetida.jsp");
                    errorRepetido.forward(req, resp);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }

    private boolean agregarCategoria(Categoria categoria) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("GestorLibro");
        List<Categoria> categorias = CategoriaDAO.obtenerCategoria(query,"nombre_categoria", categoria.getNombre());
        if(categorias.size()!=0){
            return false;
        }
        else{
            CategoriaDAO.agregarCategoria(query, categoria);
            return true;
        }
    }
}
