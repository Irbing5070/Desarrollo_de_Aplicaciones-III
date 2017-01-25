package com.desarrollodeaplicaciones.ejercicio2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {
    //Establecer la duracion de la pantalla de inicio
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Explicar aplicar orientacion de la imagen
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Ocultar barra de titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask(){

            @Override
            public void run() {
                //Iniciar el Main Activity
                Intent mainIntent = new Intent().setClass(SplashScreen.this, MainActivity.class);
                startActivity(mainIntent);
                //Se finaliza la actividad
                finish();
            }
        };

        //Simula la carga de un proceso en la aplicación
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
