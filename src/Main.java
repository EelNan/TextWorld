import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //build up a graph of connected nodes
        Node root = new Node("hall");
        addEdge(root, new Node("closet"));
        addEdge(root, new Node("bedroom"));
        addEdge(root.getNeighbor("bedroom"), new Node("secret dungeon"));


        //"game loop" where I get user input and move the player.

        Node current = root;


        Scanner userInput = new Scanner(System.in);
        String response = "";

        do{
            //display the room and the exits
            System.out.println("you are currently in the " + current.getName());
            System.out.println("you can go to: " + current.getNeighborNames());

            //ask the player what type of action they want to take
            System.out.println("You can \"talk\" or \"move\"");
            response = userInput.nextLine();
            if(response.equals("talk")){
                TalkToPeople(userInput.nextLine());
            }
            if(response.equals("move")){
                System.out.println("Where do you want to go?");
                response = userInput.nextLine();
                Node nextRoom = current.getNeighbor(response);
                if(nextRoom == null){
                    System.out.println("you can't go to " + response + "try again");
                }else{
                    current = nextRoom;
                }
            }

        }while(!response.equalsIgnoreCase("quit"));
    }

    private static void TalkToPeople(String nextLine) {
        //currently a placeholder method
    }

    public static void addEdge(Node first, Node next){
        first.addNeighbor(next);
        next.addNeighbor(first);
    }
}
