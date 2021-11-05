package com.example.trashit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void Redireccion_Mapa (View view)
    {
        Intent intent = new Intent(this, ViewMapsActivity.class);
        startActivity(intent);

    }
    public void Redireccion_Filtrado (View view)
    {
        Intent intent = new Intent(this, ViewPuntosActivity.class);
        startActivity(intent);

    }

    public void Redireccion_Listado (View view)
    {
        Intent intent = new Intent(this, ViewInformationActivity.class);
        startActivity(intent);

    }
}