package com.example.trashit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewPuntosFiltradoActivity extends AppCompatActivity {
    ListView list;
    ArrayList<Material> listaMateriales;
    SharedPreferences pref;

    public static ViewPuntosFiltradoActivity newInstance() {
        return new ViewPuntosFiltradoActivity();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.activity_view_puntos_filtrado, container, false);
        list = (ListView) v.findViewById(R.id.list);
        String partido = pref.getString("partido", null);
        Log.d("partido", partido);
        return v;
    }
}