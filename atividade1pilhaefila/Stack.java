import java.util.NoSuchElementException;
import java.util.Scanner;
import java.lang.Object;

public class Stack <Item> {
    private Node <Item> first;  //top of stack
    private int N;              //size of the stack


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
        Scanner leitor = new Scanner(System.in);
        Stack iniciandoStack = new Stack<>();
        System.out.println("Escreva...");
        System.out.println("se desejar parar a execução, difgite (pare)");
        while(leitor.hasNextLine()){
            String string = leitor.nextLine();
            if(string.equalsIgnoreCase("pare")){ break; }
            String [] stringSeparada = string.split(" ");
            String stringDesempilhada = "";
            for(String s : stringSeparada){
                if(s.equals("-")){
                    Object obj = iniciandoStack.pop();
                    String str = obj.toString();
                    if(stringDesempilhada.equals(" ")){
                        stringDesempilhada += str;
                    }else{
                        stringDesempilhada += " " + str;
                    }
                }else{
                    Object itemPush = new Object();
                    itemPush = s;
                    iniciandoStack.push(itemPush);
                }
            }
            System.out.println("Desempilhando..." +stringDesempilhada);
        }
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
