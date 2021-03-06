package com.example.trashit.dao;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.example.trashit.DataDB;
import com.example.trashit.Puntos;
import com.example.trashit.ViewFiltradoMateriales;
import com.example.trashit.modelo.Direccion;
import com.example.trashit.modelo.Material;
import com.example.trashit.modelo.Partido;
import com.example.trashit.modelo.Ubicacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

public class DaoFiltroMaterial extends AsyncTask<String, Void, String> {

    private Context context;
    private ListView listViewMateriales;
    private String partido, material, filtro = "";
    private static String result2;
    private static ArrayList<Material> listaMateriales = new ArrayList<>();

    public DaoFiltroMaterial(ListView lista, Context ct, String partido, String material) {
        this.context = ct;
        this.listViewMateriales = lista;
        this.partido = partido;
        this.material = material;
    }

    public DaoFiltroMaterial(ListView lista, Context ct, String textoAFiltrar, String partido, String material) {
        this.context = ct;
        this.listViewMateriales = lista;
        this.filtro = textoAFiltrar.toUpperCase(Locale.ROOT);
        this.partido = partido;
        this.material = material;
    }

    @Override
    protected String doInBackground(String... urls) {
        String response = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = con.createStatement();
            ResultSet rs;
            result2 = " ";
            listaMateriales.clear();
            if (filtro.toString().length() > 0) {

                rs = st.executeQuery("select pr.Materiales, pr.id," +
                        "b.descripcion, b.ID_Comuna, geometrycoordinates_y, geometrycoordinates_x, pr.Direccion from Puntos_Reciclado pr " +
                        "inner join Barrio b on pr.barrio = b.id " +
                        "where (cast(pr.id as char) like '%" + filtro + "%'|| direccion like '%" + filtro + "%' || materiales = '" + this.material + "' || geometrycoordinates_x like '%" + filtro + "%' || geometrycoordinates_y like '%" + filtro + "%') &&  b.descripcion = '" + this.partido + "' order by pr.id asc");
            } else {
                rs = st.executeQuery("select pr.Materiales, pr.id, " +
                        "b.descripcion, b.ID_Comuna, geometrycoordinates_y, geometrycoordinates_x, pr.Direccion " +
                        "from Puntos_Reciclado pr " +
                        "inner join Barrio b on pr.barrio = b.id " +
                        "where b.Descripcion = '" + partido + "' and pr.Materiales like '%" + material + "%'");
            }

            while (rs.next()) {
                Partido partido = new Partido(rs.getString("b.descripcion"), rs.getInt("b.ID_Comuna"));
                Direccion direccion = new Direccion(rs.getString("pr.Direccion"));
                Puntos punto = new Puntos(rs.getDouble("geometrycoordinates_y"), rs.getDouble("geometrycoordinates_x"));
                Ubicacion ubicacion = new Ubicacion(partido, direccion, punto);
                Material material = new Material(rs.getString("pr.Materiales"), rs.getInt("pr.id"), ubicacion);

                listaMateriales.add(material);
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
        ViewFiltradoMateriales adapter = new ViewFiltradoMateriales(context, listaMateriales);
        listViewMateriales.setAdapter(adapter);
    }
}
