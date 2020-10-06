package com.example.frotadeonibus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class OnibusAdapter extends ArrayAdapter<Onibus> {

    int rId;

    public OnibusAdapter(Context context, int resource, List<Onibus> objects) {
        super(context, resource, objects);
        rId = resource;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mView = convertView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId, null);
        }

        Onibus onibus = getItem(position);

        TextView textName = mView.findViewById(R.id.itemNameBus);
        TextView textMarca = mView.findViewById(R.id.itemMarcaBus);
        TextView textModelo = mView.findViewById(R.id.itemModeloBus);
        TextView textOrigDest = mView.findViewById(R.id.itemOrigDestBus);
        TextView textSpin = mView.findViewById(R.id.itemSpinBus);
        TextView textQuantLugar = mView.findViewById(R.id.itemQuantLugarBus);
        TextView textQuantLugarZero = mView.findViewById(R.id.itemQuantLugarZeroBus);

        textName.setText(onibus.getNome());
        textMarca.setText(onibus.getMarca());
        textModelo.setText(onibus.getModelo());
        textOrigDest.setText(onibus.getOrigDest());
        textSpin.setText(onibus.getTipo());
        textQuantLugar.setText("Assentos: "+ String.valueOf(onibus.getQuantLugar()));
        textQuantLugarZero.setText("Assentos Ocupados: "+ onibus.getQuantLugarZero());

        if (onibus.getQuantLugarZero() < onibus.getQuantLugar()){
            textName.setTextColor(getContext().getColor(R.color.assentoBacana));
        }
        else{
            textName.setTextColor(getContext().getColor(R.color.assentoBanana));
        }

        return mView;
    }
}
