package com.example.lab12_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CLIENTES extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ListView clientes;
    Button agregar, eliminar;
    List<String> lista2 = new ArrayList<String>();
    EditText edit_agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        clientes = findViewById(R.id.clients);
        agregar = findViewById(R.id.agregar);
        eliminar = findViewById(R.id.eliminar);
        edit_agregar = findViewById(R.id.text_agregar);

        lista2.add("Roberto Aguilar");
        lista2.add("Mariana Guillen");
        lista2.add("Rubi Rodriguez");
        lista2.add("Mary Jimenez");

        ArrayAdapter<String> adapter_clientes = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,lista2);
        clientes.setAdapter(adapter_clientes);
    }

    public void eliminar_cliente(View view) {
        int indice2 = clientes.getSelectedItemPosition();
        lista2.remove(indice2);
    }

    public void agregar_clientes(View view) {
        String cliente_nuevo =edit_agregar.getText().toString();
        lista2.add(cliente_nuevo);
    }

    public void regresar(View view) {
        Intent volver = new Intent(this,MainActivity.class);
        startActivity(volver);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Intent enviar = new Intent(CLIENTES.this, MainActivity.class);
        enviar.putExtra("cliente_seleccionado",
                clientes.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
