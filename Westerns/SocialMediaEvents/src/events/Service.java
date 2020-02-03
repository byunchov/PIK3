package events;
//package events;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Service extends Thread {
	Socket client;
	ArrayList<Event> listOfEvents;

	public Service(Socket client, ArrayList<Event> listOfEvents) {
		this.client = client;
		this.listOfEvents = listOfEvents;
	}
	
	public void run() {	
		
		ObjectOutputStream outputData = null;
		ObjectInputStream clientInput = null;
		try {
			outputData = new ObjectOutputStream(client.getOutputStream());
			clientInput = new ObjectInputStream(client.getInputStream());
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		
//		Scanner clientInput = null;
//		PrintStream outputData = null;
//		try {
//			clientInput = new Scanner(client.getInputStream());
//			outputData = new PrintStream(client.getOutputStream());
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		
//		String request = clientInput.nextLine();
		String request = null;
		try {
			request = (String) clientInput.readObject();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		if(request.equals("list")) {
			System.out.println("Recieved 'list'");
			try {
				showAllEvents(outputData, clientInput);
			} catch (ClassNotFoundException eClass) {
				eClass.printStackTrace();
			} catch (IOException eIO) {
				eIO.printStackTrace();
			}
		}
		else if (request.equals("enroll")) {
			System.out.println("Recieved 'enroll'");
			int id = 0;
			try {
				id = (int) clientInput.readObject();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				addNewParticipant(id);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				outputData.writeObject("Invalid input");
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Recieved 'else'");
		}
	}
	
	// shows all events by given city and date
	@SuppressWarnings("unchecked")
	public void showAllEvents(ObjectOutputStream outputEvents, ObjectInputStream clientInput) throws IOException, ClassNotFoundException {
//		OutputStream outputStream = client.getOutputStream();
//        InputStream inputStream = client.getInputStream();
//		
//		ObjectOutputStream outputEvents = new ObjectOutputStream(outputStream);
//		ObjectInputStream clientInput = new ObjectInputStream(inputStream);
		
		HashMap<String, String> criteria;
		ArrayList<Event> listByCritera = new ArrayList<Event>();
		
		criteria = (HashMap<String, String>) clientInput.readObject();
		if(!criteria.isEmpty()) {
			String city = criteria.get("city");
			String date = criteria.get("date");
			
			for (Event event : listOfEvents) {
				if(event.city.equals(city) && event.date.equals(date)) {
					listByCritera.add(event);
				}
			}
			
			if(!listByCritera.isEmpty()) {
				outputEvents.writeObject(listByCritera);
			}
		}		
	}
	
	public void addNewParticipant(int id) throws IOException {
		Event event;
		PrintStream outputData = new PrintStream(client.getOutputStream());
		
		for (int i = 0; i < listOfEvents.size(); i++) {
			event = listOfEvents.get(i); 
			if(event.id == id) {
				if (event.availableNumberOfParticipants >= 0) {
					-- event.availableNumberOfParticipants;
					outputData.println("You were successfully signed for the event!");
				}				
			}			
		}
	}

}
