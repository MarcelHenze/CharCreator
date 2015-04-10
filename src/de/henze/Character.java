package de.henze;

import java.io.Serializable;
import java.util.Random;

public class Character implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public enum Geschlecht {
		männlich, weiblich
	};
	public enum Klasse {
		a,b,c
	};

	private Geschlecht geschlecht;
	private Klasse klasse;
	private int Stärke, Geschicklichkeit, Gewandtheit, Konstitution, Intelligenz, Zaubertalent,
	Aussehen, persönliche_Ausstrahlung, Willenskraft, Selbstbeherrschung, Bewegungsweite,
	Schadensbonus, Ausdauerbonus, Lebenspunkte, Ausdauerpunkte, Körpergröße, Gewicht, Fachkenntnisse,
	Waffenfertigkeiten, Allgemeinwissen, ungewöhnliche_Fähigkeiten, Zauberkünste, Gifttoleranz;
	private String name;
	
	public Character() {
		super();
		geschlecht = null;
		klasse = null;
	}
	
	public void setzeWerte() {
		setStärke();
		setGeschicklichkeit();
		setGewandtheit();
		setKonstitution();
		setIntelligenz();
		setZaubertalent();
		setAussehen();
		setPersönliche_Ausstrahlung();
		setWillenskraft();
		setSelbstbeherrschung();
		setBewegungsweite();
		setSchadensbonus();
		setAusdauerbonus();
		setLebenspunkte();
		setAusdauerpunkte();
		setKörpergröße();
		setGewicht();
		setFachkenntnisse();
		setWaffenfertigkeiten();
		setAllgemeinwissen();
		setUngewöhnliche_Fähigkeiten();
		setZauberkünste();
		setGifttoleranz();		
	}

	public int generateRandomNumer(int min, int max) {
		int Random = new Random().nextInt(max - min + 1) + min;
		return Random;
	}

	public void setGeschlecht(Geschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	public Geschlecht getGeschlecht() {
		return geschlecht;
	}
	
	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}
	
	public Klasse getKlasse() {
		return klasse;
	}

	public int getStärke() {
		return Stärke;
	}

	// Rnd zahl zw. 50 und 100.
	public void setStärke() {
		Stärke = generateRandomNumer(50, 100);
	}

	public int getGeschicklichkeit() {
		return Geschicklichkeit;
	}

	// Rnd zahl zw. 50 und 100.
	public void setGeschicklichkeit() {
		Geschicklichkeit = generateRandomNumer(50, 100);
	}

	public int getGewandtheit() {
		return Gewandtheit;
	}

	// Rnd zahl zw. 50 und 100.
	public void setGewandtheit() {
		Gewandtheit = generateRandomNumer(50, 100);
	}

	public int getKonstitution() {
		return Konstitution;
	}

	// Rnd zahl zw. 50 und 100.
	public void setKonstitution() {
		Konstitution = generateRandomNumer(50, 100);
	}

	public int getIntelligenz() {
		return Intelligenz;
	}

	// Rnd zahl zw. 50 und 100.
	public void setIntelligenz() {
		Intelligenz = generateRandomNumer(50, 100);
	}

	public int getZaubertalent() {
		return Zaubertalent;
	}

	// Rnd zahl zw. 50 und 100.
	public void setZaubertalent() {
		Zaubertalent = generateRandomNumer(50, 100);
	}

	public int getAussehen() {
		return Aussehen;
	}

	// Rnd zahl zw. 1 und 100.
	public void setAussehen() {
		Aussehen = generateRandomNumer(1, 100);
	}

	public int getPersönliche_Ausstrahlung() {
		return persönliche_Ausstrahlung;
	}

	// 3 * (In/10 + Au/10) – 30 + (Rnd zahl zw. 1 und 100)
	public void setPersönliche_Ausstrahlung() {
		persönliche_Ausstrahlung = 3 * (Intelligenz / 10 + Aussehen / 10) - 30 + generateRandomNumer(1, 100);
	}

	public int getWillenskraft() {
		return Willenskraft;
	}

	// 3 * (In/10 + Ko/10) – 40 + (Rnd zahl zw. 1 und 100)
	public void setWillenskraft() {
		Willenskraft = 3 * (Intelligenz / 10 + Konstitution / 10) - 40 + generateRandomNumer(1, 100);
	}

	public int getSelbstbeherrschung() {
		return Selbstbeherrschung;
	}

	// 3 * (In/10 + Wk/10) – 0/30/50 + (Rnd zahl zw. 1 und 100)
	public void setSelbstbeherrschung() {
		Selbstbeherrschung = 3 * (Intelligenz / 10 + Willenskraft / 10) - 30 + generateRandomNumer(1, 100);
	}

	public int getBewegungsweite() {
		return Bewegungsweite;
	}

	// Rnd zwischen 20-28
	public void setBewegungsweite() {
		Bewegungsweite = generateRandomNumer(20, 28);
	}

	public int getSchadensbonus() {
		return Schadensbonus;
	}

	// St/20 + Gs/30 -3
	public void setSchadensbonus() {
		Schadensbonus = Stärke / 20 + Geschicklichkeit / 30 - 3;
	}

	public int getAusdauerbonus() {
		return Ausdauerbonus;
	}

	// Ko/10 + St/20 -7
	public void setAusdauerbonus() {
		Ausdauerbonus = Konstitution / 10 + Stärke / 20 - 7;
	}

	public int getLebenspunkte() {
		return Lebenspunkte;
	}

	// Ko/10 + (Rnd zahl zw. 5 und 10)
	public void setLebenspunkte() {
		Lebenspunkte = Konstitution / 10 + generateRandomNumer(5, 10);
	}

	public int getAusdauerpunkte() {
		return Ausdauerpunkte;
	}

	// Ausb + 4/3/2 + (Rnd zahl zw. 1 und 6)
	public void setAusdauerpunkte() {
		Ausdauerpunkte = Ausdauerbonus + 3 + generateRandomNumer(1, 6);
	}

	public int getKörpergröße() {
		return Körpergröße;
	}

	// Mann = St/10 + Rnd zahl zwischen 152 und 190
	// Frau = St/10 + Rnd zahl zwischen 142 und 180
	public void setKörpergröße() {
		int random = 0;
		if (geschlecht == Geschlecht.männlich) {
			random = generateRandomNumer(152, 190);
		} else if (geschlecht == Geschlecht.weiblich) {
			random = generateRandomNumer(142, 180);
		}
		Körpergröße = Stärke / 10 + random;
	}

	public int getGewicht() {
		return Gewicht;
	}

	// Mann = St/10 + Körpergröße – (Rnd zahl zw. 96 und 116)
	// Frau = St/10 + Körpergröße – (Rnd zahl zw. 92 und 112)
	public void setGewicht() {
		int random = 0;
		if (geschlecht == Geschlecht.männlich) {
			random = generateRandomNumer(96, 116);
		} else if (geschlecht == Geschlecht.weiblich) {
			random = generateRandomNumer(92, 112);
		}
		Gewicht = Stärke / 10 + random;
	}

	public int getFachkenntnisse() {
		return Fachkenntnisse;
	}

	// Rnd zahl zw. 2 und 12
	public void setFachkenntnisse() {
		Fachkenntnisse = generateRandomNumer(2, 12);
	}

	public int getWaffenfertigkeiten() {
		return Waffenfertigkeiten;
	}

	// Rnd zahl zw. 2 und 12
	public void setWaffenfertigkeiten() {
		Waffenfertigkeiten = generateRandomNumer(2, 12);
	}

	public int getAllgemeinwissen() {
		return Allgemeinwissen;
	}

	// Rnd zahl zw. 2 und 7
	public void setAllgemeinwissen() {
		Allgemeinwissen = generateRandomNumer(2, 7);
	}

	public int getUngewöhnliche_Fähigkeiten() {
		return ungewöhnliche_Fähigkeiten;
	}

	// Rnd zahl zw. 1 und 6
	public void setUngewöhnliche_Fähigkeiten() {
		ungewöhnliche_Fähigkeiten = generateRandomNumer(1, 6);
	}

	public int getZauberkünste() {
		return Zauberkünste;
	}

	// Rnd zahl zw. 2 und 12
	public void setZauberkünste() {
		Zauberkünste = generateRandomNumer(2, 12);
	}

	public int getGifttoleranz() {
		return Gifttoleranz;
	}

	// 30 + Ko/2
	public void setGifttoleranz() {
		Gifttoleranz = 30 + Konstitution / 2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
