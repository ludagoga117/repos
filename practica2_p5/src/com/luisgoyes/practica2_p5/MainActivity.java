package com.luisgoyes.practica2_p5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private boolean masculino = false;
	private boolean[] hob = {false,false,false,false};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Spinner spCitta = (Spinner)findViewById(R.id.spCiudades);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.ciudades_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spCitta.setAdapter(adapter);
    }
	
	public void showDatePickerDialog(View v) {}
	
	public void onButtonSalvarClicked(View view){
		EditText et1 = (EditText)findViewById(R.id.etNombre);
		EditText et2 = (EditText)findViewById(R.id.etTelefono);
		EditText et3 = (EditText)findViewById(R.id.etCorreo);
		//EditText et4 = (EditText)findViewById(R.id.etFecha);
		EditText salida = (EditText)findViewById(R.id.etOutput);
		
		String cEt1 = et1.getText().toString();
		String cEt2 = et2.getText().toString();
		String cEt3 = et3.getText().toString();
		//String cEt4 = et4.getText().toString();
		String cEt4 = "Hola";
		
		if(cEt1.isEmpty()|cEt2.isEmpty()|cEt3.isEmpty()|cEt4.isEmpty()){
			Toast.makeText(getApplicationContext(), "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
		}else{
			String out = new String("Nuevo usuario registrado:\nNombre: "+cEt1+"\nSexo: ");
			if(!masculino){out=out+"Femenino";}
			else{out=out+"Masculino";}
			out.concat("\nTelefono: "+cEt2);
			out.concat("\nEmail: "+cEt3);
			if(hob[0]|hob[1]|hob[2]|hob[3]){
				out.concat("\nHobbies: ");
				if(hob[0]) out.concat("Rascarse la barriga. ");
				if(hob[1]) out.concat("Ver tv. ");
				if(hob[2]) out.concat("Leer. ");
				if(hob[3]) out.concat("Ver peliculas ");
			}
			salida.setText(out);
		}
	}
	
	public void onCheckboxClicked(View view){
		// Is the view now checked?
		boolean checked = ((CheckBox) view).isChecked();

		// Check which checkbox was clicked
		switch(view.getId()) {
			case R.id.cb_rascar:
				if (checked){hob[0]=true;}
				else{hob[0]=false;}
				break;
			case R.id.cb_tv:
				if (checked){hob[1]=true;}
				else{hob[1]=false;}
				break;
			case R.id.cb_leer:
				if (checked){hob[2]=true;}
				else{hob[2]=true;}
				break;
			case R.id.cb_pelicula:
				if (checked){hob[3]=true;}
				else{hob[3]=false;}
				break;
		}
	}
	
	public void onRadioButtonClicked(View view){
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();

		// Check which radio button was clicked
		switch(view.getId()) {
			case R.id.rFemenino:
				if (checked){masculino=false;}
				break;
			case R.id.rMasculino:
				if (checked){masculino=true;}
				break;
		}
	}
}

