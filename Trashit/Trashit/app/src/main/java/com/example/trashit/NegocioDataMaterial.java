package com.example.trashit;

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

public class NegocioDataMaterial extends AsyncTask<String, Void, String> {
    private Context context;
    private Spinner sp;

    private static String result2;
    private static ArrayList<String> listaMaterial = new ArrayList<>();

    public NegocioDataMaterial(Spinner sp, Context ct) {
        this.context = ct;
        this.sp = sp;
    }

    @Override
    protected String doInBackground(String... urls) {
        String response = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT M.Descripcion FROM Material M");
            result2 = " ";

            listaMaterial.clear();

            while (rs.next()) {
                listaMaterial.add(rs.getString("Descripcion"));
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
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, listaMaterial);
        sp.setAdapter(adapter);
    }
}
