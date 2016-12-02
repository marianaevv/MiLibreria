/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED;

import ED.SimpleNode;

/**
 *
 * @author Mariana Villegas
 */
public class Queue<T> {

    private SimpleNode first;
    private SimpleNode last;
    private int size;
    private SimpleNode moving;
    

    //Constructor
    public Queue() {
        this.first = null;
        this.last = null;
          this.moving = null;
        this.size = 0;
    }

    public Queue(T data) {
        insertLast(data);

    }
    //Métodos

    public void insertLast(T data) {
        SimpleNode <T> node = new SimpleNode(data);
        if (isEmpty()) {
            first = node;
            last = node;
            ++this.size;
        } else {
            node.setNext(last);
            last = node;
        }
    }

    public T deleteFirst() {
        SimpleNode temp;
       if (!isEmpty()){
            if (size==1){
                temp=this.first;
                this.first = this.last = null;
                size=0;
            }else{
                temp=last;
                while(temp.getNext()!=first){
                    temp=temp.getNext();
                }
                first = temp;
                temp = first.getNext();
                first.setNext(null);
                --size;
            }
           return (T) temp.getData();
        }
        return null;
    }

    public void setEmpty() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Object getFirst() {
        return first.getData();
    }
//Getters

    public SimpleNode getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

}
