import java.util.NoSuchElementException;
import java.util.Scanner;

public class Stack <Item> {
    private Node <Item> first;  
    private int N;              
    //top of stack
    //size of the stack

    //helper linked list class
    private static class Node <Item> {
        private Item item;
        private Node <Item> next;
    }
    //initializes an empty stack
    public Stack (){
        first = null;
        N = 0;
    }
    public boolean isEmpty(){
        return first == null;
    }
    /* return the number of items in this stack.
    @eturn the number o itens in this stack */

    public int size (){
        return N;
    }
    /* adds the itm to this stack
    @param item the item to add */

    public void push (Item item){
        Node <Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    /* removes and return the item most recent added to this stack
    @return the item most recently added
    @throws NoSushiElementException if this stack is empty*/

    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item; //save item to return
        first = first.next; //delee first node
        N--;
        if(isEmpty()) first = null; N = 0;
        return item;  //eturn the saved item
    }
    public static void main (String [] args){
        Stack iniciandoStack = new Stack<>();
        System.out.println("Insira na pilha..");
        System.out.println("se desejar parar a execução, digite (pare)");
        Scanner info = new Scanner(System.in);
        while(info.hasNextLine()){
            String string = info.nextLine();
            if(string.equalsIgnoreCase("pare")){ 
                break; 
            }
            String [] stringSeparada = string.split(" ");
            String stringDesempilhada = "";
            for(String s : stringSeparada){
                if(s.equals("-")){
                    Object itemPop = iniciandoStack.pop();
                    String transformaStr = itemPop.toString();
                    if(stringDesempilhada.equals(" ")){
                        stringDesempilhada += transformaStr;
                    }else{
                        stringDesempilhada += " " + transformaStr;
                    }
                }else{
                    Object itemPush = new Object();
                    itemPush = s;
                    iniciandoStack.push(itemPush);
                }
            }
            System.out.println("Item/itens desempilhados > " +stringDesempilhada);
        }
        info.close();
        System.out.println("Pilha finalizada.");
        

    }
    /*
    fazer o MAIN - ela deve receber do tecado 
    se ler um traço e a pilha não estiver vazia
    desempilhe e imprima a string que estava no topo da tela
    se não então o programa leu uma string 
    empilhe ela
    não havendo input do teclado indique quantas string estão na pilha
    o programa encerra quando não houve mais nada a ser lido ou a ser 
    interrompido */
}
