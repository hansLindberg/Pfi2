package se.mah.k3lara.skaneAPI.view;

import java.util.ArrayList;

import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class StationsThread extends Thread {

	private Parser parser;
	private GUI gui;

	public StationsThread(Parser p, GUI g) {
		this.parser = p;
		this.gui = g;
	}

	public void run() {

		// Tömmer areat, för att undvika kladd
		gui.areaResult1.setText(null);

		gui.areaResult1.setText("Loading...");

		// Skapar en arrayList som används till att söka efter stationer
		// längre ner.
		ArrayList<Station> searchStations1 = new ArrayList<Station>();

		searchStations1.addAll(Parser.getStationsFromURL(gui.fieldSearch
				.getText()));
		
		gui.areaResult1.setText(null);
		
		for (Station s : searchStations1) {
			gui.areaResult1.append(s.getStationName() + " number:"
					+ s.getStationNbr() + " latitude: " + s.getLatitude()
					+ " longitude: " + s.getLongitude() + "\n");
		}

	}

}
