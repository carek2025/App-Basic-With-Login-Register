package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterPage extends AppCompatActivity {
    private EditText name,lastname,tel,email,password;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        name=findViewById(R.id.name);
        lastname=findViewById(R.id.lastname);
        tel=findViewById(R.id.tel);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
    }
    public void register(View v){
        DatosUsuario.name_u= name.getText().toString().trim();
        DatosUsuario.last_u= lastname.getText().toString().trim();
        DatosUsuario.tel_u= tel.getText().toString().trim();
        DatosUsuario.email_u= email.getText().toString().trim();
        DatosUsuario.pass_u= password.getText().toString().trim();

        Boolean fieldValid= true;

        if(DatosUsuario.tel_u.isEmpty()){
            tel.setError("¡¡FALTO RELLENAR TELEPHONE!!");
            fieldValid=false ;
        }
        if(DatosUsuario.email_u.isEmpty()){
            tel.setError("¡¡FALTO RELLENAR EMAIL!!");
            fieldValid=false;
        }
        if(DatosUsuario.name_u.isEmpty()){
            tel.setError("¡¡FALTO RELLENAR NAME!!");
            fieldValid=false;
        }
        if(DatosUsuario.last_u.isEmpty()){
            tel.setError("¡¡FALTO RELLENAR LASTNAME!!");
            fieldValid=false;
        }
        if(DatosUsuario.pass_u.isEmpty()){
            tel.setError("¡¡FALTO RELLENAR PASSWORD!!");
            fieldValid=false;
        }
        if (fieldValid==true){

            Toast.makeText(this,"Registro Exitoso",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this,InitialPage.class);
            startActivity(intent);
            finish();
        }


    }
}