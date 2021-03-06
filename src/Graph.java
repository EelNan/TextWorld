import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<String, Node> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    public void addNode(Node node) {
        nodes.put(node.getName(), node);
    }

    public void addNode(String name) {
        nodes.put(name, new Node(name));
    }

    public HashMap<String, Node> getNodes() {
        return nodes;
    }

    public void addUndirectedEdge(String name1, String name2) {
        Node node1 = getNode(name1);
        Node node2 = getNode(name2);
        if(!(node1 == null || node2 == null)) {
            node1.addNeighbor(node2);
            node2.addNeighbor(node1);
        }else{
            System.out.println("one of the nodes doesn't exist");
        }

    }

    public void addDirectedEdge(String name1, String name2) {
        Node node1 = getNode(name1);
        Node node2 = getNode(name2);
        if(!(node1 == null || node2 == null)) node1.addNeighbor(node2);
        else{
            System.out.println("one of the nodes doesn't exist");
        }
    }

    public Node getNode(String name) {

        return nodes.get(name);

    }

    public void changeNodeDesc(String name, String description){
        Node n = getNode(name);
        n.setDescription(description);
    }

    public class Node {

        private String name;
        private String description;
        private ArrayList<Node> neighbors;
        private ArrayList<Item> items;

        private Node(String name){
            this.name = name;
            neighbors = new ArrayList<>();
            items = new ArrayList<>();

        }
        private Node(String name, String description){
            this.name = name;
            neighbors = new ArrayList<>();
            this.description = description;
        }

        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        private void setDescription(String description) {
            this.description = description;
        }

        private void addNeighbor(Node n){
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

        public ArrayList<Node> getNeighbors() {
            return neighbors;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public String displayItems(){
            String output = "";
            for(Item i : items){
                output = output + " " + i.getName();
            }
            return output;
        }

        public void addItem(Item i){
            items.add(i);
        }

        public void addItem(String name){
            items.add(new Item(name, "placeholder"));
        }

        public void addItem(String name, String description){
            items.add(new Item(name, description));
        }

        public Item removeItem(String name){

            for(Item i : items){
                if(i.getName().equals(name)){
                    items.remove(i);
                    return i;
                }
            }
            return null;
        }

        public boolean destroyItem(String name){
            for(Item i : items){
                if(i.getName().equals(name))
                    return items.remove(i);
            }
            return false;
        }
    }
}
