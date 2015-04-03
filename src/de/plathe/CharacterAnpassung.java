package de.plathe;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import org.apache.http.client.ClientProtocolException;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CharacterAnpassung extends ActionBarActivity {
	
	private CharListe charListe;
	private Character character;
	private Button finish;
	private String[] attributListe = { "St", "Gs", "Gw", "Ko", "Int", "Zt",
			"Au", "pA", "Wk", "Sb", "B", "SchB", "AusB", "LP", "AP", "Körpergröße",
			"Gewicht", "Fachkenntnisse", "Waffenfertigkeiten", "Allgemeinwissen",
			"ungewöhnliche Fähigkeiten", "Zauberkünste", "Gifttoleranz" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_char_anpassung);
		character = (Character) getIntent().getSerializableExtra(CharErstellung.SER_KEY);
		character.setzeWerte();
		finish = (Button) findViewById(R.id.finishButton);
		charListe = new CharListe(getApplicationContext());
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getMenuInflater().inflate(R.menu.main, menu);
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void init() {
		ViewGroup insertPoint = (ViewGroup) findViewById(R.id.mainframe);
		for (int i = 0; i < attributListe.length; i++) {
			LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View statrow = vi.inflate(R.layout.statrow, null);
			TextView name = (TextView) statrow.findViewById(R.id.statname);
			name.setText(attributListe[i]);

			final TextView value = (TextView) statrow.findViewById(R.id.statvalue);
			ImageView reroll = (ImageView) statrow.findViewById(R.id.reroll);

			switch (attributListe[i]) {
			case "St":
				value.setText("" + character.getStärke());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setStärke();
						value.setText("" + character.getStärke());
					}
				});
				break;
			case "Gs":
				value.setText("" + character.getGeschicklichkeit());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setGeschicklichkeit();
						value.setText("" + character.getGeschicklichkeit());
					}
				});
				break;
			case "Gw":
				value.setText("" + character.getGewandtheit());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setGewandtheit();
						value.setText("" + character.getGewandtheit());
					}
				});
				break;
			case "Ko":
				value.setText("" + character.getKonstitution());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setKonstitution();
						value.setText("" + character.getKonstitution());
					}
				});
				break;
			case "Int":
				value.setText("" + character.getIntelligenz());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setIntelligenz();
						value.setText("" + character.getIntelligenz());
					}
				});
				break;
			case "Zt":
				value.setText("" + character.getZaubertalent());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setZaubertalent();
						value.setText("" + character.getZaubertalent());
					}
				});
				break;
			case "Au":
				value.setText("" + character.getAussehen());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setAussehen();
						value.setText("" + character.getAussehen());
					}
				});
				break;
			case "pA":
				value.setText("" + character.getPersönliche_Ausstrahlung());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setPersönliche_Ausstrahlung();
						value.setText("" + character.getPersönliche_Ausstrahlung());
					}
				});
				break;
			case "Wk":
				value.setText("" + character.getWillenskraft());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setWillenskraft();
						value.setText("" + character.getWillenskraft());
					}
				});
				break;
			case "Sb":
				value.setText("" + character.getSelbstbeherrschung());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setSelbstbeherrschung();
						value.setText("" + character.getSelbstbeherrschung());
					}
				});
				break;
			case "B":
				value.setText("" + character.getBewegungsweite());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setBewegungsweite();
						value.setText("" + character.getBewegungsweite());
					}
				});
				break;
			case "SchB":
				value.setText("" + character.getSchadensbonus());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setSchadensbonus();
						value.setText("" + character.getSchadensbonus());
					}
				});
				break;
			case "AusB":
				value.setText("" + character.getAusdauerbonus());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setAusdauerbonus();
						value.setText("" + character.getAusdauerbonus());
					}
				});
				break;
			case "LP":
				value.setText("" + character.getLebenspunkte());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setLebenspunkte();
						value.setText("" + character.getLebenspunkte());
					}
				});
				break;
			case "AP":
				value.setText("" + character.getAusdauerpunkte());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setAusdauerpunkte();
						value.setText("" + character.getAusdauerpunkte());
					}
				});
				break;
			case "Körpergröße":
				value.setText("" + character.getKörpergröße());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setKörpergröße();
						value.setText("" + character.getKörpergröße());
					}
				});
				break;
			case "Gewicht":
				value.setText("" + character.getGewicht());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setGewicht();
						value.setText("" + character.getGewicht());
					}
				});
				break;
			case "Fachkenntnisse":
				value.setText("" + character.getFachkenntnisse());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setFachkenntnisse();
						value.setText("" + character.getFachkenntnisse());
					}
				});
				break;
			case "Waffenfertigkeiten":
				value.setText("" + character.getWaffenfertigkeiten());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setWaffenfertigkeiten();
						value.setText("" + character.getWaffenfertigkeiten());
					}
				});
				break;
			case "Allgemeinwissen":
				value.setText("" + character.getAllgemeinwissen());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setAllgemeinwissen();
						value.setText("" + character.getAllgemeinwissen());
					}
				});
				break;
			case "ungewöhnliche Fähigkeiten":
				value.setText("" + character.getUngewöhnliche_Fähigkeiten());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setUngewöhnliche_Fähigkeiten();
						value.setText("" + character.getUngewöhnliche_Fähigkeiten());
					}
				});
				break;
			case "Zauberkünste":
				value.setText("" + character.getZauberkünste());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setZauberkünste();
						value.setText("" + character.getZauberkünste());
					}
				});
				break;
			case "Gifttoleranz":
				value.setText("" + character.getGifttoleranz());
				reroll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						character.setGifttoleranz();;
						value.setText("" + character.getGifttoleranz());
					}
				});
				break;

			default:
				break;
			}
			insertPoint.addView(statrow);
		}
		
		finish.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				try {
					charListe.addCharacter(character);
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Toast.makeText(getApplicationContext(), "Character gespeichert!", Toast.LENGTH_LONG).show();
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						Intent intent = new Intent(getApplicationContext(), StartScreen.class);
						finish();
						startActivity(intent);						
					}
				}, 350);
			}
		});
	}
	
}
