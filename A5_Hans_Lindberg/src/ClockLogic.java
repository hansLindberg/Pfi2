
public class ClockLogic implements ClockInterface {

	private DigitalClockGUI clockGUI;
	private int alarmHour;
	private int alarmMinute;	
	
	public ClockLogic(DigitalClockGUI clockIn){
		this.clockGUI = clockIn;
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
		clockGUI.setTimeOnLabel(hours + ":" + minutes + ":" + seconds);
	}
}
