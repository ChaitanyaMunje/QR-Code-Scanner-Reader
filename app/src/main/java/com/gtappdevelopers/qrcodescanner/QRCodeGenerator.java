package com.gtappdevelopers.qrcodescanner;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QRCodeGenerator extends AppCompatActivity {

    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    private TextInputEditText dataEdt;
    private Button generateBtn;
    private ImageView qrCodeIV;
    private TextView qrCodeGeneratorTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_generator);
        generateBtn = findViewById(R.id.idBtnGenerateCode);
        dataEdt = findViewById(R.id.idEdtData);
        qrCodeIV = findViewById(R.id.idIVQrcode);
        qrCodeGeneratorTV = findViewById(R.id.idTVGeneratedCode);
        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = dataEdt.getText().toString();
                WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);

                // initializing a variable for default display.
                Display display = manager.getDefaultDisplay();

                // creating a variable for point which
                // is to be displayed in QR Code.
                Point point = new Point();
                display.getSize(point);

                // getting width and
                // height of a point
                int width = point.x;
                int height = point.y;

                // generating dimension from width and height.
                int dimen = width < height ? width : height;
                dimen = dimen * 3 / 4;

                // setting this dimensions inside our qr code
                // encoder to generate our qr code.
                qrgEncoder = new QRGEncoder(dataEdt.getText().toString(), null, QRGContents.Type.TEXT, dimen);
                try {
                    // getting our qrcode in the form of bitmap.
                    bitmap = qrgEncoder.encodeAsBitmap();
                    // the bitmap is set inside our image
                    // view using .setimagebitmap method.
                    qrCodeGeneratorTV.setVisibility(View.GONE);
                    qrCodeIV.setImageBitmap(bitmap);

                } catch (WriterException e) {

                    Log.e("Tag", e.toString());
                }
            }
        });

    }
}