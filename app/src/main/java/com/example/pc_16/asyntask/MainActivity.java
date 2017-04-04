package com.example.pc_16.asyntask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar cargador;
    TextView Texto;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargador = (ProgressBar) findViewById(R.id.cargador);
        Texto = (TextView) findViewById(R.id.Texto);
        boton = (Button) findViewById(R.id.boton);
    }


//se programa el onclick
    public void onButtonStart (){
        new MyTask().execute(60);//cuando se da click al boton se ejecuta la tarea en segundo plano
    }

    public class MyTask extends AsyncTask<Integer, Integer, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            cargador.setVisibility(View.VISIBLE);
        }
        //cual es el metodo  mas importante de una tarea es doinbackground

        @Override
        protected String doInBackground(Integer... params) {
            int max = params [0];
            for (int i=0; i<=max; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //vincular metodo progrerpublis, recible el parable del for i
                publishProgress(i);
            }
            return "Fin";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //aca va a cambiar el texto que hay en la vista

            int contador = values[0];
            String cadena = "contador: " + contador;
            Texto.setText(cadena);
            Texto.setTextSize(contador);
        }

        @Override
        protected void onPostExecute(String s) {

            super.onPostExecute(s);
            cargador.setVisibility(View.INVISIBLE);
        }
    }

}
