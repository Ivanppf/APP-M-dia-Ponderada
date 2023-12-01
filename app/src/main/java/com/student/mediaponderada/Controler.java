package com.student.mediaponderada;

import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Controler {

    public static BigDecimal calcular(ArrayList<LinearLayout> campos) {
        BigDecimal total = new BigDecimal(0);
        BigDecimal somaPesos = new BigDecimal(0);
        try {
            for (LinearLayout l: campos) {
                TextInputLayout numero = (TextInputLayout) l.getChildAt(0);
                TextInputLayout peso = (TextInputLayout) l.getChildAt(1);
                String valorNumero = String.valueOf(numero.getEditText().getText());
                String valorPeso = String.valueOf(peso.getEditText().getText());

                total = total.add(new BigDecimal(valorNumero).multiply(new BigDecimal(valorPeso)));

                somaPesos = somaPesos.add(new BigDecimal(valorPeso));
            }
            total = total.divide(somaPesos, 2, RoundingMode.CEILING);
            return total;
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }
}
