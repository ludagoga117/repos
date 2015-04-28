package com.luisgoyes.practica2_p3;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
	String et1, et2, et3, et4;
	boolean range[] = {true, true, true, true};
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
					if((Double.parseDouble(et1)>=0)&(Double.parseDouble(et1)<=5)){
						if((Double.parseDouble(et2)>=0)&(Double.parseDouble(et2)<=5)){
							if((Double.parseDouble(et3)>=0)&(Double.parseDouble(et3)<=5)){
								if((Double.parseDouble(et4)>=0)&(Double.parseDouble(et4)<=5)){
									double n = Double.parseDouble(et1)*0.15+Double.parseDouble(et2)*0.1+Double.parseDouble(et3)*.4+Double.parseDouble(et4)*.35;
									et5.setText(Double.toString(n));
								}else{
									range[3]=false;
								}
							}else{
								range[2]=false;
							}
						}else{
							range[1]=false;
						}
					}else{
						range[0]=false;
					}
					if((!range[0])|(!range[1])|(!range[2])|(!range[3])){
						Toast.makeText(getApplicationContext(), getResources().getString(R.string.errorO), Toast.LENGTH_SHORT).show();
						for( int k = 0; k<=3; k ++){
							range[k] = true;
						}
					}
				}else{
					Toast.makeText(getApplicationContext(), getResources().getString(R.string.errorN), Toast.LENGTH_SHORT).show();
					et5.setText("0.0");
				}
			}
		});
    }
}
