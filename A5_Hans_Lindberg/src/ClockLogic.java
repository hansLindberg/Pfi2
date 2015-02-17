public class ClockLogic implements ClockInterface {

	private DigitalClockGUI clockGUI;
	private int alarmHour;
	private int alarmMinute;
	private int finalHour;
	private int finalMinute;

	public ClockLogic(DigitalClockGUI clockIn) {
		this.clockGUI = clockIn;

		Thread t = new ClockThread(this);
		t.start();
		System.out.println("clockGUI created");
	}

	public void setAlarm(int hours, int minutes) {
		this.alarmHour = hours;
		this.alarmMinute = minutes;
		System.out.println("alarm set" + hours + " " + minutes);
	}

	public void clearAlarm() {
		clockGUI.labelAlarm.setText("No Alarm");
		clockGUI.labelAlarmNotice.setText("");
		clockGUI.labelMessage.setText("");
		this.alarmHour = 100;
		this.alarmMinute = 100;
	}

	@Override
	public void update(int hours, int minutes, int seconds) {
		// Some variables that will create a '0' if a number is single digit, to
		// make it nicer.
		String zero1 = "";
		String zero2 = "";
		String zero3 = "";

		if (hours < 10) {
			zero1 = "0";
		}
		if (minutes < 10) {
			zero2 = "0";
		}
		if (seconds < 10) {
			zero3 = "0";
		}

		// Compiles the values to nice, readable strings.
		String hourString = zero1 + Integer.toString(hours);
		String minuteString = zero2 + Integer.toString(minutes);
		String secondString = zero3 + Integer.toString(seconds);
		String finalTimeString = hourString + ":" + minuteString + ":"
				+ secondString;

		clockGUI.setTimeOnLabel(finalTimeString);
		
		zero1 = "";
		zero2 = "";
		zero3 = "";
		
		finalHour = hours;
		finalMinute = minutes;

		if (this.alarmHour == finalHour && this.alarmMinute == finalMinute) {
			System.out.println("Ring ring!");
			clockGUI.alarm(true);
		}
	}
}
