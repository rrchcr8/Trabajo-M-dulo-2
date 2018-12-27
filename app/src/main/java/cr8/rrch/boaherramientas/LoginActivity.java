package cr8.rrch.boaherramientas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsuario, etContraseña;
    private Button BtnIngresar, BtnRegistrar;
    String con="";
    String usu="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsuario=(EditText) findViewById(R.id.et_usuario);
        etContraseña=(EditText) findViewById(R.id.et_contraseña);
        BtnIngresar=(Button) findViewById(R.id.btn_ingresar);
        BtnRegistrar=(Button) findViewById(R.id.btn_registrar);




        //


       BtnIngresar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               usu=etUsuario.getText().toString();
               con=etContraseña.getText().toString();

               if (usu.equals("") || con.equals("")) {
                   Toast.makeText(getApplicationContext(), "No pueden existir campos vacios", Toast.LENGTH_LONG).show();
               } else   {


                       SharedPreferences preferences= getSharedPreferences("Credenciales", Context.MODE_PRIVATE);

                       String Nombre = preferences.getString("name","");
                       String Usuario = preferences.getString("user","");
                       String Contraseña = preferences.getString("pass","");

                       //Toast.makeText(getApplicationContext(), "hola "+Contraseña, Toast.LENGTH_LONG).show();


                       if (Contraseña.equals(con) && usu.equals(Usuario)) {
                           Intent intentmain= new Intent(LoginActivity.this,MainActivity.class);
                           startActivity(intentmain);
                       } else{
                           Toast.makeText(getApplicationContext(), "Usuario y/o contraseña equivocados", Toast.LENGTH_LONG).show();
                       }
                   }

               }






       });



        BtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registrar2();
           }


            private void Registrar2() {
                Intent intentReg= new Intent(LoginActivity.this,RegistrarActivity.class);
                startActivity(intentReg);
            }


        });



    }





}
