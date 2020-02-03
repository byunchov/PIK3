package events;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ClientSocialEvents {

	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1", 8082);
        // System.out.println(">Connected!");                
        
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

		ObjectOutputStream outputData = new ObjectOutputStream(outputStream);
        ObjectInputStream incomingData = new ObjectInputStream(inputStream);

		Scanner userInput = new Scanner(System.in);
		Scanner choice = new Scanner(System.in);

        HashMap<String, String> criteria = new HashMap<String, String>();

		String city, date;
		Integer id = 0;
		int input;

		boolean run = true;

		do {
			System.out.println("[1] Show Events by City and Date.");
			System.out.println("[2] Enrol for event by ID.");
			System.out.println("[0] Exit");
			System.out.print("Your choice: ");		
			input = choice.nextInt();
			
			city = date = null;

			switch (input) {
				case 1:					
					System.out.print("Enter city name: ");
					city = userInput.nextLine();
					System.out.print("Enter date: ");
					date = userInput.nextLine();
									
					criteria.put("city", city);
					criteria.put("date", date);

					outputData.writeObject("list");					
					outputData.writeObject(criteria);
					
					ArrayList<Event> eventListByCriteria = (ArrayList<Event>) incomingData.readObject();
					eventListByCriteria.forEach((ev)-> ev.showEventData());			
					break;					
				case 2:
					System.out.print("Enter event ID: ");
					id = userInput.nextInt();
				    outputData.writeObject("enroll");
				    outputData.writeObject(id);
					break;					
				case 0:
					run = false;
					socket.close();
					break;
				}
		} while (run);        		
	}
}

class Event implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	int id;
	String city;
	String description;
	String date;
	int availableNumberOfParticipants;
	
	public Event(int id, String city, String description, String date, int availableNumberOfParticipants) {
		this.id = id;
		this.city = city;
		this.description = description;
		this.date = date;
		this.availableNumberOfParticipants = availableNumberOfParticipants;
	}
	
	public void showEventData() {
		System.out.println("\nEvent ID: " + id);
		System.out.println("Event City: " + city);
		System.out.println("Event Decription: " + description);
		System.out.println("Event Date: " + date);
		System.out.println("Event Participants: " + availableNumberOfParticipants);
	}
}
