
import java.util.ArrayList;
import java.util.NoSuchElementException;
//import java.util.Queue;
import java.util.Scanner;

public class Queue<Item> {
    public Node<Item> first; //beginning of queue
    public Node<Item> last; //end of queue
    public int N;          //number of elements on queue
    
    //helper linked list class
    public static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    //initializes an empty queue
    public Queue(){
        first = null;
        last = null;
        N = 0;
    }


    
    /* returns true if this queue is empty.
    @return <tt>true</tt> if this queue is empty; <tt>false</tt> otherwise*/
    public boolean isEmpty(){
        return first == null;
    }
    // returns the number of items in this queue 
    public int size (){
        return N;
    }
    /* returns the item least recentl added to this queue.
    @return the item least recenty added to this queue
    @throws NoSuchiElementException if this queue is empty */
    
    public Item peek(){
        if(isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }
    /* adds the item t this queue.
    @param item the item to add
    */
    public void enqueue (Item item){
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if(isEmpty()) {first = last;}
        else oldLast.next = last;
        N++;
    }
    /*Removes and returns the item on this queue that was least recently added
    @return the item on this queue that was least recently added
    @throws NoSuchElementException  if this queue is empty
    */
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty())
            last = null; // to avoid loitering
        return item;
    }
    public static void main(String [] args){
        
        Scanner leitor = new Scanner(System.in);
        String stringDequeue = "";
        String sair = "não";
        Queue iniciandoQueue = new Queue<>();
        do{
            System.out.println("Escreva...");
            String stringLida = leitor.nextLine();
            String [] stringSeparada = stringLida.split(" ");
            for(String s : stringSeparada){
                if(s.equals("")){
                    String string = (String) iniciandoQueue.dequeue();
                    if(stringDequeue.equals("")){
                        stringDequeue += string; 
                    }else{stringDequeue += " " + string;}
                    
                }else{
                    Object item2 = new Object();
                    item2 = s;
                    iniciandoQueue.enqueue(item2);

                }
            }
            System.out.println(stringDequeue);
            System.out.println("Deseja parar?");
            sair = leitor.nextLine();
            
        }while(sair.equalsIgnoreCase("não"));
        leitor.close();
    }

    /* fazer o Main - Ela deve ler do teclado 
    se ler um traço e a fila esiver vazia
        Desendileire e imprima a string que estava na cabeça
    Senão então o programa leu uma String.
        enfileire ela
    nao havend input do teclado, indique quantas string estão na fila
    o programa ncerra quando não hoouver mais nada a ser lido ou a ser interrompido.*/

}