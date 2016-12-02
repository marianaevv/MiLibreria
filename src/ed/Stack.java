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
public class Stack<T> {

    private SimpleNode top;
    private int size;

    //constructor
    public Stack() {
        this.top = null;
        this.size = 0;
    }
    //Getters

    /*
 @return stack's top
     */
    public SimpleNode getTop() {
        return top;
    }

    /*
 
     */
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        SimpleNode node = new SimpleNode(data);
        if (isEmpty()) {//si la pila esta vacia
            top = node;
        } else {
            node.setNext(top);
            top = node;
        }
        ++size;
    }

    /**
     *
     * Elimina un elemento de la pila
     */
    public void pop() {
        if (!isEmpty()) {
            top = top.getNext();
            --size;
        } else {
            System.out.println("La pila esta vacía");
        }

    }

    /**
     * Vacía los elementos de la pila
     */
    public void empty() {
        top = null;
        size = 0;
    }

    public void showStack() {
        if (!isEmpty()) {
            SimpleNode aux = top;
            do {

                System.out.println(aux.getData());
                System.out.println("|");
                System.out.println("V");
                aux = aux.getNext();
            } while (aux != null);
        }
        System.out.println("null");
    }

    public void specificPop(T pos) {
        SimpleNode node = top;
        
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (node == pos) {
                    node = node.getNext();
                    --size;
                } 
                    node = node.getNext();
                
            }
        }
    }

    public int search(T pos) {
        // nodo temporal que sera "recorrido" 
        SimpleNode node = top;
        for (int i = 0; i < size; i++) {
            if (node == pos) { // evaluamos si es el nodo que buscamos 
                return i;                                   // retornamos su posición 
            }
            node = node.getNext();               // continuamos con el siguiente 
        }
        return -1;                                        // si no lo encontró retorna -1
    }

}
