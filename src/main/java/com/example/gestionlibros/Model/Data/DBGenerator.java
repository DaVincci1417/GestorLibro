package com.example.gestionlibros.Model.Data;


import java.sql.Connection;
import java.sql.*;
import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;
import java.sql.Connection;
import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {
    //Metodo inicial para crear una base de datos y sus respectivas tablas en caso de que no exista
    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);
        crearTablaLibro(create);
        crearTablaCategoria(create);
        DBConnector.closeConnection();
    }

    //Metodo para conectarse a una base de datos ya creada
    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    //Crea una base de datos en caso de que no exista
    private static void crearBaseDato(DSLContext create, String nombreBD) {
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    //Actualiza la conexion inicial para conectar a la base de datos
    private static DSLContext actualizarConexion(Connection connection, String nombreBD) {
        DBConnector.closeConnection();
        connection = DBConnector.connection(nombreBD, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    //Método estandar para crear una tabla
    private static void crearTablaLibro(DSLContext create) {
        create.createTableIfNotExists("Libro")
                .column("nombre_libro", VARCHAR(100))
                .column("editorial", VARCHAR(50))
                .column("año", INTEGER)
                .column("nombre-categoria", VARCHAR(50))
                .column("tipo-libro", VARCHAR(50))
                .constraint(primaryKey("nombre_libro")).execute();
    }

    //Método estandar para crear una tabla
    private static void crearTablaCategoria(DSLContext create) {
        create.createTableIfNotExists("Categoria")
                .column("nombre_categoria", VARCHAR(100))
                .constraint(primaryKey("nombre_categoria")).execute();
    }

    //Relaciona dos tablas a traves de una clave foranea
    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String
            nombreTablaRelacion) {
        create.alterTableIfExists(nombreTabla).alterConstraint(foreignKey(claveForanea).references(nombreTablaRelacion)).enforced();
    }

    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType
            tipoColumna) {
        create.alterTableIfExists(nombreTabla).addColumn(columna, tipoColumna);
    }
}
