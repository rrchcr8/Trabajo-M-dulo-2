package cr8.rrch.boaherramientas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn1=(Button)findViewById(R.id.btn_registrar_tool);
        btn2=(Button)findViewById(R.id.btn_listado);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View caquita) {
        if (caquita.getId() == btn1.getId()) {
            Intent intento= new Intent(this,RegistroToolActivity.class);
            startActivity(intento);
        }

        else if (caquita.getId() == btn2.getId()) {
            Intent intento= new Intent(this,MainActivity.class);
            startActivity(intento);
        }
    }
}
