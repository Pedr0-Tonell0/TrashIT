package com.example.trashit.dao;

import static com.example.trashit.db.DataDB.CONEXION_EXITOSA;
import static com.example.trashit.db.DataDB.CONEXION_NO_EXITOSA;
import static com.example.trashit.db.DataDB.cerrarConexion;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.trashit.db.DataDB;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoComuna extends AsyncTask<String, Void, String> {
    private Context context;
    private Spinner sp;
    private String partido;

    private static ArrayList<String> listaPartido = new ArrayList<>();

    public DaoComuna(String partido, Context ct) {
        this.context = ct;
        this.sp = sp;
        this.partido = partido;
    }

    @Override
    protected String doInBackground(String... urls) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Comuna_Localidad cl where cl.ID = (select ID_Comuna from Barrio b where b.Descripcion = '" + this.partido + "') order by Descripcion");
            listaPartido.clear();
            while (rs.next()) {
                String partido =
                        rs.getString("Barrio");
                listaPartido.add(partido);
            }
            cerrarConexion(rs, con, st);
            return CONEXION_EXITOSA;
        } catch (Exception e) {
            e.printStackTrace();
            return CONEXION_NO_EXITOSA;
        }
    }

    @Override
    protected void onPostExecute(String response) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, listaPartido);
        sp.setAdapter(adapter);
    }
}
