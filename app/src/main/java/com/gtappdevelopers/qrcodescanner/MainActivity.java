package com.gtappdevelopers.qrcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button generateQrBtn, scanQRBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateQrBtn = findViewById(R.id.idBtnGenerateCode);
        scanQRBtn = findViewById(R.id.idBtnScanCode);
        generateQrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, QRCodeGenerator.class);
                startActivity(i);
            }
        });
        scanQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, QRCodeScanner.class);
                startActivity(i);
            }
        });
    }
}