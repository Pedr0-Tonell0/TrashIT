package com.example.trashit.vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ViewMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Redireccion (View view)
    {
        Intent intent = new Intent(this, ViewHomeActivity.class);
        startActivity(intent);

    }
}