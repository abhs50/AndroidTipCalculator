package com.example.andrioidtipcalculator;

import java.math.BigDecimal;

import java.text.DecimalFormat;

import org.apache.commons.math.util.MathUtils;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText amountText;
	private TextView tipText;
	private Button amntTenPercent;
	private Button amntFifteenPercent;
	private Button amnTwentyPercent;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amountText = (EditText) findViewById(R.id.editText1);
        amntTenPercent = (Button) findViewById(R.id.button1);
        amntFifteenPercent = (Button) findViewById(R.id.button2);
        amnTwentyPercent = (Button) findViewById(R.id.button3);
        
    }
    
    public void textFieldClicked(View v){
    	if(v.getId()==R.id.editText1);
    		amountText.setText("");    
    

    }
    
    public void calculateTip(View buttonView){
    	
    	String strAmount = amountText.getText().toString().trim();
    	if(strAmount.isEmpty()){
    		Toast.makeText(getBaseContext(), "Please Enter a Amount",
					Toast.LENGTH_SHORT).show();
			Log.d("DEBUG", "Please Enter a Amount");
			return;
    	}
    	double value = Double.parseDouble(strAmount);
    	if(value == 0.0){
    		Toast.makeText(getBaseContext(), "Please Enter a Amount greater than 0",
					Toast.LENGTH_SHORT).show();
			Log.d("DEBUG", "Please Enter a Amount");
			return;
    	}
    	double amount =Double.parseDouble(new DecimalFormat("##.##").format(value));
    	
    	double tip = 0;
    	switch(buttonView.getId()){
    		case R.id.button1:
    			tip = calculate(10,amount);
    			break;
    		case R.id.button2:
    			tip = calculate(15,amount);
    			break;
    		case R.id.button3:
    			tip = calculate(20,amount);
    			break;
    	
    	}
    	tipText = (TextView) findViewById(R.id.tipValue);
    	tipText.setText("$"+Double.toString(tip));
    	
    }


    private double calculate(int percentage,double amount) {
		double result= amount*percentage*0.01;
		return MathUtils.round(result, 2, BigDecimal.ROUND_HALF_DOWN);
		
		
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
