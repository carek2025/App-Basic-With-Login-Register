package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText email,password;
    private Button login,register;
    private TextView output;
    String email_u= "",pass_u= "";

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
        output=findViewById(R.id.output);
    }
    public void login(View v){
        String email_log= email.getText().toString().trim();
        String pass_log= password.getText().toString().trim();

        if(email_log.equals(email_u) && pass_log.equals(pass_u)){
            output.setText("¡¡¡¡¡¡INICIO DE SESION EXITOSO!!!!!!");
            email.setText("");
            password.setText("");
        }else{
            output.setText("¡¡¡¡¡¡CREDENCIALES INCORRECTAS!!!!!!");
        }
    }
    public void register(View v){
         email_u= email.getText().toString().trim();
         pass_u= password.getText().toString().trim();

        if ((!email_u.isEmpty()) && (!pass_u.isEmpty())){
            output.setText("¡¡¡¡¡¡REGISTRADO CON EXITO!!!!!!");
            email.setText("");
            password.setText("");
        } else if(!email_u.isEmpty()){
            pass_u= "";
            output.setText("!!!--REGISTRO INCORRECTO--¡¡¡\n-----FALTA LA CONTRASEÑA-----");
        }else if(!pass_u.isEmpty()){
            email_u= "";
            output.setText("!!!--REGISTRO INCORRECTO--¡¡¡\n-----FALTA EL EMAIL-----");
        }
    }


}