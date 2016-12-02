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
public class DoubleList <T> {
     DoubleNode first;
    DoubleNode last;

    public void insertFirst(T data) {
        DoubleNode node = new DoubleNode(data); //creación del nodo
        if (isEmpty()) {//preguntamos si la lista esta vacia, si es asi, se crean nodos tanto al principio  como al final
            this.first = node;
            this.last = node;
        } else {
            node.next = first;//El apuntador "SIGUIENTE" del nuevo nodo, apunta al primer noo de la lista
            first.prev = node;//El apuntador "ANTERIOR" del primer nodo de la lista apunta al nodo anterior de la lista
            first = node; //El apuntador first (que es eatributo de la lista) apunta a un nodo
        }
    }

    public void insertLast(T data) {
       
        DoubleNode node = new DoubleNode(data);//creación de nodo
        if (isEmpty()) {//Verifica si esta vacia
            this.last = node;
            this.first = node;
            
        } else {

            node.prev = last; //El apuntador previo del nodo apunta al ultimo nodo
            last.next = node;// El apuntador siguiente del ultimo node apuntara al nodo siguiente en la lista
            last = node;//El apuntador last  apunta  a un nodo
        }

    }
  public void eNodeFirst() {
        //mmovemos al apuntador first al siguiente nodo y el previo  de este lo ponemos null
        first = first.next;
        first.prev = null;
    }

    public void eNodeLast() {
        //movemos el apuntador last al previo nodo y el siguiente  de este lo ponemos null
        last = last.prev;
        last.next = null;
    }

    public boolean eNODE(T data) {
        DoubleNode aux = searchNode(data);// creamos un auxiliar de tipo nodo que recibira información del metodo que busca nodos
        if (aux == null) {//Si el auxiliar tiene el valor de null regresara un string que dice que el nodo no se encuentra en la lista
            System.out.println("No se encontro el nodo");
            return false;

        } else { //Si no 
            if (aux == first) {//Si el auxiliar es igual a first llamamos al metodo para borrar el primer nodo
                eNodeFirst();
            } else if (aux == last) {//Si el auxiliar es igual a last llamamos al metodo para borrar el ultimo nodo
                eNodeLast();
            } else {// Si no es el primero ni el ultimo 
                aux.prev.next = aux.next;// El apuntador que apunta al nodo previo ahora apuntara al nodo siguiente del siguiente
                aux.next.prev = aux.prev;//El apuntador que apunta al nodo siguiente apuntara al nodo previo de anterior
            }
            return true;// en culquiera de los 3 if's se regresara veradedero porque el nodo fue encontrado y eliminado
        }

    }

  
    public DoubleNode searchNode(T data) {
        DoubleNode aux;
        if (isEmpty()) {//Si esta vacío retorna falso
            return null;
        } else {//Si contiene elementos 
            aux = first;//colocamos auxiliar al inicio de la lista
            while (aux.data != data && aux != last) {//Mientras que no ecuentre el dato, recorre la lista
                aux = aux.next;
            }
            if (aux.data == data) {//Si  la informacion mandada coincide  con el auxiliar regresaremos el valor del auxiliar
                return aux;
            } else {//Si no regresamos nulo porque no se encontro el nodo
                return null;
            }

        }

    }

    private boolean isEmpty() {//Método para ver si la lista esta vacia
        return first == null && last == null;
    }

    public void showList() {//Método para mostrar la lista
        DoubleNode aux1;//declaramos dos variables auxiliares tipo nodeDL para guardar los valores de nuestros nodos
        aux1 = (DoubleNode) first;// aux1 sera igual a first

        if (!isEmpty()) {//Preguntamos si la lista esta llena
            while (aux1 != null) {//Mientras aux1 sea diferente de 1 imprimiremos la informacion
                System.out.print("->" + "[" + aux1.data + "]");
                aux1 = aux1.next;
            }

        } else {
            System.out.println("La lista está vacia");

        }
    }

    public void showLastFirst() {
        DoubleNode aux1;//declaramos dos variables auxiliares tipo nodeDL para guardar los valores de nuestros nodos
        aux1 = (DoubleNode) last;// aux1 sera igual a first

        if (!isEmpty()) {//Preguntamos si la lista esta llena
            while (aux1 != null) {//Mientras aux1 sea diferente de 1 imprimiremos la informacion
                System.out.print("->" + "[" + aux1.data + "]");
                aux1 = aux1.prev;
            }

        } else {
            System.out.println("La lista está vacia");

        }
    }

}
