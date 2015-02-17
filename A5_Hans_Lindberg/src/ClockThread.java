import java.util.Calendar;

public class ClockThread extends Thread {

	private ClockInterface clockInterface;

	private boolean running = true;

	public ClockThread(ClockInterface ci) {
		this.clockInterface = ci;
		System.out.println("clockThread created");
	}

	public void run() {
		System.out.println("Thread run");
		while (running == true) {
			System.out.println("Thread run true");
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Calendar now = Calendar.getInstance();
			System.out.println(now.get(Calendar.HOUR_OF_DAY));
			System.out.println(now.get(Calendar.MINUTE));
			System.out.println(now.get(Calendar.SECOND));
			clockInterface.update(now.get(Calendar.HOUR_OF_DAY),
					now.get(Calendar.MINUTE), now.get(Calendar.SECOND));
		}
	}
}
