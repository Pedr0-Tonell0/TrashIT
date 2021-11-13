package com.example.trashit.dao.material;

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

public class DaoMaterial extends AsyncTask<String, Void, String> {
    private Context context;
    private Spinner sp;

    private static ArrayList<String> listaMaterial = new ArrayList<>();

    public DaoMaterial(Spinner sp, Context ct) {
        this.context = ct;
        this.sp = sp;
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
            rs = st.executeQuery("SELECT M.Descripcion FROM Material M order by M.Descripcion");
            listaMaterial.clear();
            while (rs.next()) {
                listaMaterial.add(rs.getString("Descripcion"));
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
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, listaMaterial);
        sp.setAdapter(adapter);
    }
}
