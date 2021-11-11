package com.example.trashit.negocio;

import android.content.Context;

import com.example.trashit.dao.DaoPuntos;
import com.google.android.gms.maps.GoogleMap;

public class NegocioPunto {

    public void getPuntos(GoogleMap mMap, Context applicationContext, double latitud, double longitud) {
        DaoPuntos task = new DaoPuntos(mMap, applicationContext, latitud, longitud);
        task.execute();
    }
}
