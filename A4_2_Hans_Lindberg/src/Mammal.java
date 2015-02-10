
public abstract class Mammal extends Animal {
	
	private int gestationTime;
	
	public Mammal(String latinName, int gestationTime){
		super (latinName);
		this.gestationTime = gestationTime;
		this.latinName = latinName;
	}
	public Mammal(String latinName){
		super (latinName);
	}
	
	public int getGestationTime(){
		return this.gestationTime;
	}
}
