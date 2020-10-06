package com.example.frotadeonibus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewOnibus;
    List<Onibus> bus;

    EditText name;
    EditText marca;
    EditText modelo;
    EditText origDest;
    Spinner spinBus;
    EditText quantLugar;
    int quantLugarZero = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewOnibus = findViewById(R.id.listViewBus);
        bus = new ArrayList<>();

        name = findViewById(R.id.nameBus);
        marca = findViewById(R.id.marcaBus);
        modelo = findViewById(R.id.modeloBus);
        origDest = findViewById(R.id.origDestBus);
        spinBus = findViewById(R.id.spinBus);
        quantLugar = findViewById(R.id.quantLugarBus);
        preencherListViewOnibus();
        listViewOnibus.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Onibus onibus = (Onibus) adapterView.getItemAtPosition(i);

                if (onibus.getQuantLugarZero() < onibus.getQuantLugar()){
                    ocuparAssento(onibus);
                    Toast.makeText(MainActivity.this, "Assento Reservado", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Ônibus Lotado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    protected void onStart(){
        super.onStart();
    }

    public void ocuparAssento(Onibus onibus){
        onibus.setQuantLugarZero(onibus.getQuantLugarZero() + 1);
        preencherListViewOnibus();

    }

    public void addBus(View view){
        Onibus onibus = new Onibus();

        onibus.setNome("Nome: "+name.getText().toString());
        onibus.setMarca("Marca: "+marca.getText().toString());
        onibus.setModelo("Modelo: "+modelo.getText().toString());
        onibus.setOrigDest("Origem/Destino: "+origDest.getText().toString());
        onibus.setTipo("Tipo: "+spinBus.getSelectedItem().toString());
        onibus.setQuantLugar(Integer.parseInt(quantLugar.getText().toString()));
        onibus.setQuantLugarZero(quantLugarZero);

        bus.add(onibus);
        preencherListViewOnibus();


        name.setText("");
        marca.setText("");
        modelo.setText("");
        origDest.setText("");
        quantLugar.setText("");



    }

    private void preencherListViewOnibus(){
        int layout_id = R.layout.onibus_list_item;
        OnibusAdapter adapter = new OnibusAdapter(this, layout_id, bus);

        listViewOnibus.setAdapter(adapter);
    }


}