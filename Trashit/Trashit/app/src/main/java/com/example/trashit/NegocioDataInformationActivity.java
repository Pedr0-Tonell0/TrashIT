package com.example.trashit;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class NegocioDataInformationActivity extends AsyncTask<String, Void, String> {

    private Context context;
    private Spinner sp;

    private static String result2;
    private static ArrayList<MaterialSpinner> listaMateriales = new ArrayList<>();

    public NegocioDataInformationActivity(Spinner sp, Context ct){
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
            ResultSet rs = st.executeQuery("SELECT * FROM Material");
            result2 = " ";

            listaMateriales.clear();

            while(rs.next()) {
                MaterialSpinner material = new MaterialSpinner(
                        rs.getInt("id"),
                        rs.getString("descripcion")
                );
                listaMateriales.add(material);
            }
            rs.close();
            con.close();
            response = "Conexion exitosa";
        }
        catch(Exception e) {
            e.printStackTrace();
            result2 = "Conexion no exitosa";
        }
        return response;

    }

    @Override
    protected void onPostExecute(String response) {
        ArrayAdapter<MaterialSpinner> adapter =  new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item ,listaMateriales);
        sp.setAdapter(adapter);
    }
}