import javax.xml.ws.Action;
import java.util.ArrayList;

public class Wumpus extends Creature {

    public Wumpus(String name, String description, Graph.Node currentRoom) {
        super(currentRoom, name, description);
    }

    public Wumpus(Graph.Node currentRoom){
        super(currentRoom, "generic wumpus name", "This is a generic wumpus");
    }


    @Override
    public void move(Graph.Node playerRoom) {

        for (Graph.Node j : currentRoom.getNeighbors()) {
            for (Graph.Node k : j.getNeighbors()) {
                if (k.equals(playerRoom) || j.equals(playerRoom)) {
                    randomMove(playerRoom, j);
                    return;
                }
            }
        }
        randomMove(playerRoom, null);
    }

    //moves randomly away from the player from a specific path, could work better
    private void randomMove(Graph.Node playerRoom, Graph.Node neighbor) {
        if (neighbor == null) return;

        try{
            ArrayList<Graph.Node> neighbors = (ArrayList<Graph.Node>) (currentRoom.getNeighbors().clone());

            neighbors.remove(playerRoom);
            neighbors.remove(neighbor);
            int random = (int) (Math.random() * neighbors.size());
            currentRoom = neighbors.get(random);
        }catch(Exception e){

        }



    }
}
