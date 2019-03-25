import java.util.ArrayList;

public class Node {

    private String name;
    private ArrayList<Node> neighbors;

    public Node(String name){
        this.name = name;
        neighbors = new ArrayList<>();

    }

    public String getName() {
        return name;
    }


    public void addNeighbor(Node n){
        neighbors.add(n);
    }

    public Node getNeighbor(String name){
        for (Node n : neighbors) {
            if(n.getName().equalsIgnoreCase(name)) return n;
        }

        return null;
    }

    public String getNeighborNames(){
        String output = "";

        for (Node n : neighbors){
            output += n.getName() + " ";
        }
        return output;
    }
}
