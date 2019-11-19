package west;

import java.util.Random;

public class Sheriff extends Villain{

	public Sheriff(String name, String whiskey, String nick, int amo) {
		super(name, whiskey, nick, amo, 0);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	private int Shoot() {		
		if(this.getAmoCount()<=0) {
			System.out.println("No Amo!");
			return 0;
		}
		else {
			Random rand = new Random();
			return rand.nextInt(100+1-20)+20;
		}
	}	

}
