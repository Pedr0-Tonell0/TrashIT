package com.example.trashit.dao;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.trashit.DataDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoComuna extends AsyncTask<String, Void, String> {
    private Context context;
    private Spinner sp;
    private String partido;

    private static String result2;
    private static ArrayList<String> listaPartido = new ArrayList<>();

    public DaoComuna(String partido, Context ct) {
        this.context = ct;
        this.sp = sp;
        this.partido = partido;
    }

    @Override
    protected String doInBackground(String... urls) {
        String response = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Comuna_Localidad cl where cl.Comuna_Localidad = (select comuna from Barrio b where b.barrio = '"+this.partido+"')");
            result2 = " ";

            listaPartido.clear();

            while (rs.next()) {
                String partido =
                        rs.getString("Barrio");
                listaPartido.add(partido);
            }
            rs.close();
            con.close();
            response = "Conexion exitosa";
        } catch (Exception e) {
            e.printStackTrace();
            result2 = "Conexion no exitosa";
        }
        return response;

    }

    @Override
    protected void onPostExecute(String response) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, listaPartido);
        sp.setAdapter(adapter);
    }
}
