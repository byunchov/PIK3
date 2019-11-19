package west;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Villain Billy = new Villain("Billy", "J&B", "Billy The Kid", 10, 102.3);
		Villain John = new Villain("John", "Jack Daniels", "Chill Johnny", 6, 206.55);
//		Sheriff Dan = new Sheriff("Dan", "Jaack", "Stincky Dan", 12);
		
		Villain.Skrmish(Billy, John);		
//		Villain.Skrmish(Dan, Billy);
	}

}
