package org.martoni;

public class Word {
	
	private long id;
	
	private String english;
	private String hungarian;
	
	private int usage = 0;
	
	public Word() {	
	}
	
	public Word(String english, String hungarian) {
		super();
		this.english = english;
		this.hungarian = hungarian;
	}
	
	
	@Override
	public String toString() {
		return String.format("'%s' - '%s'", english, hungarian);
	}


	public String getEnglish() {
		return english;
	}


	public void setEnglish(String english) {
		this.english = english;
	}


	public String getHungarian() {
		return hungarian;
	}


	public void setHungarian(String hungarian) {
		this.hungarian = hungarian;
	}


	public int getUsage() {
		return usage;
	}


	public void setUsage(int usage) {
		this.usage = usage;
	}
	
	
}
