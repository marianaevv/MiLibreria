package ED;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mariana Villegas
 */

    public class NodeTree <T> {
    int data;
    NodeTree left;
    NodeTree right;

    public NodeTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
}

