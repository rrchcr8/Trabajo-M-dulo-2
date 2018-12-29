package cr8.rrch.boaherramientas;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.textclassifier.TextLinks;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {


    RecyclerView recyclerHerramientas;
    ArrayList<HerramientaVo> listaHerramientas;
    ProgressDialog progress;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;


  /*  ArrayList<HerramientaVo> listaHerramientas;
    RecyclerView recyclerHerramientas;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaHerramientas=new ArrayList<>();
        recyclerHerramientas=(RecyclerView) findViewById(R.id.RecyclerId);
        recyclerHerramientas.setLayoutManager(new LinearLayoutManager(this));

        request= Volley.newRequestQueue(MainActivity.this);

        CargarWebServices();


    /*    listaHerramientas=new ArrayList<>();
        recyclerHerramientas=(RecyclerView) findViewById(R.id.RecyclerId);
        recyclerHerramientas.setLayoutManager(new LinearLayoutManager(this));

        llenarHerramientas();

    AdaptadorHerramientas adaptador = new AdaptadorHerramientas(listaHerramientas);
    recyclerHerramientas.setAdapter(adaptador);

    */
    }

    private void CargarWebServices() {
        progress= new ProgressDialog(MainActivity.this);
        progress.setMessage("consultando....");
        progress.show();

        String url="http://192.168.0.18/WebServicesCarlos/wsJSONConsultarLista.php";

        jsonObjectRequest= new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonObjectRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(MainActivity.this,"No se puede conectar"+error.toString(),Toast.LENGTH_LONG).show();
        progress.hide();
        Log.i("ERROR",error.toString());

    }

    @Override
    public void onResponse(JSONObject response) {

        //Toast.makeText(MainActivity.this,"hasta aqui entra",Toast.LENGTH_LONG).show();

        HerramientaVo herramientaVo=null;
        JSONArray json = response.optJSONArray("principal");
        try {
        for(int i=0;i<json.length();i++){
            herramientaVo=new HerramientaVo();
            JSONObject jsonObject=null;
            jsonObject=json.getJSONObject(i);

            herramientaVo.setCodigoBoa(jsonObject.optString("codigo_boa"));
            herramientaVo.setNombre(jsonObject.optString("nombre"));
            herramientaVo.setPN(jsonObject.optString("pn"));
            listaHerramientas.add(herramientaVo);

                    }
        progress.hide();
        AdaptadorHerramientas adapter =new AdaptadorHerramientas(listaHerramientas);
        recyclerHerramientas.setAdapter(adapter);
        }


        catch (JSONException e) {
                e.printStackTrace();

        progress.hide();
        }

    }

    /*private void llenarHerramientas() {
        listaHerramientas.add(new HerramientaVo("Aviation gauge","8844-B", "BOA-H-83090",R.drawable.gauge));
        listaHerramientas.add(new HerramientaVo("Digital Thermometer","62max", "BOA-H-83602",R.drawable.fluke));
    }

    */
}
