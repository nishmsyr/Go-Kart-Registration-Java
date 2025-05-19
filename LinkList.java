import java.util.Scanner;
public class LinkList {
    private Node head;
    private Node current;
    private Node tail;

    //LinkList constructor(default)
    public LinkList()
    {
        head = null;
        current = null;
        tail = null;
    }
    //boolean method if the data is empty
    public boolean isEmpty()
    {
        return(head==null);
    }
    //method for insert data at the front
    public void insertAtFront(GoKart g) {
        Node newNode = new Node(g);
        if(isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
    }
    //method for insert data at the back
    public void insertAtBack(GoKart g) {
        Node newNode = new Node(g);
        if(isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }
    //method for insert data at the second
    public void insertAtSecond(GoKart g) {
        if (isEmpty()) {
            insertAtFront(g);
        } else {
            Node newNode = new Node(g);
            newNode.next = head.next;
            head.next = newNode;
        }
    }
    //method for insert data at everywhere
    public Node insertAtPosition(GoKart g, int pos)
    {
        Node newNode = new Node(g);
        if(pos<1)
        {
            System.out.println("Invalid position");
            return null;
        }
        Node ptr = head;
        if(pos == 1)
        {
            newNode.next = head;
            head = newNode;
            return newNode;
        }
        int index = 1;
        while(ptr != null && index < pos -1)
        {
            ptr = ptr.next;
            index++;
        }
        if(ptr == null)
        {
            System.out.println("Position exceeds the list length");
            return null;
        }
        newNode.next = ptr.next;
        ptr.next = newNode;
        return newNode;
    }
    //remove data from any nodes
    public void removeFromPosition(int pos)
    {
        if(head == null)
        {
            return;
        }
        current = head;
        if(pos<0)
        {
            return;
        }
        if(pos==0)
        {
            head = current.next;
            return;
        }
        for(int i=0;current != null && i < pos - 1; i++)
        {
            current = current.next;
        }
        if(current==null || current.next==null)
        {
            return;
        }
        Node newNode = current.next.next;
        current.next = newNode;
    }
    //remove data from front
    public GoKart removeFromFront()    {
        GoKart removeData = null;        
        if(isEmpty())
        {            
            return removeData;
        }        
        removeData = head.data;
        if(head == tail)      
        {
            head = null;  
            tail = null;
        }        else
        { 
            head = head.next;
        }        
        return removeData;
    }
    //remove data from back
    public GoKart removeFromBack()    {
        GoKart removeData = null;        
        if(isEmpty())
        {            
            return removeData;
        }       
        removeData = tail.data;
        if(head == tail)        
        {
            head = null;            
            tail = null;
        }        
        else
        {            
            current = head;
            while(current.next != tail)            
            {
                current = current.next;            
            }
            tail = current;            
            tail.next = null;
        }        
        return removeData;
    }
    // method to get first data
    public GoKart getFirst() 
    {
        if (isEmpty())
        {
            return null;
        }
        else
        {
            current = head;
            return current.data;
        }
    }

    // method to get next data
    public GoKart getNext() 
    {
        if(current==tail)
        {
            return null;
        }
        else
        {
            current = current.next;
            return current.data;
        }
    }
    //method to search and remove data
    public boolean searchAndRemoveGoKart(String name) {
        Node current = head;
        Node previous = null;
        GoKart removeData = null;
        
        while (current != null) {
            if (current.data.getName().equalsIgnoreCase(name))
            {
                removeData = current.data;

                if(current == head)
                {
                    removeData = removeFromFront();
                }
                else if(current == tail)
                {
                    removeData = removeFromBack();
                }
                else
                {
                    previous.next = current.next;
                }

                System.out.println(name+ " has been removed\n");
                return true;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("\nData does not exist.");
        return false;
    }
    // method to search and update data
    public boolean searchAndUpdateGoKart(String name) {
        Node current = head;
        
        while (current != null) {
            if (current.data.getName().equalsIgnoreCase(name)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("GoKart found. Enter new data:");

                System.out.print("Enter type of car: ");
                String typeOfCar = scanner.nextLine();

                System.out.print("Enter stroke engine: ");
                String strokeEngine = scanner.nextLine();

                System.out.print("Enter option (1 or 2): ");
                int option = scanner.nextInt();

                System.out.print("Enter number of laps: ");
                int numberOfLaps = scanner.nextInt();

                System.out.print("Is safety set? (true/false): ");
                boolean safetySet = scanner.nextBoolean();

                current.data.setGoKart(name, typeOfCar, strokeEngine, option, numberOfLaps, safetySet);
                System.out.println("GoKart data updated successfully.\n");
                
                return true;
            }
            current = current.next;
        }
        System.out.println("\nData does not exist.");
        return false;
    }
}
