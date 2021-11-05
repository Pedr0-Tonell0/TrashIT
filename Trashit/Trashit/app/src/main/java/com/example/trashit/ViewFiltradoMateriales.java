package com.example.trashit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.trashit.modelo.Material;

import java.util.ArrayList;
import java.util.List;

public class ViewFiltradoMateriales extends ArrayAdapter<Material> {
    public ViewFiltradoMateriales(Context context, ArrayList<Material> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.activity_listado_materiales, null);

        TextView direccion = (TextView) item.findViewById(R.id.direccion);
        TextView material = (TextView) item.findViewById(R.id.material);
        TextView barrio = (TextView) item.findViewById(R.id.barrio);
        TextView latitud = (TextView) item.findViewById(R.id.latitud);
        TextView longitud = (TextView) item.findViewById(R.id.longitud);

        direccion.setText("Direccion: "+ getItem(position).getUbicacion().getDireccion().getDireccion()+"");
        material.setText("Material: "+ getItem(position).getNombre());
        barrio.setText("Barrio: " + getItem(position).getUbicacion().getPartido().getPartido());
        latitud.setText("Latitud: " + getItem(position).getUbicacion().getPunto().getLatitud());
        longitud.setText("Longitud: " + getItem(position).getUbicacion().getPunto().getLongitud());
        return item;
    }
}
