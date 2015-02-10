
public class Snake extends Animal {
	
	private boolean poisonous;
	
	public Snake(String latinName, boolean poisonous){
		super (latinName);
		this.poisonous = poisonous;
		this.latinName = latinName;
	}
	
	public boolean isPoisonous(){
		return this.poisonous;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		
		String i = "";
		if (isPoisonous() == true){
			i = new String(" is posionous.");
		}
		else{
			i = new String(" is not poisonous.");
		}
		
		return "The snake " + getLatinName() + i;
	}
}
