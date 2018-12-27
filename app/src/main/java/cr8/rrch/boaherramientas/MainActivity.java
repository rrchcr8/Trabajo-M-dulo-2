package cr8.rrch.boaherramientas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<HerramientaVo> listaHerramientas;
    RecyclerView recyclerHerramientas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaHerramientas=new ArrayList<>();
        recyclerHerramientas=(RecyclerView) findViewById(R.id.RecyclerId);
        recyclerHerramientas.setLayoutManager(new LinearLayoutManager(this));

        llenarHerramientas();

    AdaptadorHerramientas adaptador = new AdaptadorHerramientas(listaHerramientas);
    recyclerHerramientas.setAdapter(adaptador);
    }

    private void llenarHerramientas() {
        listaHerramientas.add(new HerramientaVo("Aviation gauge","8844-B", "BOA-H-83090",R.drawable.gauge));
        listaHerramientas.add(new HerramientaVo("Digital Thermometer","62max", "BOA-H-83602",R.drawable.fluke));
    }
}
