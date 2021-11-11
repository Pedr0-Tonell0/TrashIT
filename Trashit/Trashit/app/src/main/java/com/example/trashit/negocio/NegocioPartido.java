package com.example.trashit.negocio;

import android.widget.Spinner;

import com.example.trashit.dao.DaoPartido;
import com.example.trashit.vista.ViewPuntosActivity;

public class NegocioPartido {
    public void getPartido(Spinner dropdown, ViewPuntosActivity viewPuntosActivity) {

        DaoPartido task = new DaoPartido(dropdown, viewPuntosActivity);
        task.execute();
    }
}
