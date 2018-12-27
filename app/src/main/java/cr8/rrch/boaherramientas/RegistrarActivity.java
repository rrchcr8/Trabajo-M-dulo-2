package cr8.rrch.boaherramientas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {


    private EditText etNombre, etUsuario, etContraseña;
    private Button  BtnListo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        etNombre = (EditText) findViewById(R.id.EditT_nombre);
        etUsuario=(EditText) findViewById(R.id.EditT_usuario);
        etContraseña=(EditText) findViewById(R.id.EditT_password);
        BtnListo=(Button) findViewById(R.id.btn_listo);

        BtnListo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Registrar();

            }

            private void Registrar(){

                SharedPreferences preferences= getSharedPreferences("Credenciales", Context.MODE_PRIVATE);

                String nombre= etNombre.getText().toString();
                String usuario = etUsuario.getText().toString();
                String password = etContraseña.getText().toString();
                if (nombre.equals("") || usuario.equals("")|| password.equals("")){
                    Toast.makeText(getApplicationContext(), "No se pueden dejar campos vacios", Toast.LENGTH_LONG).show();

                } else {

                    SharedPreferences.Editor editor= preferences.edit();
                editor.putString("name",nombre);
                editor.putString("user",usuario);
                editor.putString("pass", password);

                editor.commit();
                Toast.makeText(getApplicationContext(), "Registro realizado exitosamente ", Toast.LENGTH_LONG).show();
                    Intent volvere= new Intent(RegistrarActivity.this,LoginActivity.class);
                    startActivity(volvere);

                }

            }



        });




}

}
