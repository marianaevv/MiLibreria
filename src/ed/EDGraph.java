/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED;


/**
 *
 * @author falvizo
 */
public class EDGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
        DGraph grafo = new DGraph(6);
        grafo.insertEdge(3, 5, 8);
        grafo.insertEdge(5, 4, 10);
        grafo.insertEdge(6, 3, 11);
        grafo.insertEdge(2, 1, 6);
        grafo.insertEdge(1, 7, 3);
        grafo.insertEdge(4, 5, 9);
        grafo.insertEdge(2, 3, 8);
        System.out.println("Grafo:"+grafo.toString());
        System.out.println(grafo.toStringBFS());
    }
    
}
