
public class Dog extends Mammal {
	
	private boolean stupid;
	
	public Dog(String latinName, boolean stupid, int gestationTime){
		super (latinName, gestationTime);
		this.latinName = latinName;
		this.stupid = stupid;
	}
	
	public Dog(String friendlyName, String latinName, boolean stupid){
		super (latinName);
		this.friendlyName = friendlyName;
		this.latinName = latinName;
		this.stupid = stupid;
	}
	
	public boolean isStupid(){
		return this.stupid;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		
		String i = "";
		if (isStupid() == true){
			i = new String(" is stupid.");
		}
		else{
			i = new String(" is not stupid.");
		}

		if(getLatinName() != null){
			return "The dog " + getFriendlyName() + " lat: " + getLatinName() + 
				" gestation: " + getGestationTime() + i;
		}
		else{
			return "The dog " + getFriendlyName() + 
					" gestation: " + getGestationTime() + i;
		}
	}
}
