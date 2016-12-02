package ED;


import ED.NodeTree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mariana Villegas
 */
public class BinaryTree {
   
    NodeTree root;
    int height;
    int elements;
    
    public BinaryTree(){
        this.root = null;
        this.height = -1;
        this.elements = 0;
    }
    
    public boolean isEmpty(NodeTree root){
        return root.left == null && root.right == null;
    }
    
    public void insertNode(int data, NodeTree root){
        NodeTree node = new NodeTree(data);
        if(isEmpty(root)){
            root = node;
            height++;
        }
        else{//Si no está vacio
            //Si el nodo es mayor que raiz
            if(node.data >= root.data){
                //Si no tiene elementos a la izquierda
                if(root.right == null){//Caso Base
                    root.right = node;
                }
                else{//Si tiene un elemento a la izquierda
                    //Buscará por la izquierda hasta encontrar un espacio.
                    insertNode(data,root.right);
                }
            }
            else{//Si no es mayor que raiz
                if(root.left == null){//Caso Base
                    root.left = node;
                }
                else{//Si tiene un elemento a la derecha, buscará por la
                    //derecha hasta encontrar un espacio
                    insertNode(data, root.left);
                }
            }
        }
        this.elements++;
    }
  public void eNode(){
      
  }  
  public NodeTree getRoot(){
      return this.root;
  }
  //Determinar altura
  //Determinar número de elementos
   public synchronized void recorridoPreorden()
    {
        showTreeInorden(root);
    }
  public void showTreeInorden(NodeTree node){
            if(node == null)
            return;
         
        System.out.print(node.data + " ");     //mostrar datos del nodo
        showTreeInorden(node.left);   //recorre subarbol izquierdo
        showTreeInorden(node.right);     //recorre subarbol derecho
    }
    }
    
    

