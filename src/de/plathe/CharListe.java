package de.plathe;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CharListe {
	
	private List<Character> charListe;	
	private static SharedPreferences sharedPrefs;
	private static Editor editor;
	
	public CharListe() {
		charListe = new ArrayList<Character>();
	}
	
	public void addCharacter(Character character) {
		charListe.add(character);
	}
	
	public List<Character> getCharacters() {
		return charListe;
	}
	
	public void saveList() throws ClientProtocolException, IOException, URISyntaxException, ParseException{
		String json = new Gson().toJson(charListe);
		editor = sharedPrefs.edit();
		editor.putString("Charliste", json);
		editor.commit();
	}
	
	public List<Character> loadList() {
		Type type = new TypeToken<List<Character>>() {}.getType();
		String json = sharedPrefs.getString("Charliste", "");
		List<Character> savedCharListe = new Gson().fromJson(json, type);
		return savedCharListe;
	}
	

}
