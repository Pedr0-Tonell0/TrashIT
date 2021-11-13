package com.example.trashit.dao;

import static com.example.trashit.db.DataDB.CONEXION_EXITOSA;
import static com.example.trashit.db.DataDB.CONEXION_NO_EXITOSA;
import static com.example.trashit.db.DataDB.cerrarConexion;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.trashit.db.DataDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoPartido extends AsyncTask<String, Void, String> {

    private Context context;
    private Spinner sp;

    private static ArrayList<String> listaPartido = new ArrayList<>();

    public DaoPartido(Spinner sp, Context ct) {
        this.context = ct;
        this.sp = sp;
    }

    @Override
    protected String doInBackground(String... urls) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Barrio order by Descripcion");
            listaPartido.clear();
            while (rs.next()) {
                listaPartido.add(rs.getString("Descripcion"));
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