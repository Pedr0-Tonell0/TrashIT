package com.example.trashit.dao;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.trashit.db.DataDB;
import com.example.trashit.modelo.Puntos;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoPuntos extends AsyncTask<String, Void, String> {
    private static String result2;
    private static ArrayList<Puntos> list = new ArrayList<Puntos>();
    private GoogleMap mMap;
    private Context context;
    private double latitud, longitud;

    public DaoPuntos(GoogleMap map, Context ct, double latitud1, double longitud1) {
        mMap = map;
        context = ct;
        latitud = latitud1;
        longitud = longitud1;
    }


    @Override
    protected String doInBackground(String... strings) {
        double latitudMas = latitud + 0.01;
        double latitudMenos = latitud - 0.01;
        double longitudMas = longitud + 0.01;
        double longitudMenos = longitud - 0.01;
        String response = "";
        Puntos Puntos;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select geometrycoordinates_x,geometrycoordinates_y,materiales, Direccion from Puntos_Reciclado WHERE" +
                    "(geometrycoordinates_y <= " + latitudMas + " AND geometrycoordinates_y >= " + latitudMenos + " ) AND (geometrycoordinates_x <= " + longitudMas + " AND geometrycoordinates_x >= " + longitudMenos + " )");
            list.clear();
            while (rs.next()) {
                Puntos = new Puntos();
                Puntos.setLongitud(rs.getDouble("geometrycoordinates_x"));
                Puntos.setLatitud(rs.getDouble("geometrycoordinates_y"));
                Puntos.setDescripcion(rs.getString("materiales"));
                Puntos.setDireccion(rs.getString("Direccion"));
                list.add(Puntos);
                response = "Hay puntos cercanos a su ubicación";
            }
            if (response == "") {
                response = "No hay puntos cercanos a su ubicación";
            }
        } catch (Exception e) {
            e.printStackTrace();
            response = "Ha ocurrido un error";
        }
        return response;
    }

    @Override
    protected void onPostExecute(String response) {
        if (response == "Hay puntos cercanos a su ubicación") {
            for (Puntos ubicaciones : list) {
                LatLng ubicacion = new LatLng(ubicaciones.getLatitud(), ubicaciones.getLongitud());
                mMap.addMarker(new MarkerOptions().position(ubicacion).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).title(ubicaciones.getDescripcion() + "\n" + ubicaciones.getDireccion()));
            }
        } else {
            Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
        }
    }
}
