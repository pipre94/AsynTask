package com.example.pc_16.asyntask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//se programa el onclick
    public void onButtonStart (){
        new MyTask().execute();//cuando se da click al boton se ejecuta la tarea en segundo plano
    }

    public class MyTask extends AsyncTask<Integer, Integer, Integer>{
        @Override
        protected Integer doInBackground(Integer... params) {
            return null;
        }
    }

}
