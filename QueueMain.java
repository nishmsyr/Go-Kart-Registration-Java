import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;
public class QueueMain
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        //declare object queue from class Queue
        Queue queue = new Queue();

        File file = new File("C:\\\\Users\\\\DANISH\\\\Documents\\\\GitHub\\\\Go-Kart-Registration-Java\\\\goKart.txt");
        Scanner scanFile = new Scanner(file);

        try (BufferedReader in = new BufferedReader(new FileReader(file))) 
        {
            while (scanFile.hasNext())
            {
                String indata = scanFile.nextLine();
                StringTokenizer st = new StringTokenizer(indata,";");

                String name = st.nextToken();
                String typeOfCar = st.nextToken();
                String strokeEngine = st.nextToken();
                int option = Integer.parseInt(st.nextToken());
                int numberOfLaps = Integer.parseInt(st.nextToken());
                boolean safetySet = Boolean.parseBoolean(st.nextToken());

                GoKart g = new GoKart(name, typeOfCar, strokeEngine, option, numberOfLaps, safetySet);
                queue.insertAtBack(g);
            }
        }
        catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        System.out.println("DATA LIST BEFORE QUEUE: \n");
        //get data at the front
        GoKart g = (GoKart) queue.getFront();
        while(g != null)
        {
            //display list
            System.out.println(g.toString());
            g = (GoKart) queue.getNext();
        }
        // Add Go//display data after enqueue
        //ANSWER (i)
        //asign data
        GoKart g1 = new GoKart("Syakir", "Double", "200cc", 2, 4, true);
        GoKart g2 = new GoKart("Fauzi", "Single", "150cc", 1, 5, true);
        GoKart g3 = new GoKart("Zane", "Double", "250cc", 1, 3, true);

        // Enqueue objects
        queue.enqueue(g1);
        queue.enqueue(g2);
        queue.enqueue(g3);
        
        System.out.println("\nxxxxxxxxxxxx ANSWER (i) xxxxxxxxxxxx");
        System.out.println("\nDATA AFTER ENQUEUE OPERATION: \n");
        //get data at the front
        g = (GoKart) queue.getFront();
        while(g != null)
        {
            //display data list
            System.out.println(g.toString());
            g = (GoKart) queue.getNext();
        }
        
        //ANSWER (ii)
        //dequeue
        System.out.println("\nxxxxxxxxxxxx ANSWER (ii) xxxxxxxxxxxx");
        System.out.println("\nDEQUEUE OPERATION \n");
        //assign dequeue into object removedGoKart
        GoKart removedGoKart = queue.dequeue();
        //display data remove
        System.out.println("Remove : " + removedGoKart);

        //dequeue operation
        System.out.println("\nQUEUE AFTER DEQUEUE OPERATION: \n");
        //get data at the front
        g = (GoKart) queue.getFront();
        while(g != null)
        {
            System.out.println(g.toString());
            g = (GoKart) queue.getNext();
        }
        //ANSWER (iii)
        //check queue size
        System.out.println("\nxxxxxxxxxxxx ANSWER (iii) xxxxxxxxxxxx");
        System.out.println("\nQUEUE SIZE : "+ queue.getSize());

        //ANSWER (iv)
        //if queue empty
        System.out.println("\nxxxxxxxxxxxx ANSWER (iv) xxxxxxxxxxxx");
        System.out.println("\nQUEUE EMPTY?: " + queue.isEmpty());

        System.out.println("\nFINAL DATA LIST: ");
        GoKart k = queue.getEnd();
        while(!queue.isEmpty())
        {
            //display final data list
            System.out.println(queue.dequeue());
        }
    }
}
