package com.example.trashit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.example.trashit.dao.DaoMaterial;
import com.example.trashit.dao.DaoPartido;

public class ViewPuntosActivity extends AppCompatActivity {
    private Spinner listaPartidos;
    private Spinner listaMateriales;
    private String material, partido;
    private Button redirigir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_filtro_materiales);
        getListaBarrios();
        getListaMateriales();
        redirigir = findViewById(R.id.redirigirFiltrado);
        View view = new View(this);
        redireccion_filtrado(view);
    }

    private void getListaBarrios() {
        try {
            listaPartidos = findViewById(R.id.spinnerPartido);
            this.connectPartido(listaPartidos);

            listaPartidos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                    partido = (String) parent.getItemAtPosition(i);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void getListaMateriales() {
        try {
            listaMateriales = findViewById(R.id.spinnerMaterial);
            this.connectMateriales(listaMateriales);
            listaMateriales.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                    material = (String) parent.getItemAtPosition(i);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void redireccion_filtrado(View view) {
        SharedPreferences pref = getSharedPreferences("filtrado", MODE_PRIVATE);
        try {
            redirigir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("partido", partido);
                    editor.putString("material", material);
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(), ViewBusquedaPorListadoActivity.class);
                    startActivity(intent);
                }
            });
        } catch (Exception e) {
            Log.d("error", e.getMessage());
        }
    }

    private void connectMateriales(Spinner dropdown) {
        DaoMaterial task = new DaoMaterial(dropdown, this);
        task.execute();
    }

    public void connectPartido(Spinner dropdown) {
        DaoPartido task = new DaoPartido(dropdown, this);
        task.execute();
    }
}