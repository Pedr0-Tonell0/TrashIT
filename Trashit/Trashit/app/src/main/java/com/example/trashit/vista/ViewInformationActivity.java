package com.example.trashit.vista;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trashit.modelo.MaterialSpinner;
import com.example.trashit.negocio.NegocioMaterial;

public class ViewInformationActivity extends AppCompatActivity {

    private Spinner dropdown;
    private TextView tv;
    ScrollView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        dropdown = findViewById(R.id.spinner1);
        tv = findViewById(R.id.tvDescription);
        sv = findViewById(R.id.scrollDetails);

        this.connect(dropdown);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                MaterialSpinner spn = (MaterialSpinner) parent.getItemAtPosition(i);
                Toast.makeText(ViewInformationActivity.this, spn.id.toString(), Toast.LENGTH_LONG).show();
                ViewInformationActivity.this.getInfoDetails(spn.id.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void connect(Spinner dropdown) {
        NegocioMaterial negocioMaterial = new NegocioMaterial();
        negocioMaterial.getMateriales(dropdown, this);

    }

    public void getInfoDetails(String id) {
        NegocioMaterial negocioMaterial = new NegocioMaterial();
        negocioMaterial.getMaterialesById(this.tv, this, id, this.sv);
    }
}