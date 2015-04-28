package com.luisgoyes.practica2_p4;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
	RadioButton opcion;
	double n1=0, n2=0, n=0;
	boolean error = false;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		final EditText h= (EditText) findViewById(R.id.etAltura);
		final EditText b= (EditText) findViewById(R.id.etBase);
		final EditText l= (EditText) findViewById(R.id.etLado);
		final EditText r= (EditText) findViewById(R.id.etRadio);
		final EditText ans= (EditText) findViewById(R.id.etArea);
		final RadioGroup opciones = (RadioGroup)findViewById(R.id.rgOps);
		final Button boton = (Button) findViewById(R.id.bCalcular);
		boton.setOnClickListener(new View.OnClickListener(){
				public void onClick(View v){
					//get selected radio button from radioGroup
					int choise = opciones.getCheckedRadioButtonId();
					//Find the radiobutton by returned id
					opcion = (RadioButton) findViewById(choise);
					String sOpcion = opcion.getText().toString();
					int nOpcion = 0;
					if(sOpcion.compareTo(getResources().getString(R.string.triangulo))==0)
						nOpcion = 1;
					else if(sOpcion.compareTo(getResources().getString(R.string.cuadrado))==0)
						nOpcion = 2;
					else if(sOpcion.compareTo(getResources().getString(R.string.rectangulo))==0)
						nOpcion = 3;
					else if(sOpcion.compareTo(getResources().getString(R.string.circulo))==0)
						nOpcion = 4;
					switch(nOpcion){
						case 1:
							if(!h.getText().toString().isEmpty()&!b.getText().toString().isEmpty()){
								n1 = Double.parseDouble(h.getText().toString());
								n2 = Double.parseDouble(b.getText().toString());
								n = n1*n2/2;
								error=false;
							}else
								error=true;
							break;
						case 2:
							if(!l.getText().toString().isEmpty()){
								n1 = Double.parseDouble(l.getText().toString());
								n = n1*n1;
								error=false;
							}else
								error=true;
							break;
						case 3:
							if(!h.getText().toString().isEmpty()&!b.getText().toString().isEmpty()){
								n1 = Double.parseDouble(h.getText().toString());
								n2 = Double.parseDouble(b.getText().toString());
								n = n1*n2;
								error=false;
							}else{
								error=true;
							}
							break;
						case 4:
							if(!r.getText().toString().isEmpty()){
								n1 = Double.parseDouble(r.getText().toString());
								n = n1*Math.PI;
								error=false;
							}else{
								error=true;
							}
							break;
					}
					if(error==false){
						ans.setText(Double.toString(n));
					}else{
						ans.setText("");
						Toast.makeText(getApplicationContext(), getResources().getString(R.string.errorF), Toast.LENGTH_SHORT).show();
					}
				}
			});
	}
}
