package com.gsmmoz.maguandza.maguandza.online;

import androidx.appcompat.app.AppCompatActivity;

public class Decrypt {

    public String tapy_3(int[] arrayImei) {

        String code3 = "";

        for (int i = 0; i < 7; i++) {
            code3 += (arrayImei[i * 2] + arrayImei[i * 2 + 1]) % 10;
            if (i == 6) {
                code3 += arrayImei[0];
            }
        }
        return code3;
    }

    public String decryptKicka (int[] arrayImei1){
        String codeKicka = "";
        for (int i = 0; i < 8; i++) {
            codeKicka += (arrayImei1[i] + arrayImei1[i + 1] + arrayImei1[i + 2] + arrayImei1[i + 3] + arrayImei1[i + 4] + arrayImei1[i + 5] + arrayImei1[i + 6] + arrayImei1[i + 7]) % 10;
            }
        return codeKicka;
        }
    }
