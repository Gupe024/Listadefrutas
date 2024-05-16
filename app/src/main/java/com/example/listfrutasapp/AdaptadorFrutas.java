package com.example.listfrutasapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorFrutas extends ArrayAdapter<Fruta> {
    Context contexto;
    ArrayList<Fruta> listaFrutas;

    public AdaptadorFrutas(Context context, ArrayList<Fruta> frutas) {
        super(context, 0, frutas);
        contexto = context;
        listaFrutas = frutas;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        if(vista == null) {
            vista = LayoutInflater.from(contexto).inflate(R.layout.listadefrutas, parent, false);
        }
        Fruta frutaactual = listaFrutas.get(position);

        ImageView imagenFruta = vista.findViewById(R.id.imagenFrutas);
        imagenFruta.setImageResource(frutaactual.getImagen());

        TextView nombreFruta = vista.findViewById(R.id.nombreFruta);
        nombreFruta.setText(frutaactual.getNombre());

        return vista;
    }
}

