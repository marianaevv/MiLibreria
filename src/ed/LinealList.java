/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED;

import java.util.Scanner;

/**
 *
 * @author Mariana Villegas
 */
public class LinealList <T> {
     private SimpleNode first;// declaracion de variable first tipo nodeClass
    private SimpleNode last;//declaración de variable last tipo nodeClass
    private SimpleNode move;
    private int elements;
    //Constructor
    public LinealList(){
        first = null;
        last = null;
    }
//Métodos

    public void insertFirst(T n) {//Método para insertar el primer nodo
        SimpleNode <T> node = new SimpleNode(n);//creamos un objeto llamado node de tipo nodeClass
        if (isEmpty()) {//Preguntamos si la lista esta vacia
            first = node;//si es asi, a la variables firts le asignamos el valor de un nodo
            last = node;// a la variable last le asignamos le asignamos el valor de un nodo
        } else {// en caso de que no este vacia
            node.next = first;//utilizamos node.next para que el nodo lleno apunte a otro nodo y a este se le da la variable firts
            first = node; //y first sera igual a un nodo
        }
        this.elements++;
    }

    public void insert(T n) {// Métpdo para insertar el ultimo nodo de la lista
        SimpleNode node = new SimpleNode(n);//Creación del objeto tipo nodeClass
         if(isEmpty()){//Preguntamos
            this.last = node;
            this.first = node;
        }else{
       this.last.next = node;// hacemos que no exista un nodo siguiente
        last = node;// y asignamos el ultimo nodo
         }
         this.elements++;
    }

     public int getElements(){
        return this.elements;
    }
    
    /**
     * Elimina el elemento indicado en el parámetro
     * @param data
     * @return true
     */
    public boolean delete (T data){
        if(!isEmpty()){
            setFirst();
            if (move.data.equals(data)){
                return deleteFirst();
            }else{
                while (!move.next.data.equals(data)){
                    if (move.next!=null){
                    keepMoving();
                    }else{
                        return false;
                    }
                }
                move.next=move.next.next;
                return true;
            }
        }else{
            return false;
        }
    }
    /**
     * Elimina todos los elementos de la lista.
     */
    public void emptyList(){
        System.out.print("\033[31mAll the elements will disapear. Are you sure?(Y/N) ");
        Scanner e = new Scanner(System.in);
        String r = e.nextLine();
        if (r.equals("Y") || r.equals("y")){
            this.first=this.last=this.move=null;
            this.elements=0;
            System.out.println("\033[31mDone");
        }
    }
    
    /**
     * Elimina el primer elemento de la lista
     * @return true
     */
    public boolean deleteFirst(){
        if (!isEmpty()){
            this.first=this.first.next;
            return true;
        }else return false;
    }
    
    /**
     * Elimina el último elemento de la lista
     * @return true
     */
    public boolean deleteLast(){
        if (!isEmpty()){
            setFirst();
            while(!this.move.next.equals(this.last)){
                keepMoving();
            }
            last = this.move;
            last.next = null;
            return true;
        }else return false;
    }
    
    /**
     * Busca un elemento en la lista y lo devuelve
     * @param data
     * @return data
     */
    public T fetch(T data){
        if(!isEmpty()){
            if (last.data.equals(data)){
                return (T) move.data;
            }else{
                setFirst();
                do{
                    if (!move.data.equals(data)){
                         keepMoving();
                    }else{
                        return (T) move.data;
                    } 
                }while(move != last);
            }
        }
        return null;
    }
    
    /**
     * Ubica al puntero move al inicio de la lista
     */
    public void setFirst(){
        move = this.first;
    }
    
    /**
     * Evalua si el puntero move está al inicio de la lista
     * @return true
     */
    public boolean isFirst(){
        return move == this.first;
    }
    
    /**
     * Ubica el puntero move al final de la lista
     */
    public void setLast(){
        move = this.last;
    }
    
    /**
     * Evalua si el puntero move está al final de la lista
     * @return 
     */
    public boolean isLast (){
        return move == this.last;
    }
    
    /**
     * Mueve el puntero move al siguiente elemento de la lista.
     */
    public void keepMoving(){
        move = move.next;
    }
    
    /**
     * Devuelve el dato del puntero move
     * @return data
     */
    public T getMove(){
        return (T) this.move.getData();
    }
    
    @Override
    public String toString(){
        if (!isEmpty()){
            String s="";
            setFirst();
            while(move!=null){
                s += (T) getMove() + "->";
                
                keepMoving();
            }
            return s+="null";
        }
        else return "Lista vacía";
    }
    

  

    public boolean isEmpty() {//Método para ver si la lista esta vacia
        return first == null;
    }

    
}
