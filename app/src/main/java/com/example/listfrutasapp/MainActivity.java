package com.example.listfrutasapp;

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
        String[] nombres = {"Manzana", "Naranja", "Platano", "Kiwi", "Piña", "Sandía", "Uvas"};
        String[] precios = {"20", "30", "15", "25", "35", "15", "26"};
        String[] descripciones = {
                "Manzana deliciosa y jugosa.",
                "Naranja rica en vitamina C.",
                "Platano nutritivo y energético.",
                "Kiwi exótico y refrescante.",
                "Piña dulce y tropical.",
                "Sandía refrescante y sabrosa.",
                "Uvas pequeñas y dulces."
        };
        Integer[] image = {R.drawable.manzana, R.drawable.naranja, R.drawable.platano, R.drawable.kiwi, R.drawable.pina, R.drawable.sandia, R.drawable.uvas};

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
