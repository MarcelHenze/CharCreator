package de.henze;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CharDetails extends ActionBarActivity {

	private Character character;
	private String[] attributListe = { "St", "Gs", "Gw", "Ko", "Int", "Zt",
			"Au", "pA", "Wk", "Sb", "B", "SchB", "AusB", "LP", "AP", "Körpergröße",
			"Gewicht", "Fachkenntnisse", "Waffenfertigkeiten", "Allgemeinwissen",
			"ungewöhnliche Fähigkeiten", "Zauberkünste", "Gifttoleranz" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_char_details);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.char_details, menu);
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
	
	public void setCharacter(Character c) {
		character = c;
	}
	
	public void config() {
		ViewGroup charFrame = (ViewGroup) findViewById(R.id.charFrame);
		for (int i = 0; i < attributListe.length; i++) {
			LayoutInflater li = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View tv = li.inflate(R.layout.field, null);
			TextView stat = (TextView) tv.findViewById(R.id.charStat);
			
			switch (attributListe[i]) {
			case "St":
				stat.setText(attributListe[i]+" : " + character.getStärke());
				break;
			case "Gs":
				stat.setText(attributListe[i]+" : " + character.getGeschicklichkeit());
				break;
			case "Gw":
				stat.setText(attributListe[i]+" : " + character.getGewandtheit());
				break;
			case "Ko":
				stat.setText(attributListe[i]+" : " + character.getKonstitution());
				break;
			case "Int":
				stat.setText(attributListe[i]+" : " + character.getIntelligenz());
				break;
			case "Zt":
				stat.setText(attributListe[i]+" : " + character.getZaubertalent());
				break;
			case "Au":
				stat.setText(attributListe[i]+" : " + character.getAussehen());
				break;
			case "pA":
				stat.setText(attributListe[i]+" : " + character.getPersönliche_Ausstrahlung());
				break;
			case "Wk":
				stat.setText(attributListe[i]+" : " + character.getWillenskraft());
				break;
			case "Sb":
				stat.setText(attributListe[i]+" : " + character.getSelbstbeherrschung());
				break;
			case "B":
				stat.setText(attributListe[i]+" : " + character.getBewegungsweite());
				break;
			case "SchB":
				stat.setText(attributListe[i]+" : " + character.getSchadensbonus());
				break;
			case "AusB":
				stat.setText(attributListe[i]+" : " + character.getAusdauerbonus());
				break;
			case "LP":
				stat.setText(attributListe[i]+" : " + character.getLebenspunkte());
				break;
			case "AP":
				stat.setText(attributListe[i]+" : " + character.getAusdauerpunkte());
				break;
			case "Körpergröße":
				stat.setText(attributListe[i]+" : " + character.getKörpergröße());
				break;
			case "Gewicht":
				stat.setText(attributListe[i]+" : " + character.getGewicht());
				break;
			case "Fachkenntnisse":
				stat.setText(attributListe[i]+" : " + character.getFachkenntnisse());
				break;
			case "Waffenfertigkeiten":
				stat.setText(attributListe[i]+" : " + character.getWaffenfertigkeiten());
				break;
			case "Allgemeinwissen":
				stat.setText(attributListe[i]+" : " + character.getAllgemeinwissen());
				break;
			case "ungewöhnliche Fähigkeiten":
				stat.setText(attributListe[i]+" : " + character.getUngewöhnliche_Fähigkeiten());
				break;
			case "Zauberkünste":
				stat.setText(attributListe[i]+" : " + character.getZauberkünste());
				break;
			case "Gifttoleranz":
				stat.setText(attributListe[i]+" : " + character.getGifttoleranz());
				break;

			default:
				break;
			}			
			charFrame.addView(tv);			
		}
	}
}
