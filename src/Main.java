import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //build up a graph of connected nodes
        Graph world = new Graph();
        world.addNode("hall");
        world.addNode("closet");
        world.addNode("bedroom");
        world.addNode("secret dungeon");
        world.addUndirectedEdge("hall", "closet");
        world.addUndirectedEdge("hall", "bedroom");
        world.addUndirectedEdge("bedroom", "secret dungeon");
        world.addUndirectedEdge("secret dungeon", "hall");

        //add items to certain rooms
        world.getNode("closet").addItem("coat");
        world.getNode("bedroom").addItem("key");

        //add the creatures to the world
        ArrayList<Creature> creatures = new ArrayList<>(); //add saving into nodes?
        makeCreatures(creatures, world, 10, 10);

        //"game loop" where I get user input and move the player.

        Scanner userInput = new Scanner(System.in);
        String response = "";

        Player player = createNewPlayer(userInput);
        player.setCurrentRoom(world.getNode("hall"));

        do {
            //display the room and the exits
            System.out.println("you are currently in the " + player.getCurrentRoom().getName());
            System.out.println("you can go to: " + player.getCurrentRoom().getNeighborNames());

            //ask the player what type of action they want to take
            System.out.println("You can talk, move, or look\n\nWhat do you want to do?");
            response = userInput.nextLine();
            String words[] = response.split(" ");
            String firstWord = words[0];

            if (words[0].equals("talk")) {
                TalkToPeople(userInput.nextLine());
            }
            if (response.equals("move")) {
                System.out.println("Where do you want to go?");
                response = userInput.nextLine();

                if (!player.moveToRoom(response)) {
                    System.out.println("you can't go to " + response + "try again");
                }
            }
            if (response.equals("look")) {

                System.out.println(player.getCurrentRoom().getDescription());

                if (player.getCurrentRoom().getItems().size() > 0) {
                    System.out.println("There are" + player.getCurrentRoom().displayItems() + " in this room");
                } else System.out.println("There are no items in this room");

                String chickensWithPlayer = getCreaturesInRoom(player.getCurrentRoom(), creatures);

                if (chickensWithPlayer.length() > 0) {
                    System.out.println("You see" + getCreaturesInRoom(player.getCurrentRoom(), creatures) + " in the room");
                }
            }
            if (words[0].equals("drop")) {
                drop(words, player);
            }
            if (words[0].equals("take")) {
                take(words, player);
            }
            if (words[0].equals("look") && !response.equals("look")) {        //add specific things player can look at, like self, items, room, etc
            }


            if (response.equals("cheese")) {
                System.out.println("You are now a god. woohoo");
            }
            //make everything else in the world do what they do
            creaturesAct(creatures, player);

        } while (!response.equalsIgnoreCase("quit"));
    }

    private static void makeCreatures(ArrayList<Creature> creatures, Graph world, int chickenCount, int wumpusCount) {
        for (int i = 0; i < chickenCount; i++) {
            ArrayList<Graph.Node> allRooms = new ArrayList<Graph.Node> (world.getNodes().values());
            int random = (int) (Math.random() * allRooms.size());
            Graph.Node randomRoom = allRooms.get(random);
            creatures.add(new Chicken(randomRoom));
        }
        for (int i = 0; i < wumpusCount; i++) {
            ArrayList<Graph.Node> allRooms = new ArrayList<Graph.Node> (world.getNodes().values());
            int random = (int) (Math.random() * allRooms.size());
            Graph.Node randomRoom = allRooms.get(random);
            creatures.add(new Wumpus(randomRoom));
        }
    }

    private static String getCreaturesInRoom(Graph.Node room, ArrayList<Creature> creatures) {
        String output = "";
        for (Creature c : creatures) {

            if (c.getCurrentRoom().equals(room))
                output = output + " " + c.getName();

        }
        return output;
    }

    private static void creaturesAct(ArrayList<Creature> creatures, Player player) {
        for (Creature c : creatures) {
            c.move(player.getCurrentRoom());
            //add movement detection information
        }
    }


    private static Player createNewPlayer(Scanner userInput) {
        String response = "";
        String name, description;
        do {
            System.out.println("What is your name?");
            name = userInput.nextLine();
            System.out.println("Describe yourself");
            description = userInput.nextLine();
            System.out.println("So you are " + name + ", and you consider yourself to be \"" + description + "\" Is this correct?");
            response = userInput.nextLine();
        } while (!response.equals("yes"));

        return new Player(name, description);

    }

    private static void TalkToPeople(String nextLine) {
        //currently a placeholder method for interplayer communication
    }

    private static void take(String[] words, Player player) {
        if (words.length <= 1) System.out.println("You can't take nothing");

        String name = words[1];
        Graph.Node currentRoom = player.getCurrentRoom();
        for (Item i : currentRoom.getItems()) {
            if (i.getName().equals(name)) {
                player.addItem(currentRoom.removeItem(name));
                return;
            }
        }
        System.out.println("That item is not in the current room");

    }

    private static void drop(String[] words, Player player) {
        if (words.length <= 1) System.out.println("You can't drop nothing");

        String name = words[1];
        Graph.Node currentRoom = player.getCurrentRoom();
        Item i = player.getItem(name);
        if (i == null) {
            System.out.println("You don't have that item.");
            return;
        }
        currentRoom.addItem(player.removeItem(name));
        System.out.println("You dropped a " + name);

    }

    private static void go(String[] words, Player player) {
        // attempt to move the player to desired location
    }

}
