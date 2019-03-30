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

        //"game loop" where I get user input and move the player.

        Graph.Node current = world.getNode("hall");


        Scanner userInput = new Scanner(System.in);
        String response = "";

        do{
            //display the room and the exits
            System.out.println("you are currently in the " + current.getName());
            System.out.println("you can go to: " + current.getNeighborNames());

            //ask the player what type of action they want to take
            System.out.println("You can talk, move, or look");
            response = userInput.nextLine();
            String words[] = response.split(" ");
            String firstWord = words[0];

            if(words[0].equals("talk")){
                TalkToPeople(userInput.nextLine());
            }
            if(response.equals("move")){
                System.out.println("Where do you want to go?");
                response = userInput.nextLine();
                Graph.Node nextRoom = current.getNeighbor(response);
                if(nextRoom == null){
                    System.out.println("you can't go to " + response + "try again");
                }else{
                    current = nextRoom;
                }
            }
            if(words[0].equals("look")){
                System.out.println(current.getDescription());
            }

        }while(!response.equalsIgnoreCase("quit"));
    }

    private static void TalkToPeople(String nextLine) {
        //currently a placeholder method
    }

}
