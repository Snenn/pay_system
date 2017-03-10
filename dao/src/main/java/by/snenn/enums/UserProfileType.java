package by.snenn.enums;

public enum UserProfileType {
	ADMIN("ADMIN"),
	USER("USER");

	String type;
	
	UserProfileType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}


	@Override
	public String toString(){
		return this.type;
	}

	public String getName(){
		return this.name();
	}
}
