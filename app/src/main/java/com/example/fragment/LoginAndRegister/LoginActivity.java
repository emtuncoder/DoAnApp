package com.example.fragment.LoginAndRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.fragment.MainActivity;
import com.example.fragment.R;
import com.example.fragment.database.DataBaseHelper;

public class LoginActivity extends AppCompatActivity {
    EditText edtUser,edtPass;
    Button btnLogin,btnRegister;
    String username,password;
    DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDb.registerUser(edtUser.getText().toString() , edtPass.getText().toString());
                if (var){
                    Toast.makeText(LoginActivity.this, "Dang Nhap Thanh Cong !!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this , MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Dang Nhap Khong Thanh Cong !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent1);
            }
        });
    }

    private void addControls() {
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        myDb = new DataBaseHelper(this);
    }
}