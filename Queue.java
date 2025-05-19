public class Queue extends LinkList
{
    //queue constructor
    public Queue()
    {
        super();
    }
    //enqueue method
    public void enqueue(GoKart g)
    {
        insertAtBack(g);
    }
    //dequeue method
    public GoKart dequeue()
    {
        return removeFromFront();
    }
    //method to get a data from the front
    public GoKart getFront()
    {
        return getFirst();
    }
    //method to get data from the end
    public GoKart getEnd()
    {
        GoKart d = removeFromBack();
        insertAtBack(d);
        return d;
    }
    //method for size
    public int getSize() {
        int count = 0;
        Object temp = getFirst();
        while (temp != null) {
            count++;
            temp = getNext();
        }
        return count;
    }
}
