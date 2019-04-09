public class Wumpus extends Creature {

    public Wumpus(String name, String description, Graph.Node currentRoom) {
        super(currentRoom, name, description);
    }


    @Override
    public void move(Graph.Node next, Graph.Node playerRoom) {

        for(Graph.Node j : currentRoom.getNeighbors()){
            for(Graph.Node k : j.getNeighbors()){
                if(k.equals(playerRoom)){

                }
            }
        }
    }
}
