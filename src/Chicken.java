import java.util.ArrayList;

public class Chicken extends Creature {



    public Chicken(Graph.Node currentRoom){
        super(currentRoom, "placeholder chicken name","a generic chicken");
    }

    @Override
    public void move(){
        ArrayList<Graph.Node> neighbors = currentRoom.getNeighbors();
        int random = (int)(Math.random() * neighbors.size());
        currentRoom = currentRoom.getNeighbor(neighbors.get(random).getName());
    }
}
