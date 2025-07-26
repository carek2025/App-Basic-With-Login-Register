package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText email,password;

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
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
    }
    public void login(View v){
        String email_log= email.getText().toString().trim();
        String pass_log= password.getText().toString().trim();

        if(email_log.equals(DatosUsuario.email) && pass_log.equals(DatosUsuario.password)){
            Toast.makeText(this,"Inicio de Sesion Exitoso",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,InitialPage.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this,"Credenciales Incorectas",Toast.LENGTH_SHORT).show();
            email.setText("");
            password.setText("");
        }
    }
}