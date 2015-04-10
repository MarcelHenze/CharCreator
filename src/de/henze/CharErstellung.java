package de.henze;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CharErstellung extends ActionBarActivity {

	private EditText nameField;
	private ImageView klasse1, klasse2, klasse3, male, female;
	private Button next;
	Character character = new Character();
	public final static String SER_KEY = "de.plathe.CharacterObject.ser";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_char_erstellung);
		nameField = (EditText) findViewById(R.id.nameField);

		klasse1 = (ImageView) findViewById(R.id.klasse1);
		klasse1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				character.setKlasse(Character.Klasse.a);
			}
		});

		klasse2 = (ImageView) findViewById(R.id.klasse2);
		klasse2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				character.setKlasse(Character.Klasse.b);
			}
		});

		klasse3 = (ImageView) findViewById(R.id.klasse3);
		klasse3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				character.setKlasse(Character.Klasse.c);
			}
		});

		male = (ImageView) findViewById(R.id.male);
		male.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				character.setGeschlecht(Character.Geschlecht.männlich);
			}
		});
		female = (ImageView) findViewById(R.id.female);
		female.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				character.setGeschlecht(Character.Geschlecht.weiblich);
			}
		});

		next = (Button) findViewById(R.id.createChar);
		next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!nameField.getText().toString().equals("") && character.getKlasse() != null && character.getGeschlecht() != null) {					
					Intent intent = new Intent(getApplicationContext(), CharacterAnpassung.class);
					character.setName(nameField.getText().toString());
					Bundle mBundle = new Bundle();
					mBundle.putSerializable(SER_KEY, character);
					intent.putExtras(mBundle);
					finish();
					startActivity(intent);
				} else {
					Toast popup = Toast.makeText(getApplicationContext(), "Bitte Namen eingeben und Klasse/Geschlecht auswählen", Toast.LENGTH_SHORT);	
					popup.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
					popup.show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.char_erstellung, menu);
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
