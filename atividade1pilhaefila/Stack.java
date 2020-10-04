import java.util.NoSuchElementException;
import java.util.Scanner;

public class Stack <Item> {
    private Node <Item> first;  //top of stack
    private int n;              //size of the stack


    //helper linked list class
    private static class Node <Item> {
        private Item item;
        private Node <Item> next;
    }
    //initializes an empty stack
    public Stack (){
        first = null;
        n = 0;
    }
    public boolean isEmpty(){
        return first == null;
    }
    /* return the number of items in this stack.
    @eturn the number o itens in this stack */

    public int size (){
        return n;
    }
    /* adds the itm to this stack
    @param item the item to add */

    public void push (Item item){
        Node <Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }
    /* removes and return the item most recent added to this stack
    @return the item most recently added
    @throws NoSushiElementException if this stack is empty*/

    public Item pop(Item item){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        item = first.item; //save item to return
        first = first.next; //delee first node
        n--;
        return item;  //eturn the saved item
    }
    public static void main (String [] args){
        Scanner leitor = new Scanner(System.in);
        String parar = "não";
        Stack iniciandoStack = new Stack<>();
        do{
            String string = leitor.nextLine();
            String [] stringSeparada = string.split(" ");
            String stringDesempilhada = "";
            for(String s : stringSeparada){
                if(s.equals("-")){
                    Object itemPop = new Object();
                    itemPop = s;
                    String stringPop = (String) iniciandoStack.pop(itemPop);
                    if(stringDesempilhada.equals(" ")){
                        stringDesempilhada += stringPop;
                    }else{
                        stringDesempilhada += " " + stringPop;
                    }
                }else{
                    Object itemPush = new Object();
                    iniciandoStack.push(itemPush);
                }
            }
            System.out.println("Desempilhando..." +stringDesempilhada);
            System.out.println("Quer parar?");
            parar = leitor.nextLine();
        }while(parar.equalsIgnoreCase("não"));
        leitor.close();
        System.out.println("Finalizado");
        

    }
    /*fazer o MAIN - ela deve receber do tecado 
    se ler um traço e a pilha não estiver vazia
    desempilhe e imprima a string que estava no topo da tela

    se não então o programa leu uma string 
    empilhe ela
    não havendo input do teclado indique quantas string estão na pilha
    o programa encerra quando não houve mais nada a ser lido ou a ser 
    interrompido (ctrl + c ou ctrl + d) */
}
