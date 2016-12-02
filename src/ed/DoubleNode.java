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
public class DoubleNode<T> {

    DoubleNode next;
    T data;
    DoubleNode prev ;

    public DoubleNode(T data) {
        this.data = data;
    }
    public void setData(T d){
        this.data = d;
    }
    public T getData(){
        return this.data;
    }

    public DoubleNode getNext() {
        return next;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }
    
}
