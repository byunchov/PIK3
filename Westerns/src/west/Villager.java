package west;

public class Villager {

	private int legCount;
	private int armCount;
	private int eyeCount;
	private boolean brokenNose; //true - whole; false - blocen
	private String name;
	private boolean hasHorse;
	private String favWhiskey;
	
	public Villager(String name, String whiskey) {
		this.setName(name);
		this.setFavWhiskey(whiskey);
		this.setArmCount(2);
		this.setEyeCount(2);
		this.setLegCount(2);
		this.setHasHorse(true);
		this.setBrokenNose(false);
	}
	
	public int getLegCount() {
		return legCount;
	}
	public void setLegCount(int legCount) {
		this.legCount = legCount;
	}
	public int getArmCount() {
		return armCount;
	}
	public void setArmCount(int armCount) {
		this.armCount = armCount;
	}
	public int getEyeCount() {
		return eyeCount;
	}
	public void setEyeCount(int eyeCount) {
		this.eyeCount = eyeCount;
	}
	public boolean isBrokenNose() {
		return brokenNose;
	}
	public void setBrokenNose(boolean brokenNose) {
		this.brokenNose = brokenNose;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHasHorse() {
		return hasHorse;
	}
	public void setHasHorse(boolean hasHorse) {
		this.hasHorse = hasHorse;
	}
	public String getFavWhiskey() {
		return favWhiskey;
	}
	public void setFavWhiskey(String favWhiskey) {
		this.favWhiskey = favWhiskey;
	}
	
}
