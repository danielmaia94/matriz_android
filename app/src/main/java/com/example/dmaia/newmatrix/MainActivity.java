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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long x = System.currentTimeMillis();

        Strassen matrix = new Strassen();

        Debug.startMethodTracing("new_matrix_multiply_ot_256x256");

        matrix.multiply(criaMatriz(256), criaMatriz(256));

        Debug.stopMethodTracing();

        x = System.currentTimeMillis() - x;

        screenText += "\n\nDuracao da aplicacao: ";
        screenText += x;
        screenText += "ms 256 x 256 otimizado";

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
