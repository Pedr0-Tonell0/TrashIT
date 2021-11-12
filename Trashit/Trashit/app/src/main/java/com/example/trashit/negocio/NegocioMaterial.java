package com.example.trashit.negocio;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.trashit.dao.material.DaoFiltroMaterial;
import com.example.trashit.dao.material.DaoMaterial;
import com.example.trashit.dao.material.DaoMaterialById;
import com.example.trashit.dao.material.DaoMaterialSpinner;
import com.example.trashit.vista.ViewInformationActivity;
import com.example.trashit.vista.ViewPuntosActivity;

public class NegocioMaterial {

    public void filtroMaterial(ListView listaFiltrado, Context applicationContext, String textoAFiltrar, String partido, String material) {
        DaoFiltroMaterial task = new DaoFiltroMaterial(listaFiltrado, applicationContext, textoAFiltrar, partido, material);
        task.execute();
    }

    public void filtroMaterialPorPartido(ListView listaFiltrado, Context applicationContext, String partido, String material) {
        DaoFiltroMaterial task = new DaoFiltroMaterial(listaFiltrado, applicationContext, partido, material);
        task.execute();
    }

    public void getMateriales(Spinner dropdown, ViewInformationActivity viewInformationActivity) {
        DaoMaterialSpinner task = new DaoMaterialSpinner(dropdown, viewInformationActivity);
        task.execute();
    }

    public void getMaterialesById(TextView tv, ViewInformationActivity viewInformationActivity, String id, ScrollView sv, ImageView imagenMaterial) {
        DaoMaterialById task = new DaoMaterialById(tv, viewInformationActivity, id, sv, imagenMaterial);
        task.execute();
    }

    public void getMaterialesWithViewInformation(Spinner dropdown, ViewPuntosActivity viewPuntosActivity) {
        DaoMaterial task = new DaoMaterial(dropdown, viewPuntosActivity);
        task.execute();
    }
}
