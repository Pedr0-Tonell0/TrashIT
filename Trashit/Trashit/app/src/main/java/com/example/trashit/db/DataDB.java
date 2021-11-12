package com.example.trashit.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataDB {
    //Información de la BD
    public static String host = "sql10.freesqldatabase.com";
    public static String port = "3306";
    public static String nameBD = "sql10450491";
    public static String user = "sql10450491";
    public static String pass = "H6h5N8GTXX";

    //Información para la conexion
    public static String urlMySQL = "jdbc:mysql://" + host + ":" + port + "/" + nameBD;
    public static String driver = "com.mysql.jdbc.Driver";

    public static String CONEXION_EXITOSA = "Conexion exitosa";
    public static String CONEXION_NO_EXITOSA = "Conexion no exitosa";

    public static void cerrarConexion(ResultSet rs, Connection con, Statement st) throws SQLException {
        try {
            if (rs != null) rs.close();
            if (con != null) con.close();
            if (st != null) st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
