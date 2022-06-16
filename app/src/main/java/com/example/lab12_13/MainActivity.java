package com.example.lab12_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner productos;
    EditText precio, cantidad;
    TextView subtotal, igv, total;
    MaterialButton salto_clientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productos = findViewById(R.id.products);
        precio = findViewById(R.id.precio);
        subtotal = findViewById(R.id.subtotal);
        cantidad = findViewById(R.id.cantidad);
        igv = findViewById(R.id.igv);
        total = findViewById(R.id.total);
        productos.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adaptador =
                ArrayAdapter.createFromResource(this,R.array.PRODUCTOS,
                        android.R.layout.simple_list_item_1);
        productos.setAdapter(adaptador);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    public void Clientes(View view) {
        Intent Clientes = new Intent(this,CLIENTES.class);
        startActivity(Clientes);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int indice = productos.getSelectedItemPosition();
        double price = 0;
        if (indice == 0) {
            price = 3.80;
        }
        if (indice == 1) {
            price = 0.4;
        }
        if (indice == 2) {
            price = 0.3;
        }
        if (indice == 3) {
            price = 3.5;
        }
        double cant2 = Double.parseDouble(cantidad.getText().toString());
        precio.setText(String.valueOf(price));
        precio.setEnabled(false);
        double subtotal_sub = cant2*price ;
        cantidad.setText(String.valueOf(subtotal_sub));
        double igv_sub = subtotal_sub*0.10;
        igv.setText(String.valueOf(igv_sub));
        double tot = subtotal_sub+igv_sub;
        total.setText(String.valueOf(tot));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


