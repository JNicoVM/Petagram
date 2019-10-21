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
}
