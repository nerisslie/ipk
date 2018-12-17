package com.example.nerissa.siakad.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nerissa.siakad.R;
import com.example.nerissa.siakad.database.SiakadDb;
import com.example.nerissa.siakad.entity.Mahasiswa;

public class ForgetActivity extends AppCompatActivity {

    private SiakadDb db;
    private Button btn_ganti_password;
    private EditText mNim;
    private EditText mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        db = SiakadDb.getInstance(this);

        btn_ganti_password = (Button) findViewById(R.id.btn_ganti_password);

        btn_ganti_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword();
            }
        });
    }

    private void changePassword(){

        mNim   = (EditText) findViewById(R.id.nim);
        mPass  = (EditText) findViewById(R.id.password);

        String nimStr       = mNim.getText().toString();
        String passwordStr  = mPass.getText().toString();
        String errMsg       = "";

        //check Nim
        Mahasiswa chkMahasiswa  = db.mhsAdd().loadMhsByNim(nimStr);

        Boolean cancel = true;
        View focusView = null;

        if (TextUtils.isEmpty(passwordStr)) {
            errMsg  = "Silahkan masukkan Password";
            cancel  = false;
        }

        if (TextUtils.isEmpty(nimStr)) {
            errMsg  = "Silahkan masukkan Nim";
            cancel = false;
        }

        if(cancel) {
            if (chkMahasiswa == null) {
                errMsg  = "Nim Mahasiswa tidak terdaftar";
                cancel = false;
            }
        }

        if(cancel){
            db.mhsAdd().updateMhsPass(nimStr, passwordStr);
            Toast.makeText(this, "Success Ganti Password", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show();
        }
    }

}
