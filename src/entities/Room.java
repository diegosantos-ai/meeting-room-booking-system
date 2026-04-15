package entities;

public class Room {
    private String name;
    private int capacity;
    private boolean hasProjector;

    public Room(String name, int capacity, boolean hasProjector) {
        this.name = name;
        this.capacity = capacity;
        this.hasProjector = hasProjector;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean hasProjector() {
        return hasProjector;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | Capacidade: %d pessoas | Projetor: %s", 
                name, 
                capacity, 
                hasProjector ? "Sim" : "Não");
}


}
