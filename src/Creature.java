public abstract class Creature {

    protected Graph.Node currentRoom;
    protected String name, description;

    public Graph.Node getCurrentRoom() {
        return currentRoom;
    }

    public String getName() {
        return name;
    }

    public Creature(Graph.Node currentRoom, String name, String description) {
        this.currentRoom = currentRoom;
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCurrentRoom(Graph.Node currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void move(Graph.Node playerRoom);
}
