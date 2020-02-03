package events;

import java.io.Serializable;

public class Event implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	int id;
	String city;
	String description;
	String date;
	int availableNumberOfParticipants;
	
	public Event(int id, String city, String description, String date, int availableNumberOfParticipants) {
		super();
		this.id = id;
		this.city = city;
		this.description = description;
		this.date = date;
		this.availableNumberOfParticipants = availableNumberOfParticipants;
	}
	
	public void showEventData() {
		System.out.println("Event ID: " + id);
		System.out.println("Event City: " + city);
		System.out.println("Event Decription: " + description);
		System.out.println("Event Date: " + date);
		System.out.println("Event Participants: " + availableNumberOfParticipants);
	}
}
