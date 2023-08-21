
public class Room {	
	int idRoom;
	int sizeSquaredMeters;
	boolean privateBathroom; 
	String bedType;
	String serviceType;
	boolean disponible;
	
	
	public Room(int idRoom, int sizeSquaredMeters, boolean privateBathroom, String bedType, String serviceType, boolean disponible) {
		this.idRoom = idRoom;
		this.sizeSquaredMeters = sizeSquaredMeters;
		this.privateBathroom = privateBathroom;
		this.bedType = bedType;
		this.serviceType = serviceType;
		this.disponible = disponible;
	}
}


