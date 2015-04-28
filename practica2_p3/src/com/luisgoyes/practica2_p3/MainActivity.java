package com.luisgoyes.practica2_p3;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
	String et1, et2, et3, et4;
	EditText et5;
	Button b1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		b1 = (Button)findViewById(R.id.bCalcular);
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				et1 = ((EditText)findViewById(R.id.etQuices)).getText().toString();
				et2 = ((EditText)findViewById(R.id.etExpo)).getText().toString();
				et3 = ((EditText)findViewById(R.id.etLab)).getText().toString();
				et4 = ((EditText)findViewById(R.id.etProyecto)).getText().toString();
				et5 = (EditText)findViewById(R.id.etDefinitiva);
				if(!et1.isEmpty()&!et2.isEmpty()&!et3.isEmpty()&!et4.isEmpty()){
					double n = Double.parseDouble(et1)*0.15+Double.parseDouble(et2)*0.1+Double.parseDouble(et3)*.4+Double.parseDouble(et4)*.35;
					et5.setText(Double.toString(n));
				}else
					et5.setText(getResources().getString(R.string.errorN));
					et5.setEnabled(false);
			}
		});
    }
}
