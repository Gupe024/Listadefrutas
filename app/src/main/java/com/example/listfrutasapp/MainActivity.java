package com.example.listfrutasapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private TextView totalTextView;
    private double total = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listView);
        totalTextView = findViewById(R.id.total);

        String[] nombres = getResources().getStringArray(R.array.nombre_frutas);
        String[] precios = getResources().getStringArray(R.array.precios_frutas);
        String[] descripciones = getResources().getStringArray(R.array.descripción_frutas);

        TypedArray images = getResources().obtainTypedArray(R.array.imagenes_frutas);
        Integer[] image = new Integer[images.length()];
        for (int i = 0; i < images.length(); i++) {
            image[i] = images.getResourceId(i, -1);
        }
        images.recycle();

        AdaptadorFrutas adapter = new AdaptadorFrutas(this, nombres, precios, descripciones, image);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double price = Double.parseDouble(precios[position]);
                total += price;
                updateTotal();
                Toast.makeText(getApplicationContext(), "Seleccionaste: " + nombres[position], Toast.LENGTH_LONG).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                double price = Double.parseDouble(precios[position]);
                total -= price;
                updateTotal();
                Toast.makeText(getApplicationContext(), nombres[position] + " con precio de :$" + precios[position], Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    private void updateTotal() {
        totalTextView.setText(String.format("Total: $%.2f", total));
    }
}

