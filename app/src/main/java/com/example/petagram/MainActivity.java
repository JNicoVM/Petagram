package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
