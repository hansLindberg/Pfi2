package se.mah.k3lara.skaneAPI.view;

public class SearchThread extends Thread {
	private GUI gui;
	
	private boolean running = true;
	
	public SearchThread(GUI g){
		this.gui = g;
	}
	
	public void run() {
		while (running == true){
			
			//Every 30 sec, make a new query to Skånetrafiken, then update the GUI.
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
