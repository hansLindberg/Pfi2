import java.util.Calendar;

public class ClockThread extends Thread {

	private ClockInterface clockInterface;

	private boolean running = true;

	public ClockThread(ClockInterface ci) {
		this.clockInterface = ci;
	}

	public void run() {
		while (running == true) {
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Calendar now = Calendar.getInstance();
			clockInterface.update(now.get(Calendar.HOUR_OF_DAY),
					now.get(Calendar.MINUTE), now.get(Calendar.SECOND));
		}
	}
}
