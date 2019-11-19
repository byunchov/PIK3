package west;

public class WesternTown {

	private String location;
	private int yearOfSettlement;
	private int barCount;
	private int sheriffCount;
	
	public WesternTown(String loc, int year, int nBars, int nSheriffs) {
		this.setLocation(loc);
		this.setBarCount(2);
		this.setYearOfSettlement(1850);
		this.setSheriffCount(1);
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getYearOfSettlement() {
		return yearOfSettlement;
	}
	public void setYearOfSettlement(int yearOfSettlement) {
		this.yearOfSettlement = yearOfSettlement;
	}
	public int getBarCount() {
		return barCount;
	}
	public void setBarCount(int barCount) {
		this.barCount = barCount;
	}
	public int getSheriffCount() {
		return sheriffCount;
	}
	public void setSheriffCount(int sheriffCount) {
		this.sheriffCount = sheriffCount;
	}
	
}
