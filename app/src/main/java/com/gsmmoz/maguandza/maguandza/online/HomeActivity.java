package com.gsmmoz.maguandza.maguandza.online;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    EditText imeiNumber;
    TextView codeField;
    TextView imeiCount;

    Button btnGenerate;
    Button btnKicka;
    Button btnMobicel;

    String imeiCell;
    int arrayImei[];
    Decrypt decrypt;
    Validacoes validacoes;
    //private ConstraintLayout layoutHome ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        validacoes = new Validacoes();
        decrypt = new Decrypt();

        btnGenerate = findViewById(R.id.btnGenerate);
        btnKicka = findViewById(R.id.btnKicka);
        btnMobicel = findViewById(R.id.btnMobicel);

        imeiNumber = findViewById(R.id.imeiNumber);
        imeiNumber = (EditText) findViewById(R.id.imeiNumber);
        codeField = findViewById(R.id.codeField);
        imeiCount = findViewById(R.id.imeiCount);

        //layoutHome = (ConstraintLayout) findViewById(R.id.layoutHome);
        imeiNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = imeiNumber.getText().toString();
                int symbols = text.length();
                imeiCount.setText(symbols + "/15");
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /*/*******************************************************************************************
                            LER O IMEI DO CELL E VALIDAR
    **********************************************************************************************/

    private String getImeiNumber() {

        String a = " ";
        String imei = imeiNumber.getText().toString();
        if (imei.length() < 15){
            imeiNumber.setError("Imei Invalido");
        }else {
            a = imei;
        }
        return a;
    }
    /***********************************************************************************************
    *                        AO CLICAR NO BOTAO GENERETE TERA O RETORNO DE TAPY 3
    * **********************************************************************************************/
    public void btnGenerate(View view){
        btnGenerate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                codeField.clearComposingText();

                int imeiCell[] = validacoes.converterImeiNumber(getImeiNumber());
                String imeiCell2 = decrypt.tapy_3(imeiCell);

                codeField.setText(imeiCell2);

            }
        });
    }
    /***********************************************************************************************
     *                        AO CLICAR NO BOTAO GENERETE TERA O RETORNO DE TAPY 3
     * **********************************************************************************************/
    public void btnKicka(View view){
        btnKicka.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                codeField.clearComposingText();

                int imeiCell[] = validacoes.converterImeiNumber(getImeiNumber());
                String imeiCell2 = decrypt.decryptKicka(imeiCell);

                codeField.setText(imeiCell2);

            }
        });
    }
    /***********************************************************************************************
     *                        AO CLICAR NO BOTAO MOBICEL TERA O RETORNO DE TAPY 2
     * **********************************************************************************************/
    public void btnMobicel(View view){
      /*  btnMobicel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                codeField.clearComposingText();

                int imeiCell[] = validacoes.converterImeiNumber(getImeiNumber());
                String imeiCell2 = decrypt.tapy_3(imeiCell);

                codeField.setText(imeiCell2);

            }
        });*/
    }
    /***********************************************************************************************
     *                        AO CLICAR NO BOTAO GENERETE TERA O RETORNO DE TAPY 3
     * **********************************************************************************************/
    public void btnMovitel(View view){
      /*  btnMobicel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                codeField.clearComposingText();

                int imeiCell[] = validacoes.converterImeiNumber(getImeiNumber());
                String imeiCell2 = decrypt.tapy_3(imeiCell);

                codeField.setText(imeiCell2);

            }
        });*/
    }
    /***********************************************************************************************
     *                        AO CLICAR NOS BOTOES SERA REDICIONANADO PARA REDES SOCIAIS
     *
     * **********************************************************************************************/
    public void btnInformation(View view){
      /*  btnMobicel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                codeField.clearComposingText();

                int imeiCell[] = validacoes.converterImeiNumber(getImeiNumber());
                String imeiCell2 = decrypt.tapy_3(imeiCell);

                codeField.setText(imeiCell2);

            }
        });*/
    }
    public void facebook(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/groups/1030517087444723"));
        startActivity(browserIntent);

    }
    public void whatsapp(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/LPjfAo08kIW1ZFIC4Jb5Gy"));
        startActivity(browserIntent);


    }
    public void telegram(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/joinchat/FaTZY1MoHcx8srWS"));
        startActivity(browserIntent);


    }
    public void youtube(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UC-2r2fo9jpArtG078Gg6AwA"));
        startActivity(browserIntent);
    }


}