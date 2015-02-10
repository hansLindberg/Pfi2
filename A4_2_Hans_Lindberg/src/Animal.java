
public abstract class Animal {
	
	String latinName;
	String friendlyName;
	
	
	Animal(String latinName){
		
	}
	
	public abstract String getInfo();
	
	public void setFriendlyName(String name){
		this.friendlyName = name;
	}
	public String getFriendlyName(){
		String i = "";
		if(friendlyName == null){
			i = "has no friendly name";
		}
		else{
			i = this.friendlyName;
		}
		return i;
	}
	
	public void setLatinName(String name){
		this.latinName = name;
	}
	public String getLatinName(){
		return this.latinName;
	}
}
