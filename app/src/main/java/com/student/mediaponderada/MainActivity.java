package com.student.mediaponderada;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.textfield.TextInputLayout;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context myContext;
    private TextView resultado;
    private ArrayList<LinearLayout> campos;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        setContentView(R.layout.activity_main);
        resultado = findViewById(R.id.resultado);
        myContext = findViewById(R.id.mainLayout).getContext();
        campos = new ArrayList<>();
        addComponent(null);
        addComponent(null);
    }

    public void addComponent(View v) {
        LinearLayout camposLayout = findViewById(R.id.campos);
            LayoutInflater vi = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout layout;
            layout = (LinearLayout) vi.inflate(R.layout.layout_campos, null);
            campos.add(layout);
            updateComponent();
            camposLayout.addView(layout);
    }

    public void updateComponent() {
        for (int i = 0; i < campos.size(); i++) {
            LinearLayout v = campos.get(i);
            TextInputLayout input = (TextInputLayout) v.getChildAt(0);
            input.setHint("Número " + (i+1));

            input = (TextInputLayout) v.getChildAt(1);
            input.setHint("Peso " + (i+1));
        }
    }

    public void calcular(View v) {
        BigDecimal total = Controler.calcular(campos);
        resultado.setText("Resultado: " + total.toString());
    }

    public void removerComponente(View v) {
        campos.remove((LinearLayout) v.getParent());
        ViewGroup group = ((ViewGroup) v.getParent());
        ((ViewGroup) group.getParent()).removeView(group);
        updateComponent();
    }

}