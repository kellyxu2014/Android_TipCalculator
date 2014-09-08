package com.example.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText etTotalAmount;
	private TextView tvTipAmount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etTotalAmount = (EditText) findViewById(R.id.etTotalAmount);
		tvTipAmount = (TextView) findViewById(R.id.tvTipAmount);
	}

	public void onClickBtn10per(View v) {
		String input = etTotalAmount.getText().toString();
		if(!this.isStringValid(input))
			return;
		double amount = Double.parseDouble(input);
		this.updateTip(amount, 0.1);
		
	}
	
	public void onClickBtn15per(View v) {
		String input = etTotalAmount.getText().toString();
		if(!this.isStringValid(input)) {
			this.resetTip();
			return;
		}
		double amount = Double.parseDouble(input);
		this.updateTip(amount, 0.15);
	}
	
	public void onClickBtn20per(View v) {
		String input = etTotalAmount.getText().toString();
		if(!this.isStringValid(input)) {
			this.resetTip();
			return;
		}
		double amount = Double.parseDouble(input);
		this.updateTip(amount, 0.2);
	}
		
	private void updateTip(double amount, double multiplier) {
		double tipAmount = amount * multiplier;
		tvTipAmount.setText("$" + String.format("%.02f", tipAmount));
		System.out.println("tvTip returns value");
	}
	
	private boolean isStringValid(String input) {
		if (input.trim() == null || input.trim().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	private void resetTip() {
		tvTipAmount.setText("$0");
		
	}
}
