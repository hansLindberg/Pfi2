
public class Cat extends Mammal {
	
	private int numberOfLives;
	
	public Cat (String latinName, int numberOfLives, int gestationTime){
		super (latinName, gestationTime);
		this.numberOfLives = numberOfLives;
		this.latinName = latinName;
	}
	
	public void setNumberOfLives(int i){
		this.numberOfLives = i;
	}
	public int getNumberOfLives(){
		return this.numberOfLives;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "The cat " + getLatinName() + " has " + getNumberOfLives() + " lives.";
	}
}
