package com.example.gestionlibros.Model.Data.DAO;

import com.example.gestionlibros.Model.Categoria;
import com.example.gestionlibros.Model.Libro;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class CategoriaDAO {
    public static void agregarCategoria(DSLContext query, Categoria categoria){
        Table tablaCategoria = table(name("Categoria"));
        Field[] columnas = tablaCategoria.fields("nombre_categoria");
        query.insertInto(tablaCategoria, columnas[0])
                .values(categoria.getNombre())
                .execute();
    }
    public static void modificarCategoria(DSLContext query, String nombre, String columnaTabla, Object dato){
        query.update(DSL.table("Categoria")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("nombre_categoria").eq(nombre)).execute();
    }
    public static List obtenerCategoria(DSLContext query, String columnaTabla, String dato){
        Result resultados = query.select().from(DSL.table("Categoria")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaCategorias(resultados);
    }
    public static List obtenerCategorias(DSLContext query){
        Result resultados = query.select().from(DSL.table("Categoria")).fetch();
        return obtenerListaCategorias(resultados);
    }
    public static void eliminarCategoria(DSLContext query, String nombre){
        Table tablaCategoria = table(name("Categoria"));
        query.delete(DSL.table("Categoria")).where(DSL.field("nombre_categoria").eq(nombre)).execute();
    }
    private static List obtenerListaCategorias(Result resultados){
        List<Categoria> categorias = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            String nombre = (String) resultados.getValue(fila,"nombre_categoria");

            categorias.add(new Categoria(nombre));
        }
        return categorias;
    }
}
