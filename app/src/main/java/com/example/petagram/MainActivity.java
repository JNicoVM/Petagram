package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //declarar variables globales
    SwipeRefreshLayout myRefresh;
    ListView myList;
    //sirve de auxiliar para manejar los datos del string en el ListView
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Toast.makeText(this,
                getResources().getString(R.string.onCreate),
                Toast.LENGTH_SHORT).show();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //No es necesario instanciar, el objeto ya exite
        myRefresh=findViewById(R.id.MyRefresh);//nuevo objeto
        myList=findViewById(R.id.MyList);


        //Se declara arreglo de strings
        String[] planetas=getResources().getStringArray(R.array.planetas);
        //Muestra la lista de planeta
        myList.setAdapter(new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,planetas));
        myRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Muestra animación
                refrescandoContenido();
            }
        });


    }

    public void refrescandoContenido(){
        //volver a cargar la lista
        String[] planetas=getResources().getStringArray(R.array.planetas);
        //Muestra la lista de planeta
        myList.setAdapter(new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,planetas));
        myRefresh.setRefreshing(false);
    }

    public void fabClick(View view) {
        Snackbar.make(view,getResources().getString(R.string.mensaje),Snackbar.LENGTH_SHORT)
                .setAction(getResources().getString(R.string.accion), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("El gato es: ","Malvado");
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .show();
    }

    // Se sobreescriben los métodos
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,
                getResources().getString(R.string.onStart),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,
                getResources().getString(R.string.onResume),
                Toast.LENGTH_SHORT).show();
    }

    //Actividad Corriendo

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,
                getResources().getString(R.string.onRestart),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,
                getResources().getString(R.string.onPause),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,
                getResources().getString(R.string.onStop),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,
                getResources().getString(R.string.onDestroy),
                Toast.LENGTH_SHORT).show();
    }
}
