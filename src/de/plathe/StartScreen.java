package de.plathe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartScreen extends ActionBarActivity {
	
	private CharListe charListe;
	public final static String SER_KEY_DETAILS = "de.plathe.CharacterObjectDetails.ser";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_screen);
		ViewGroup charFrame = (ViewGroup) findViewById(R.id.charFrame);
		charListe = new CharListe(getApplicationContext());
		Button createNewChar = (Button) findViewById(R.id.createNewChar);
		createNewChar.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), CharErstellung.class);
				finish();
				startActivity(intent);
			}
		});
		for (final Character c : charListe.getCharacters()) {
			LayoutInflater li = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View charField = li.inflate(R.layout.character, null);
			
			TextView nameField = (TextView) charField.findViewById(R.id.charName);
			ImageView charIcon = (ImageView) charField.findViewById(R.id.charIcon);
			
			nameField.setText("Name: "+c.getName());
			charIcon.setImageResource(R.drawable.dice);
			charFrame.addView(charField);	
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.start_screen, menu);
		return false;
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
