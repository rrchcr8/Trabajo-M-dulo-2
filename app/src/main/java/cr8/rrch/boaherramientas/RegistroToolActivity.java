package cr8.rrch.boaherramientas;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class RegistroToolActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {
    EditText et1, et2,et3, et4;
    Button bt1;
    ProgressDialog progreso;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tool);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et1=(EditText) findViewById(R.id.CampoCodigoBoA);
        et2=(EditText) findViewById(R.id.CampoNombre);
        et3=(EditText) findViewById(R.id.CampoPN);
        et4=(EditText) findViewById(R.id.CampoSN);

         bt1=(Button)findViewById(R.id.BtnRegistroTool);

         request=Volley.newRequestQueue(RegistroToolActivity.this);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             cargarWebService();
            }
        });

    }

    private void cargarWebService() {

        progreso= new ProgressDialog(RegistroToolActivity.this);
        progreso.setMessage("cargando...");
        progreso.show();

        String url="http://192.168.0.18/WebServicesCarlos/wsJSONRegistro.php?codigo_boa="+et1.getText().toString()+
           "&nombre="+et2.getText().toString()+
           "&pn="+et3.getText().toString()+"&sn="+et4.getText().toString();

   url=url.replace(" ","%20");

   jsonObjectRequest= new JsonObjectRequest(Request.Method.GET,url,null,this,this);
    request.add(jsonObjectRequest);



    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(RegistroToolActivity.this,"No se pudo conectar"+error.toString(),Toast.LENGTH_SHORT).show();
        progreso.hide();
        Log.i("ERROR",error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {

        Toast.makeText(RegistroToolActivity.this,"se ha registrado exitosamente",Toast.LENGTH_SHORT).show();
        progreso.hide();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
    }
}
