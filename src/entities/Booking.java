package entities;

public class Booking {
    private String employeeName;
    private Room room;
    private String shift;

    public Booking(String employeeName, Room room, String shift) {
        this.employeeName = employeeName;
        this.room = room;
        this.shift = shift;
    }
    
    public String getEmployeeName() {
        return employeeName;
    }
    
    public Room getRoom() {
        return room;
    }

    public String getShift() {
        return shift;
    }

    @Override
    public String toString() {
        return String.format("Funcionário: %s | Sala: %s | Turno: %s", 
                employeeName, 
                room.getName(), 
                shift); 

    }
}
