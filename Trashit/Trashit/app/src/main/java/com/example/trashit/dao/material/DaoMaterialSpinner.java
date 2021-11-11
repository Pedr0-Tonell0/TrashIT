package com.example.trashit.dao.material;

import static com.example.trashit.db.DataDB.CONEXION_EXITOSA;
import static com.example.trashit.db.DataDB.CONEXION_NO_EXITOSA;
import static com.example.trashit.db.DataDB.cerrarConexion;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.trashit.modelo.MaterialSpinner;
import com.example.trashit.db.DataDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DaoMaterialSpinner extends AsyncTask<String, Void, String> {

    private Context context;
    private Spinner sp;

    private static ArrayList<MaterialSpinner> listaMateriales = new ArrayList<>();

    public DaoMaterialSpinner(Spinner sp, Context ct) {
        this.context = ct;
        this.sp = sp;
    }

    @Override
    protected String doInBackground(String... urls) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Material");

            listaMateriales.clear();

            while (rs.next()) {
                MaterialSpinner material = new MaterialSpinner(
                        rs.getInt("id"),
                        rs.getString("descripcion")
                );
                listaMateriales.add(material);
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
        ArrayAdapter<MaterialSpinner> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, listaMateriales);
        sp.setAdapter(adapter);
    }
}