package west;

import java.util.Random;

public class Villain extends Villager{

	private boolean hasRevoler;
	private int amoCount;
	private String nickName;
	private double headPrize;
	
	public Villain(String name, String whiskey, String nick , int amo, double prize) {
		super(name, whiskey);
		this.setBrokenNose(true);
		this.setHasRevoler(true);
		this.setAmoCount(amo);
		this.setHeadPrize(prize);
		this.setNickName(nick);
	}

	public boolean isHasRevoler() {
		return hasRevoler;
	}

	public void setHasRevoler(boolean hasRevoler) {
		this.hasRevoler = hasRevoler;
	}

	public int getAmoCount() {
		return amoCount;
	}

	public void setAmoCount(int amoCount) {
		this.amoCount = amoCount;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public double getHeadPrize() {
		return headPrize;
	}

	public void setHeadPrize(double headPrize) {
		this.headPrize = headPrize;
	}
	
	private int Shoot() {
		if(amoCount<=0) {
			System.out.println("No Amo!");
			return 0;
		}
		else {
			Random rand = new Random();
			return rand.nextInt(100);
		}
	}	
	
	public static void Skrmish(Villain vil1, Villain vil2) {
		int shooter1, shooter2;
		
		int amoShooter1 = vil1.getAmoCount(), amoShooter2 = vil2.getAmoCount();
		
		while(true) {			
			shooter1 = vil1.Shoot();
			shooter2 = vil2.Shoot();
			
			if(shooter1>=70 && shooter2<70 && amoShooter1>0) {
				System.out.format("%s (%s) won against %s. He got %d over his opponent - %d\n", vil1.getName(), vil1.getNickName(), vil2.getName(), shooter1, shooter2);
				break;
			}
			else if (shooter2>=70 && shooter1<70 && amoShooter2>0) {
				System.out.format("%s (%s) won against %s. He got %d over his opponent - %d\n", vil2.getName(), vil2.getNickName(), vil1.getName(), shooter2, shooter1);
				break;
			}
			else {
				System.out.format("Villain1 [%d], Villain2 [%d]\n", shooter1, shooter2);
			}
			
			if(amoShooter1==0 && amoShooter2==0)
			{
				System.out.println("Noone won the duel!");
			}
			amoShooter1--;
			amoShooter2--;			
		}
		
	}
}
 