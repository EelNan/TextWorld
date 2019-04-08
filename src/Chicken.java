import java.util.ArrayList;

public class Chicken extends Creature {

    public Chicken(String name, String description, Graph.Node currentRoom) {
        this.name = name;
        this.description = description;
        this.currentRoom = currentRoom;
    }

    public Chicken(Graph.Node currentRoom){
        this.name = "placeholder chicken name";
        this.description = "a generic chicken";
        this.currentRoom = currentRoom;
    }

    @Override
    public void move(){
        ArrayList<Graph.Node> neighbors = currentRoom.getNeighbors();
        int random = (int)(Math.random() * neighbors.size());
        currentRoom = currentRoom.getNeighbor(neighbors.get(random).getName());
    }
}
