package com.example.examen_m3uf6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EvAdapter extends ArrayAdapter<Evento> {

    public EvAdapter(Context context, ArrayList<Evento> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Evento evento = getItem(position);

        if (convertView ==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ev_item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.ev_item_nombre);
        TextView place = (TextView) convertView.findViewById(R.id.ev_item_sitio);
        TextView price = (TextView) convertView.findViewById(R.id.ev_item_precio);

        name.setText(evento.getTitle());
        place.setText(evento.getPlace());
        price.setText(evento.getPrice());

        return convertView;
    }
}
