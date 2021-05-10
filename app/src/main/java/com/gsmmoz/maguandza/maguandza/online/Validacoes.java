package com.gsmmoz.maguandza.maguandza.online;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Validacoes {

    /*EditText imeiNumber;
    TextView codeField;
    public HomeActivity activity;

    public Validacoes(){}

    public Validacoes(HomeActivity activity){
        this.activity = activity;
        activity.imeiNumber = (EditText) this.activity.findViewById(R.id.imeiNumber);
        activity.codeField = (TextView) this.activity.findViewById(R.id.codeField);
    }
    public void getImeiNumber() {

        String a = " ";
        String imei = imeiNumber.getText().toString();
        if (imei.length() < 15){
            activity.imeiNumber.setError("Imei Invalido");
        }else {
            activity.codeField.setText(imei);
        }
    }


*/
    public  int[] converterImeiNumber(String imei) {
       int um[] = new int[15];
        for(int i = 0; i < imei.length(); i++){
            um[i] = Character.digit(imei.charAt(i), 10);
        }

        return um;
    }
}
