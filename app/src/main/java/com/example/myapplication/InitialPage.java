package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InitialPage extends AppCompatActivity {
    private EditText name,lastname,tel,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_initial_page);
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

        name.setText(DatosUsuario.name);
        lastname.setText(DatosUsuario.lastname);
        tel.setText(DatosUsuario.tel);
        email.setText(DatosUsuario.email);
        password.setText(DatosUsuario.password);
    }
    public void ChangeData(View v){
        String name_u= name.getText().toString().trim();
        String lastname_u= lastname.getText().toString().trim();
        String tel_u= tel.getText().toString().trim();
        String email_u= email.getText().toString().trim();
        String password_u= password.getText().toString().trim();

        boolean fieldValid= true;

        if(tel_u.isEmpty()){
            tel.setError("Campo de telefono vacio");
            fieldValid=false ;
        }
        if(email_u.isEmpty()){
            email.setError("Campo de email vacio");
            fieldValid=false;
        }
        if(name_u.isEmpty()){
            name.setError("Campo de nombre vacio");
            fieldValid=false;
        }
        if(lastname_u.isEmpty()){
            lastname.setError("Campo de apellido vacio");
            fieldValid=false;
        }
        if(password_u.isEmpty()){
            password.setError("Campo de contraseña vacio");
            fieldValid=false;
        }
        if (fieldValid){
            DatosUsuario.name= name_u;
            DatosUsuario.lastname= lastname_u;
            DatosUsuario.tel= tel_u;
            DatosUsuario.email= email_u;
            DatosUsuario.password= password_u;
            Toast.makeText(this,"Modificacion de Datos Exitoso",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }
}