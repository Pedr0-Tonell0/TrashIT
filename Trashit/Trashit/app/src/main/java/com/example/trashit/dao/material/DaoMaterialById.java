package com.example.trashit.dao.material;

import static com.example.trashit.db.DataDB.CONEXION_EXITOSA;
import static com.example.trashit.db.DataDB.CONEXION_NO_EXITOSA;
import static com.example.trashit.db.DataDB.cerrarConexion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.trashit.db.DataDB;
import com.example.trashit.vista.R;
import com.squareup.picasso.Picasso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoMaterialById extends AsyncTask<String, Void, String> {

    Context context;
    TextView tv;
    ScrollView sv;
    String id;
    String details, image;
    ImageView imagen;

    public DaoMaterialById(TextView tv, Context ct, String id, ScrollView sv, ImageView imagenMaterial) {
        this.context = ct;
        this.tv = tv;
        this.id = id;
        this.sv = sv;
        this.imagen = imagenMaterial;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Material where ID = " + this.id + " order by Descripcion");

            while (rs.next()) {
                this.details = rs.getString("Informacion");
                this.image = rs.getString("Imagen");
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
        Picasso.get()
                .load(this.image)
                .error(R.mipmap.ic_launcher_round)
                .into(imagen);
        tv.setText(this.details);
    }
}
