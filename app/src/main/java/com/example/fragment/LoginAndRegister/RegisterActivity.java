package com.example.fragment.LoginAndRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragment.R;
import com.example.fragment.database.CeateDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText edtRegisUser,edtRegisPass,edtRePass;
    Button btnReLogin,btnRegisRegister;
    CeateDatabase myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addControls();
        addEvents();

    }

    private void addEvents() {
        btnRegisRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ReMK = edtRePass.getText().toString().trim();
                if(edtRegisPass.getText().toString().equals(ReMK)){
                    boolean var = myDB.insertUser(edtRegisUser.getText().toString().trim() , edtRegisPass.getText().toString().trim());
                    if(var){
                        Toast.makeText(RegisterActivity.this, "Dang Ky Thanh Cong !!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(RegisterActivity.this, "Dang Ki Khong Thanh Cong !!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterActivity.this,"Hay Thu Lai !",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addControls() {
        edtRegisUser = findViewById(R.id.edtRegisUser);
        edtRegisPass = findViewById(R.id.edtRegisPass);
        edtRePass = findViewById(R.id.edtRePass);
        btnReLogin = findViewById(R.id.btnReLogin);
        btnRegisRegister = findViewById(R.id.btnRegisRegister);
        myDB = new CeateDatabase(this);
    }
}