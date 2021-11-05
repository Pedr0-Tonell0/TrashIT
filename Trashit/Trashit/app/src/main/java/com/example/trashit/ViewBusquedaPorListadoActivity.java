package com.example.trashit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trashit.dao.DaoFiltroMaterial;

public class ViewBusquedaPorListadoActivity extends AppCompatActivity {

    private ListView listaFiltrado;
    private Button botonBuscar;
    private EditText textoBuscar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_settings);
        listaFiltrado = findViewById(R.id.list);
        SharedPreferences prf = getSharedPreferences("filtrado", MODE_PRIVATE);
        String partido = prf.getString("partido", null);
        String material = prf.getString("material", null);
        getFiltradoByPartido_Material(partido, material);
        botonBuscar = findViewById(R.id.botonTextoBuscar);
        textoBuscar = findViewById(R.id.textoABuscar) ;

        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrarMateriales(textoBuscar.getText().toString(), partido, material);
            }

        });
    }

    private void filtrarMateriales(String textoAFiltrar, String partido, String material) {
        DaoFiltroMaterial task = new DaoFiltroMaterial(listaFiltrado, getApplicationContext(), textoAFiltrar, partido, material);
        task.execute();
    }

    private void getFiltradoByPartido_Material(String partido, String material) {
        DaoFiltroMaterial task = new DaoFiltroMaterial(listaFiltrado, getApplicationContext(), partido, material);
        task.execute();
    }
}