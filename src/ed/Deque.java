/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED;


/**
 *
 * @author Mariana Villegas
 */
public class Deque<T> {

    private DoubleNode first;
    private DoubleNode last;
    private int size;
//Contructor
    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
//Getters
    public DoubleNode getFirst() {
        return first;
    }

    public DoubleNode getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }
//Setters
    public void setFirst(DoubleNode first) {
        this.first = first;
    }

    public void setLast(DoubleNode last) {
        this.last = last;
    }
/**
 * Método para insertar el primer elemento
 * @param data 
 */
    public void insertFirst(T data) {//Método para insertar el primer nodo
        DoubleNode node = new DoubleNode(data); //creación del nodo
        if (isEmpty()) {//preguntamos si la lista esta vacia, si es asi, se crean nodos tanto al principio  como al final
            this.first = node;
            this.last = node;
            ++size;
        } else {
            node.setNext(first);//El apuntador "SIGUIENTE" del nuevo nodo, apunta al primer noo de la lista
            first.setPrev(node);//El apuntador "ANTERIOR" del primer nodo de la lista apunta al nodo anterior de la lista
            first = node; //El apuntador first (que es eatributo de la lista) apunta a un nodo
            ++size;
        }
    }
/**
 * Método para insertar el ultimo elemento
 * @param data 
 */
    public void InsertLast(T data) {
        DoubleNode node = new DoubleNode(data);//creación de nodo
        if (isEmpty()) {//Verifica si esta vacia
            this.last = node;
            this.first = node;
            ++size;
        } else {

            node.setPrev(last); //El apuntador previo del nodo apunta al ultimo nodo
            last.setNext(node);// El apuntador siguiente del ultimo node apuntara al nodo siguiente en la lista
            last = node;//El apuntador last  apunta  a un nodo
            ++size;
        }
    }
/**
 * Método para eliminar el primer elemento
 */
    public void popFirst() {
        first.setNext(first);
        first.setPrev(null);
        --size; // el tamaño disminuye
    }
/**
 * Método para eliminar el ultimo elemento
 */
    public void popLast() {
        //movemos el apuntador last al previo nodo y el siguiente  de este lo ponemos null
        last.setPrev(last);
        last.setNext(null);
        --size; //el tamaño disminuye
    }
/**
 * Método para verificar que la deque este vacia
 * @return valor booleano
 */
    private boolean isEmpty() {
        return first == null && last == null && size == 0;

    }
/**
 * Método para vaciar la deque
 */
    public void vaciar() {
        first = null;
        last = null;
        size = 0;
    }

    public void showList() {//Método para mostrar la lista
        DoubleNode aux1;//declaramos dos variables auxiliares tipo nodeDL para guardar los valores de nuestros nodos
        aux1 = (DoubleNode) first;// aux1 sera igual a first

        if (!isEmpty()) {//Preguntamos si la lista esta llena
            while (aux1 != null) {//Mientras aux1 sea diferente de 1 imprimiremos la informacion
                System.out.print("->" + "[" + aux1.getData() + "]");
                aux1 = aux1.getNext();
            }

        } else {
            System.out.println("La lista está vacia");

        }
    }
}
