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
public class DGraph extends Graph {
    int vertices, edges;
    protected LinealList <Edge> arr[];
    
    public DGraph (int v){
        this.vertices=v+1;
        this.edges=0;
        arr = new LinealList[this.vertices];
        for (int i=1;i<this.vertices;i++){
            arr[i]=new LinealList <>();
        }
    }

    @Override
    public int nEdges() {
        return this.edges;
    }

    @Override
    public int nVertices() {
        return this.vertices;
    }

    @Override
    public boolean isEdge(int i, int j) {
       LinealList <Edge> lista = this.arr[i];
       for (lista.setFirst();!lista.isLast();lista.keepMoving()){
           if(lista.getMove().dest==j) return true;
       }
       return false;
    }

    @Override
    public double getEdgeW(int i, int j) {
        LinealList <Edge> lista = this.arr[i];
        for (lista.setFirst();!lista.isLast();lista.keepMoving()){
            if(lista.getMove().dest==j) return lista.getMove().weight;
        }
        return 0.0;
    }

    @Override
    public void insertEdge(int i, int j) {
        insertEdge(i,j,0);
    }

    @Override
    public void insertEdge(int i, int j, double w) {
        if (!isEdge(i,j)){
            this.arr[i].insert(new Edge(j,w));
            this.edges++;
        }
    }

    @Override
    public LinealList<Edge> adjacentTo(int i) {
        return this.arr[i];  
    }
    //Grafo dirigido con pesos
    
    
}
