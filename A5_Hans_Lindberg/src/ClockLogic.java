
public class ClockLogic implements ClockInterface {

	private DigitalClockGUI clockGUI;
	private int alarmHour;
	private int alarmMinute;	
	
	public ClockLogic(DigitalClockGUI clockIn){
		this.clockGUI = clockIn;
		
		Thread t = new ClockThread(this);
		t.start();
		System.out.println("clockGUI created");
	}
	
	public void setAlarm(int hours, int minutes){
		this.alarmHour = hours;
		this.alarmMinute = minutes;
	}
	
	public void clearAlarm(){
		
	}

	@Override
	public void update(int hours, int minutes, int seconds) {
		if (this.alarmHour == hours && this.alarmMinute == minutes){
			clockGUI.alarm(true);
		}
		
		System.out.println("label set called upon");
		
		clockGUI.setTimeOnLabel(hours + ":" + minutes + ":" + seconds);
	}
}
