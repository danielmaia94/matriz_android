package com.example.dmaia.newmatrix;

import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String screenText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long x = System.currentTimeMillis();

        MatrixMultiply matrix = new MatrixMultiply(criaMatriz(64), criaMatriz(64));

        Debug.startMethodTracing("matrix_multiply_no_64x64");

        matrix.multiply();

        Debug.stopMethodTracing();

        x = System.currentTimeMillis() - x;

        screenText += "\n\nDuracao da aplicacao: ";
        screenText += x;
        screenText += "ms 64 x 64 nao otimizado";

        TextView editText = findViewById(R.id.conteudo);
        editText.setText(screenText);
    }

    public int[][] criaMatriz(int length)
    {
        int i, j;
        int array[][] = new int[length][length];

        for(i=0; i < length; i++) {
            for(j = 0; j < length; j++) {
                array[i][j] = (int) Math.random();
            }
        }

        return array;
    }

    public void imprimeResultado(MatrixMultiply matrix)
    {
        int resultado[][] = matrix.getResult();

        int x = resultado.length;
        int y = x;

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
//                Log.d("a", "teste");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
