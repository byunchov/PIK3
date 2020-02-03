package events;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(8082);
		
		ArrayList<Event> listOfEvents = populateEventList();
		
		Service service;
		Socket client;
		
		while (true) {
			try {
				client = server.accept();
				System.out.println("Connection from "+ client.getInetAddress() + " on port " + client.getPort());
				service = new Service(client, listOfEvents);
				service.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<Event> populateEventList() {
		
		ArrayList<Event> list = new ArrayList<Event>();
		
		Event ev1 = new Event(1, "Bansko", "Bla bla", "22.02.2020", 100);
		Event ev2 = new Event(2, "Razlog", "Bla bla bla dga", "14.02.2020", 100);
		Event ev3 = new Event(3, "Bansko", "Bla bla bla", "10.02.2020", 100);
		Event ev4 = new Event(4, "Bansko", "Bla blaidqwdldl", "22.02.2020", 20);
		Event ev5 = new Event(5, "Sofia", "Bla bla na", "22.02.2020", 200);
		
		list.add(ev1);
		list.add(ev2);
		list.add(ev3);
		list.add(ev4);
		list.add(ev5);
		
		return list;
	}

}
