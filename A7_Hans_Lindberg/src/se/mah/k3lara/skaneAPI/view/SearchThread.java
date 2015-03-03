package se.mah.k3lara.skaneAPI.view;

import java.util.Calendar;

public class SearchThread extends Thread {
	private GUI gui;
	
	private boolean running = true;
	
	public SearchThread(GUI g){
		this.gui = g;
	}
	
	public void run() {
		while (running == true){
			try{
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Updating!!!");
			gui.UpdateLabels();
		}		
	}

}
