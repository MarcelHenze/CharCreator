package de.plathe;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CharListe {

	private List<Character> charListe;
	private static SharedPreferences sharedPrefs;
	private static Editor editor;

	public CharListe(Context context) {
		sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
		charListe = new ArrayList<Character>();
		if (!sharedPrefs.getString("Charliste", "").equals("") && sharedPrefs.getString("Charliste", "") != null) {
			charListe = loadList();
		}
		Log.e("Size", charListe.size() + "");
		for (Character c : charListe) {
			Log.e("Chars: ", c.getName());
		}
	}

	public void addCharacter(Character character) throws ClientProtocolException, IOException, URISyntaxException, ParseException {
		charListe.add(character);
		saveList();
	}

	public List<Character> getCharacters() {
		return charListe;
	}

	public void saveList() throws ClientProtocolException, IOException, URISyntaxException, ParseException {
		String json = new Gson().toJson(charListe);
		editor = sharedPrefs.edit();
		editor.putString("Charliste", json);
		editor.commit();
	}

	public List<Character> loadList() {
		Type type = new TypeToken<List<Character>>() {
		}.getType();
		String json = sharedPrefs.getString("Charliste", "");
		List<Character> savedCharListe = new Gson().fromJson(json, type);
		return savedCharListe;
	}

}
