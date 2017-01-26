package com.desarrollodeaplicaciones.ejercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre, txtPeso, txtEstatura;
    CheckBox chEjercicio;
    RadioButton rdHombre, rdMujer;
    TextView txtResult;
    Button btnCalcular;
    Button btnLimpiar;
    Persona p;
    int cve;
    Button btnDevInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se relacionan los objetos del xml
        txtNombre=(EditText)findViewById(R.id.txtNombre);
        txtPeso=(EditText)findViewById(R.id.txtPeso);
        txtEstatura=(EditText)findViewById(R.id.txtEstatura);
        chEjercicio=(CheckBox)findViewById(R.id.chEjercicio);
        rdHombre=(RadioButton)findViewById(R.id.rdHombre);
        rdMujer=(RadioButton)findViewById(R.id.rdMujer);
        txtResult=(TextView)findViewById(R.id.txtResultado);
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        btnLimpiar=(Button)findViewById(R.id.btnLimpiar);
        btnDevInfo=(Button)findViewById(R.id.btnDev);

        //Asociar escucha al boton para el evento Click
        btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                p = new Persona();//Objeto de la clase persona
                p.setNombre(txtNombre.getText().toString());
                p.setPeso(Double.parseDouble(txtPeso.getText().toString()));
                p.setEstatura(Double.parseDouble(txtEstatura.getText().toString()));
                if(chEjercicio.isChecked()){
                    p.setEjercicio((byte)1);
                }else{
                    p.setEjercicio((byte)0);
                }
                if (rdHombre.isChecked()){
                    p.setSexo('H');
                }else if (rdMujer.isChecked()){
                    p.setSexo('M');
                }else{
                    p.setSexo('X');
                }
                p.calcularImc();

               if(p.getImc()<20){
                    p.setStatus("Bajo");
                   cve = 1;
                }else if(p.getImc() >20 && p.getImc() < 25){
                    p.setStatus("Normal");
                   cve =2;
                }else if (p.getImc()>25){
                    p.setStatus("Sobre Peso");
                   cve=3;
                }

                txtResult.setText(p.toString());

                Intent i = new Intent(MainActivity.this, DatosPersona.class);
                i.putExtra("txtRes", txtResult.getText().toString());
                i.putExtra("clave", cve);

                startActivity(i);

            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtPeso.setText("");
                txtEstatura.setText("");
                chEjercicio.setChecked(false);
                rdMujer.setChecked(false);
                rdHombre.setChecked(false);
                txtResult.setText("");
            }
        });

        btnDevInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeveloperData.class);
                startActivity(intent);
            }
        });
    }
}
