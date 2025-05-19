import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;
public class GoKartApp
{
    public static void main(String args[]) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");

        LinkList List = new LinkList();

        File file = new File("C:\\Users\\DANISH\\Documents\\GitHub\\Go-Kart-Registration-Java\\goKart.txt");
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
                List.insertAtBack(g);
            }
        }
        catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        //display data
        System.out.println("GOKART DATA");
        System.out.println(String.format("|%-11s|%-25s|%-11s|%-15s|%-25s","NAME","CAR TYPE","STROKE ENGINE","NUMBER OF LAPS","SAFETY SET"));
        System.out.println("==================================================================================");
        GoKart g = (GoKart) List.getFirst();
        while(g != null) {
            System.out.println(g.toString());
            g = (GoKart) List.getNext();
        }
        System.out.println("==================================================================================\n");

        //Answer (i) : insert new node at front
        System.out.println("\nxxxxxxxxxxxx ANSWER (i) xxxxxxxxxxxx\n");
        GoKart t = new GoKart("Sara", "Single", "150cc", 1, 5, true);
        List.insertAtFront(t);

        int frontCount=0;

        System.out.println("GOKART DATA AFTER INSERT NEW NODE AT THE FRONT");
        System.out.println(String.format("|%-11s|%-25s|%-11s|%-15s|%-25s","NAME","CAR TYPE","STROKE ENGINE","NUMBER OF LAPS","SAFETY SET"));
        System.out.println("==================================================================================");
        g = (GoKart) List.getFirst();
        while(g != null) {
            frontCount++;
            System.out.println(g.toString());
            g = (GoKart) List.getNext();
        }
        System.out.println("==================================================================================\n");
        System.out.println("Total Data After Insert At The Front: "+frontCount);

        //Answer (ii) : insert new node at back
        System.out.println("\nxxxxxxxxxxxx ANSWER (ii) xxxxxxxxxxxx");
        GoKart b = new GoKart("Ikmal", "Single", "250cc", 2, 13, true);
        List.insertAtBack(b);

        System.out.println("\nGOKART DATA AFTER INSERT NEW NODE AT THE BACK");
        System.out.println(String.format("|%-11s|%-25s|%-11s|%-15s|%-25s","NAME","CAR TYPE","STROKE ENGINE","NUMBER OF LAPS","SAFETY SET"));
        System.out.println("==================================================================================");
        int backCount = 0;
        g = (GoKart) List.getFirst();
        while(g != null) {
            backCount++;
            System.out.println(g.toString());
            g = (GoKart) List.getNext();
        }
        System.out.println("==================================================================================\n");
        System.out.println("Total Data After Insert At The Back: "+backCount);
        //Answer (iii) : insert at second
        System.out.println("\nxxxxxxxxxxxx ANSWER (iii) xxxxxxxxxxxx");
        GoKart k = new GoKart("Pojan", "Couple", "150cc", 1, 3, false);
        List.insertAtSecond(k);
        System.out.println("\nGOKART DATA AFTER INSERT NEW NODE AT THE SECOND");
        System.out.println(String.format("|%-11s|%-25s|%-11s|%-15s|%-25s","NAME","CAR TYPE","STROKE ENGINE","NUMBER OF LAPS","SAFETY SET"));
        System.out.println("==================================================================================");
        int secondCount = 0;
        g = (GoKart) List.getFirst();
        while(g != null) {
            secondCount++;
            System.out.println(g.toString());
            g = (GoKart) List.getNext();
        }
        System.out.println("==================================================================================\n");
        System.out.println("Total Data After Insert At Second: "+secondCount);
        //Answer (iv) : insert at everywhere
        System.out.println("\nxxxxxxxxxxxx ANSWER (iv) xxxxxxxxxxxx");
        GoKart h = new GoKart("Marilyn", "Couple", "250cc", 2, 5, true);
        List.insertAtPosition(h, 4);       
        System.out.println("\nGOKART DATA AFTER INSERT NEW NODE AT ANY NODE");
        System.out.println(String.format("|%-11s|%-25s|%-11s|%-15s|%-25s","NAME","CAR TYPE","STROKE ENGINE","NUMBER OF LAPS","SAFETY SET"));
        System.out.println("==================================================================================");
        int anyCount = 0;
        g = (GoKart) List.getFirst();
        while(g != null) {
            anyCount++;
            System.out.println(g.toString());
            g = (GoKart) List.getNext();
        }
        System.out.println("==================================================================================\n");
        System.out.println("Total Data After Insert At Any Nodes: "+anyCount);
        //Answer (v) : count nodes and display
        System.out.println("\nxxxxxxxxxxxx ANSWER (v) xxxxxxxxxxxx");
        g = (GoKart) List.getFirst();
        int lastCount = 0;
        System.out.println("\nTOTAL LIST OF DATA: ");
        System.out.println(String.format("|%-11s|%-25s|%-11s|%-15s|%-25s","NAME","CAR TYPE","STROKE ENGINE","NUMBER OF LAPS","SAFETY SET"));
        System.out.println("==================================================================================");
        while(g != null) {
            lastCount++;
            System.out.println(g.toString());
            g = (GoKart) List.getNext();
        }
        System.out.println("==================================================================================");
        System.out.println("\nTotal Data Now Is: "+lastCount);

        //Answer (vi)
        System.out.println("\nxxxxxxxxxxxx ANSWER (vi) xxxxxxxxxxxx\n");
        if(List == null)
        {
            System.out.println("Data is invalid");
        }
        else
        {
            System.out.println("Data is found");
        }
        //Answer (vii) : searching and remove data
        System.out.println("\nxxxxxxxxxxxx ANSWER (vii) xxxxxxxxxxxx");
        System.out.println("\nSearch Name and Remove Data? [Y/N]: ");
        char choice = scan.next().charAt(0);
        g = (GoKart) List.getFirst();

        while (choice == 'Y') {
            System.out.println("\nEnter the name of the GoKart to search and remove: ");
            String nameSearch = scan.next();
            if(List.searchAndRemoveGoKart(nameSearch))
            {
                g = (GoKart) List.getFirst();
                System.out.println(String.format("\n|%-11s|%-25s|%-11s|%-15s|%-25s","NAME","CAR TYPE","STROKE ENGINE","NUMBER OF LAPS","SAFETY SET"));
                System.out.println("==================================================================================");
                while(g != null)
                {
                    System.out.println(g.toString());
                    g = (GoKart) List.getNext();
                }
                System.out.println("==================================================================================\n");
                System.out.println("\nSearch Another Name and Remove Data? [Y/N]: ");
                choice = scan.next().charAt(0);
            }
            else
            {
                System.out.println("\nSearch Another Name and Delete Data? [Y/N]");
                choice = scan.next().charAt(0);
            }
        }
        //Answer (viii) : search and update data
        System.out.println("\nxxxxxxxxxxxx ANSWER (viii) xxxxxxxxxxxx");
        System.out.println("\nSearch Name and Update Data? [Y/N]: ");
        choice = scan.next().charAt(0);
        while (choice == 'Y') {
            System.out.println("\nEnter the name of the GoKart to search and update: ");
            String nameSearch = scan.next();

            if(List.searchAndUpdateGoKart(nameSearch))
            {
                g = (GoKart) List.getFirst();
                while(g != null)
                {
                    System.out.println(g.toString());
                    g = (GoKart) List.getNext();
                }
                System.out.println("==================================================================================\n");
                System.out.println("\nSearch Another Name and Update Data? [Y/N]");
                choice = scan.next().charAt(0);
            }
            else
            {
                System.out.println("\nSearch Another Name and Update Data? [Y/N]");
                choice = scan.next().charAt(0);
            }
        }
        g = (GoKart) List.getFirst();
        int totalCount = 0;
        System.out.println("\nTOTAL LIST OF DATA: ");
        System.out.println(String.format("|%-11s|%-25s|%-11s|%-15s|%-25s","NAME","CAR TYPE","STROKE ENGINE","NUMBER OF LAPS","SAFETY SET"));
        System.out.println("==================================================================================");
        while(g != null) {
            totalCount++;
            System.out.println(g.toString());
            g = (GoKart) List.getNext();
        }
        System.out.println("==================================================================================");
        System.out.println("\nTotal Data Now Is: "+totalCount);
    }
}
