package com.example.listfrutasapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class AdaptadorFrutas extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] nombres;
    private final String[] precios;
    private final String[] descripciones;
    private final Integer[] image;

    public AdaptadorFrutas(@NonNull Activity context, String[] nombres, String[] precios, String[] descripciones, Integer[] image) {
        super(context, R.layout.item, nombres);
        this.context = context;
        this.nombres = nombres;
        this.precios = precios;
        this.descripciones = descripciones;
        this.image = image;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item, parent, false);
        }
        TextView nombre = convertView.findViewById(R.id.nombre);
        TextView precio = convertView.findViewById(R.id.precio);
        TextView descripcion = convertView.findViewById(R.id.descripcion);
        ImageView imagen = convertView.findViewById(R.id.logo);

        nombre.setText(nombres[position]);
        precio.setText(precios[position]);
        descripcion.setText(descripciones[position]);
        imagen.setImageResource(image[position]);

        return convertView;
    }
}



