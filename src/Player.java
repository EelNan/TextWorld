import java.util.ArrayList;

public class Player {

    private String name, description;
    private ArrayList<Item> items;
    private Graph.Node currentRoom;

    public Player(String name, String description){
        this.name = name;
        this.description = description;
        items = new ArrayList<>();

    }

    public void addItem(Item item){
        items.add(item);
    }

    public void addItem(String name){
        items.add(new Item(name, "placeholder description"));
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

    public void destroyItem(String name){
        removeItem(name);
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public Item getItem(String name){
        for(Item i : items){
            if(i.getName().equals(name)) return i;
        }
        return null;
    }

    public void displayInventory(){
        String output = "";
        for(Item i : items){
            output = output + " " + i.getName();
        }
        System.out.println(output);
    }

    public Graph.Node getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Graph.Node currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean moveToRoom(String name){
        Graph.Node nextRoom = currentRoom.getNeighbor(name);
        if(nextRoom == null) return false;
        setCurrentRoom(nextRoom);
        return true;
    }
}
