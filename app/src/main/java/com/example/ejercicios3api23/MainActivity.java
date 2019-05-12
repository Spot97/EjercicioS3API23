package com.example.ejercicios3api23;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUser,etPass;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUser.getText().toString().equals("enrique")&& etPass.getText().toString().equals("123")){
                    Intent intent = new Intent(
                            MainActivity.this,
                            ProfesoresActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Usuario o Contraseña Incorrecta",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
