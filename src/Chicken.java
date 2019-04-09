import java.util.ArrayList;

public class Chicken extends Creature {



    public Chicken(Graph.Node currentRoom){
        super(currentRoom, "placeholder chicken name","a generic chicken");
    }


    public void move(){
        ArrayList<Graph.Node> neighbors = currentRoom.getNeighbors();
        int random = (int)(Math.random() * neighbors.size());
        move(currentRoom.getNeighbor(neighbors.get(random).getName()));
    }

    @Override
    public void move(Graph.Node next, Graph.Node playerRoom) {
        move(next);
    }
}
