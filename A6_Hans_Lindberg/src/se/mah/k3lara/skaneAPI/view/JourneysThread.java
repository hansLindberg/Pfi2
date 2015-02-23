package se.mah.k3lara.skaneAPI.view;

import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class JourneysThread extends Thread {

	private Parser parser;
	private GUI gui;

	public JourneysThread(Parser p, GUI g) {
		this.parser = p;
		this.gui = g;
	}

	public void run() {

		// Tömmer arean för att undvika kladd
		gui.areaResult2.setText(null);
		
		gui.areaResult2.setText("Loading...");

		String searchURL1 = Constants.getURL(gui.fieldFrom.getText(),
				gui.fieldTo.getText(), 1);

		// Gör ett sökningsObjekt med hjälp av searchURL
		Journeys journeys1 = Parser.getJourneys(searchURL1);
		
		gui.areaResult2.setText(null);
		
		for (Journey journey : journeys1.getJourneys()) {
			gui.areaResult2.append(journey.getStartStation() + " - "
					+ journey.getEndStation());
			String time1 = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)
					+ ":" + journey.getDepDateTime().get(Calendar.MINUTE);
			gui.areaResult2.append(" Departs " + time1 + " that is in "
					+ journey.getTimeToDeparture() + " minutes. And it is "
					+ journey.getDepTimeDeviation() + " min late");
		}

	}

}
