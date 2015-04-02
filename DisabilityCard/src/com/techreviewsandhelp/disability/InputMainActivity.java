package com.techreviewsandhelp.disability;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_main);
		 final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		 
		Button b =(Button)findViewById(R.id.submit);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				   SharedPreferences.Editor editor = preferences.edit();
				   editor.putString(Data.Name,getdata(R.id.inname));
				   editor.putString(Data.Disability,getdata(R.id.indisabilities));
				   editor.putString(Data.Symptomps,getdata(R.id.insymphtoms));
				   editor.putString(Data.Phonenumber,getdata(R.id.inphonenumber));
				   editor.commit();
				   finish();
			}
		});
		
		Button help = (Button) findViewById(R.id.helpbutton);
		help.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri
							.parse("vnd.youtube://xN0fLiun-bY"));
					startActivity(intent);
				} catch (Exception e) {
					Intent intent = new Intent(
							Intent.ACTION_VIEW,
							Uri.parse("http://www.youtube.com/watch?v=xN0fLiun-bY"));
					startActivity(intent);
				}

			}
		});

	
		Button cancel =(Button)findViewById(R.id.cancel);
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	
  String getdata(int id)
  {
	  EditText edittext= (EditText)findViewById(id);
	  return edittext.getText().toString();
  }

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		SharedPreferences preferences = PreferenceManager
				.getDefaultSharedPreferences(this);
		String name =preferences.getString(Data.Name, Data.default_Name);
		String phonenumber = preferences.getString(Data.Phonenumber,
				Data.default_Phonenumber);
		String symptomps = preferences.getString(Data.Symptomps,
				Data.default_Symptomps);
		String disString = preferences.getString(Data.Disability,
				Data.default_Disability);

		settext(R.id.indisabilities, disString);
		settext(R.id.inphonenumber, phonenumber);
		settext(R.id.insymphtoms, symptomps);
		settext(R.id.inname, name);
	}

	public void settext(int id, String text) {

		EditText txt = (EditText) findViewById(id);
		if(text!="")
		txt.setText(text);
	}

}
