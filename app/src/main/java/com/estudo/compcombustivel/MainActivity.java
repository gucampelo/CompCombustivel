package com.estudo.compcombustivel;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inGasol;
    private EditText inEtanol;
    private TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inGasol = findViewById(R.id.inGasol);
        inGasol.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        inEtanol = findViewById(R.id.inEtanol);
        inEtanol.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        txtRes = findViewById(R.id.txtRes);

        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calc());

    }

    private void calc(){
        float vGasolina = Float.parseFloat(inGasol.getText().toString());
        float vEtanol = Float.parseFloat(inEtanol.getText().toString());

        double limiteEtanol = vGasolina * 0.7;

        if (vEtanol <= limiteEtanol) {
            String res = "O etanol é mais vantajoso";
            txtRes.setText(res);
        } else {
            String res = "A gasolina é mais vantajosa";
            txtRes.setText(res);
        }


    }
}