package com.example.nerissa.siakad.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nerissa.siakad.R;
import com.example.nerissa.siakad.entity.Mahasiswa;

public class IpkActivity extends AppCompatActivity {

    private Button predict_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ipk_menu);


        predict_button = (Button) findViewById(R.id.predict_button);

        predict_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                predict();
            }
        });
    }

    private void predict(){

        Boolean cancel = true;
        View focusView = null;

        if(cancel){
            Intent intent = new Intent(this, PredictActivity.class);
            startActivity(intent);
        }
    }
}
