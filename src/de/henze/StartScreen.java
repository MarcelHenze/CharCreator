package de.henze;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartScreen extends ActionBarActivity {

	private CharListe charListe;
	public final static String SER_KEY_DETAILS = "de.plathe.CharacterObjectDetails.ser";
	private String[] attributListe = { "St", "Gs", "Gw", "Ko", "Int", "Zt",
			"Au", "pA", "Wk", "Sb", "B", "SchB", "AusB", "LP", "AP", "Körpergröße",
			"Gewicht", "Fachkenntnisse", "Waffenfertigkeiten", "Allgemeinwissen",
			"ungewöhnliche Fähigkeiten", "Zauberkünste", "Gifttoleranz" };

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

			ImageView charIcon = (ImageView) charField.findViewById(R.id.charIcon);
			TextView nameField = (TextView) charField.findViewById(R.id.charName);
			final ViewGroup charDetailFrame = (ViewGroup) charField.findViewById(R.id.charDetails);

			charIcon.setImageResource(R.drawable.dice);
			charIcon.setOnClickListener(new OnClickListener() {				
				@Override
				public void onClick(View v) {
					if (charDetailFrame.isShown()) {
						slide_up(getApplicationContext(), charDetailFrame);
						Handler handler = new Handler();
						handler.postDelayed(new Runnable(){
						    public void run() {
						    	charDetailFrame.setVisibility(View.GONE);
						        }
						}, 500);
					} else {
						slide_down(getApplicationContext(), charDetailFrame);
						charDetailFrame.setVisibility(View.VISIBLE);
					}
				}
			});

			nameField.setText(c.getName());
			
			fillChar(c, charDetailFrame);

			charDetailFrame.setVisibility(View.GONE);
			charFrame.addView(charField);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.start_screen, menu);
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

	public void fillChar(Character character, ViewGroup insertPoint) {
		for (int i = 0; i < attributListe.length; i++) {
			LayoutInflater li = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View statrow = li.inflate(R.layout.statrow, null);
			TextView name = (TextView) statrow.findViewById(R.id.statname);
			final TextView value = (TextView) statrow.findViewById(R.id.statvalue);
			ImageView reroll = (ImageView) statrow.findViewById(R.id.reroll);
			//name.setVisibility(View.GONE);
			reroll.setVisibility(View.GONE);

			name.setText(attributListe[i]);
			switch (attributListe[i]) {
			case "St":
				value.setText("" + character.getStärke());
				break;
			case "Gs":
				value.setText("" + character.getGeschicklichkeit());
				break;
			case "Gw":
				value.setText("" + character.getGewandtheit());
				break;
			case "Ko":
				value.setText("" + character.getKonstitution());
				break;
			case "Int":
				value.setText("" + character.getIntelligenz());
				break;
			case "Zt":
				value.setText("" + character.getZaubertalent());
				break;
			case "Au":
				value.setText("" + character.getAussehen());
				break;
			case "pA":
				value.setText("" + character.getPersönliche_Ausstrahlung());
				break;
			case "Wk":
				value.setText("" + character.getWillenskraft());
				break;
			case "Sb":
				value.setText("" + character.getSelbstbeherrschung());
				break;
			case "B":
				value.setText("" + character.getBewegungsweite());
				break;
			case "SchB":
				value.setText("" + character.getSchadensbonus());
				break;
			case "AusB":
				value.setText("" + character.getAusdauerbonus());
				break;
			case "LP":
				value.setText("" + character.getLebenspunkte());
				break;
			case "AP":
				value.setText("" + character.getAusdauerpunkte());
				break;
			case "Körpergröße":
				value.setText("" + character.getKörpergröße());
				break;
			case "Gewicht":
				value.setText("" + character.getGewicht());
				break;
			case "Fachkenntnisse":
				value.setText("" + character.getFachkenntnisse());
				break;
			case "Waffenfertigkeiten":
				value.setText("" + character.getWaffenfertigkeiten());
				break;
			case "Allgemeinwissen":
				value.setText("" + character.getAllgemeinwissen());
				break;
			case "ungewöhnliche Fähigkeiten":
				value.setText("" + character.getUngewöhnliche_Fähigkeiten());
				break;
			case "Zauberkünste":
				value.setText("" + character.getZauberkünste());
				break;
			case "Gifttoleranz":
				value.setText("" + character.getGifttoleranz());
				break;

			default:
				break;
			}
			insertPoint.addView(statrow);
		}
	}
	
	public static void slide_down(Context ctx, View v) {
		Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
		v.startAnimation(a);
	}
	
	public static void slide_up(Context ctx, View v) {
		Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_up);
		v.startAnimation(a);
	}
}
