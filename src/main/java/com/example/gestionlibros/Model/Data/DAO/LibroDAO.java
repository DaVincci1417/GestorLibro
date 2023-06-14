package com.example.gestionlibros.Model.Data.DAO;

import com.example.gestionlibros.Model.Libro;

import java.util.ArrayList;
import java.util.List;
import org.jooq.*;
import org.jooq.impl.DSL;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;
public class LibroDAO {
    public static void agregarLibro(DSLContext query, Libro libro){
        Table tablaLibro = table(name("Libro"));
        Field[] columnas = tablaLibro.fields("nombre_","editorial","año","nombre_categoria","tipo_libro");
        query.insertInto(tablaLibro, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4])
                .values(libro.getNombre(), libro.getEditorial(), libro.getAño(), libro.getCategoria(), libro.getTipoLibro())
                .execute();
    }
    public static void modificarLibro(DSLContext query, String nombre, String columnaTabla, Object dato){
        query.update(DSL.table("Libro")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("nombre_categoria").eq(nombre)).execute();
    }
    public static List obtenerLibro(DSLContext query, String columnaTabla, String dato){
        Result resultados = query.select().from(DSL.table("Libro")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaLibros(resultados);
    }
    public static List obtenerLibros(DSLContext query){
        Result resultados = query.select().from(DSL.table("Libro")).fetch();
        return obtenerListaLibros(resultados);
    }
    public static void eliminarLibro(DSLContext query, String nombre){
        Table tablaLibro = table(name("Libro"));
        query.delete(DSL.table("Libro")).where(DSL.field("nombre_categoria").eq(nombre)).execute();
    }
    private static List obtenerListaLibros(Result resultados){
        List<Libro> libros = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            String nombre = (String) resultados.getValue(fila,"nombre_categoria");
            String editorial = (String) resultados.getValue(fila,"editorial");
            int año = (Integer) resultados.getValue(fila,"año");
            String categoria = (String) resultados.getValue(fila,"nombre_categoria");
            String tipoLibro = (String) resultados.getValue(fila,"tipo_libro");

            libros.add(new Libro(nombre, editorial, año, categoria, tipoLibro));
        }
        return libros;
    }
}
