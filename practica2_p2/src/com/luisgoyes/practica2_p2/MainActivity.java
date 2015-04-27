package com.luisgoyes.practica2_p2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class MainActivity extends Activity {
	private RadioButton opcion;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText num1= (EditText) findViewById(R.id.etNum1);
		final EditText num2= (EditText) findViewById(R.id.etNum2);
		final EditText ans= (EditText) findViewById(R.id.etResult);
		final RadioGroup opciones = (RadioGroup)findViewById(R.id.rgOps);
		final Button boton = (Button) findViewById(R.id.bCalcular);
		boton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				if(num1.getText().toString().isEmpty()|num2.getText().toString().isEmpty())
					ans.setText(Double.toString(0.0));
				else{
					//get selected radio button from radioGroup
					int choise = opciones.getCheckedRadioButtonId();
					//Find the radiobutton by returned id
					opcion = (RadioButton) findViewById(choise);
					String sOpcion = opcion.getText().toString();
					int nOpcion = 0;
					if(sOpcion.compareTo(getResources().getString(R.string.Op1))==0)
						nOpcion = 1;
					else if(sOpcion.compareTo(getResources().getString(R.string.Op2))==0)
						nOpcion = 2;
					else if(sOpcion.compareTo(getResources().getString(R.string.Op3))==0)
						nOpcion = 3;
					else if(sOpcion.compareTo(getResources().getString(R.string.Op4))==0)
						nOpcion = 4;
					double n1 = Double.parseDouble(num1.getText().toString());
					double n2 = Double.parseDouble(num2.getText().toString());
					double n = 0;
					switch(nOpcion){
						case 1:
							n = n1 + n2;
							break;
						case 2:
							n = n1 - n2;
							break;
						case 3:
							n = n1 * n2;
							break;
						case 4:
							if(n2!=0) n = n1 / n2;
							break;
						default:
							ans.setText(getResources().getString(R.string.ErrorO));
					}
					if(nOpcion>=1&nOpcion<=4){
						if(nOpcion==4&n2==0)
							ans.setText(getResources().getString(R.string.ErrorD));
						else
							ans.setText(Double.toString(n));
					}
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
