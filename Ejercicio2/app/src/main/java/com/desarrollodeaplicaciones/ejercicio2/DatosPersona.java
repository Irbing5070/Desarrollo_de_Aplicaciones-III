package com.desarrollodeaplicaciones.ejercicio2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DatosPersona extends AppCompatActivity {

    private Button btnregresar;
    private ImageView imgPeso;
    private TextView reco;

    public TextView getInformacion() {
        return informacion;
    }
    public void setInformacion(TextView informacion) {
        this.informacion = informacion;
    }

    private TextView informacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_persona);
        //Definicion de objetos
        informacion=(TextView)findViewById(R.id.txtInformacion);
        btnregresar=(Button)findViewById(R.id.btnRegresar);
        imgPeso =(ImageView)findViewById(R.id.imagen);
        reco=(TextView)findViewById(R.id.txtReco);


        btnregresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent next = new Intent(DatosPersona.this, MainActivity.class);
                startActivity(next);
            }
        });
       recogerDatos();

    }


    public void recogerDatos(){
        Bundle extras= getIntent().getExtras();
        String s= extras.getString("txtRes");
        int cve = extras.getInt("clave");
        if(cve==1){
            reco.setText("Recomendación \n"  + "Tienes que llevar una dieta mas balanceada, \n" +
            "Come mas carnes como el pescado o la carne de res para aumentar tu peso y realiza ejercicio diariamente, \n" + "Por lo menos 30 mins Diarios");
            imgPeso.setImageResource(R.drawable.chavelo);
        }else if(cve==2){
            reco.setText("Recomendación \n"  + "Tienes un cuerpo en forma, \n" +
                    "Sigue alimentandote bien, \n" + "Recuerda realizar por lo menos 30 mins Diarios de ejercicio");
            imgPeso.setImageResource(R.drawable.yea);
        }else if (cve==3){
            reco.setText("Recomendación \n"  + "Tienes que llevar una dieta mas balanceada, \n" +
                    "Come mas frutas y verduras y realiza ejercicio diariamente, \n" + "Por lo menos 30 mins Diarios");
            imgPeso.setImageResource(R.drawable.pg);
        }

        informacion.setText(s);

    }
}
