package com.luisgoyes.practica2_p5;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener
{
	int seleccionado = 3;
	int year_x, month_x, day_x;
	static final int DIALOG_ID = 0;
	Personal_data PD1 = new Personal_data();
	private boolean masculino = false;
	private boolean[] hob = {false,false,false,false};
	Spinner spCitta;
    ArrayAdapter<CharSequence> adapter;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
    	final Calendar cal = Calendar.getInstance();
    	final int yst = cal.get(Calendar.YEAR);
    	final int mst = cal.get(Calendar.MONTH);
    	final int dst = cal.get(Calendar.DAY_OF_MONTH);
    	year_x = cal.get(Calendar.YEAR);
    	month_x = cal.get(Calendar.MONTH);
    	day_x = cal.get(Calendar.DAY_OF_MONTH);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		spCitta = (Spinner)findViewById(R.id.spCiudades);
		spCitta.setOnItemSelectedListener(this);
		// Create an ArrayAdapter using the string array and a default spinner layout
		adapter = ArrayAdapter.createFromResource(this,R.array.ciudades_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spCitta.setAdapter(adapter);
    }
    
	public void showDatePickerDialog(View v) {
		showDialog(DIALOG_ID);
	}
	
	protected Dialog onCreateDialog(int id){
		if(id==DIALOG_ID){
			return new DatePickerDialog(this, dpickerListener, year_x, month_x, day_x);
		}
		return null;
	}
	
	private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener(){
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth){
			year_x = year;
			month_x = monthOfYear+1;
			day_x = dayOfMonth;
			EditText et4 = (EditText)findViewById(R.id.etFecha);
			et4.setText(day_x+"/"+month_x+"/"+year_x);
		}
	};
	
	public void onButtonSalvarClicked(View view){
		EditText et1 = (EditText)findViewById(R.id.etNombre);
		EditText et2 = (EditText)findViewById(R.id.etTelefono);
		EditText et3 = (EditText)findViewById(R.id.etCorreo);
		EditText et4 = (EditText)findViewById(R.id.etFecha);
		
		
		String cEt1 = et1.getText().toString();
		String cEt2 = et2.getText().toString();
		String cEt3 = et3.getText().toString();
		String cEt4 = et4.getText().toString();
		
		TextView tv_Nombre = (TextView)findViewById(R.id.tvNombre);
		TextView tv_Telefono = (TextView)findViewById(R.id.tvTelefono);
		TextView tv_Email = (TextView)findViewById(R.id.tvEmail);
		TextView tv_Sexo = (TextView)findViewById(R.id.tvSexo);
		TextView tv_Edad = (TextView)findViewById(R.id.tvEdad);
		TextView tv_Ciudad = (TextView)findViewById(R.id.tvCiudad);
		TextView tv_Hobbies = (TextView)findViewById(R.id.tvHobbies);
		
		if(cEt1.isEmpty()|cEt2.isEmpty()|cEt3.isEmpty()|cEt4.isEmpty()){
			Toast.makeText(getApplicationContext(), "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
		}else{
			PD1.setNombre(cEt1);
			PD1.setTelefono(cEt2);
			PD1.setDireccion(cEt3);
			PD1.setNascita(year_x, month_x, day_x);
			tv_Nombre.setText("Nombre: "+PD1.getNombre());
			tv_Telefono.setText("Telefono: "+PD1.getTelefono());
			tv_Email.setText("Email: "+PD1.getDireccion());
			String temp = (masculino==true)?"Masculino":"Femenino";
			tv_Sexo.setText("Sexo: "+temp);
			tv_Edad.setText("Edad: "+PD1.getEdad());
			String tempCi = "";
			switch (seleccionado){
			case 0:
				tempCi = "Medellin";
				break;
			case 1:
				tempCi = "Bogota";
				break;
			case 2:
				tempCi = "Cali";
				break;
			case 3:
				tempCi = "Pereira";
				break;
			case 4:
				tempCi = "Manizales";
				break;
			}
			tv_Ciudad.setText("Ciudad: "+tempCi);
			String tempHob = "";
			if(hob[0]) tempHob = tempHob + "Rascarse la barriga. ";
			if(hob[1]) tempHob = tempHob + "Ver tv. ";
			if(hob[2]) tempHob = tempHob + "Leer. ";
			if(hob[3]) tempHob = tempHob + "Ver películas. ";
			if(!hob[0]&!hob[1]&!hob[2]&!hob[3]){
				tempHob = tempHob + "Ni pio.";
			}
			tv_Hobbies.setText("Hobbies: "+tempHob);
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
				else{hob[2]=false;}
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

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,long id) {
		// TODO Auto-generated method stub
		seleccionado = parent.getSelectedItemPosition();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}

