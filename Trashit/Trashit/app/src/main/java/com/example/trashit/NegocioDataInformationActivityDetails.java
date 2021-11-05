package com.example.trashit;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.example.trashit.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class NegocioDataInformationActivityDetails extends AsyncTask<String, Void, String> {

    Context context;
    TextView tv;
    ScrollView sv;
    String id;
    private static String result2;
    String details;
    String image;

    public NegocioDataInformationActivityDetails(TextView tv, Context ct, String id, ScrollView sv) {
        this.context = ct;
        this.tv = tv;
        this.id = id;
        this.sv = sv;
    }

    @Override
    protected String doInBackground(String... strings) {
        String response = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Material where ID = " + this.id);
            result2 = " ";

            while (rs.next()) {
                this.details = rs.getString("Informacion");
                this.image = rs.getString("Imagen");
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
        tv.setText(this.details);

        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(this.image, "drawable",
                context.getPackageName());

        @SuppressLint("UseCompatLoadingForDrawables") Drawable myIcon = context.getResources().getDrawable( resourceId );
        this.sv.setBackground(myIcon);
    }
}
