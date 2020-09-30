import java.util.NoSuchElementException;

public class Queue<Item> {
    private Node<Item> first; //beginninf of queue
    private Node<Item> last; //end of queue
    private int N;  //number of elements o queue

    //helper linked list class
    private static class Node<Item>{
        private Item item;
        private Node<Item> next;

    }
    //initializes an empty queue
    public Queue(){
        first = null;
        last = null;
        n = 0;
    }
    
}