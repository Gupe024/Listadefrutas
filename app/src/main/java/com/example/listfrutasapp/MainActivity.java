package com.example.listfrutasapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ArrayList<Fruta> frutas = new ArrayList<>();
        frutas.add(new Fruta("Manzana", R.drawable.manzana));
        frutas.add(new Fruta("Naranja", R.drawable.naranja));
        frutas.add(new Fruta("Platano", R.drawable.platano));
        frutas.add(new Fruta("Sandia", R.drawable.sandia));
        frutas.add(new Fruta("Uvas", R.drawable.uvas));
        frutas.add(new Fruta("Kiwi", R.drawable.kiwi));
        frutas.add(new Fruta("Piña", R.drawable.pina));

        AdaptadorFrutas adapter = new AdaptadorFrutas(this, frutas);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}