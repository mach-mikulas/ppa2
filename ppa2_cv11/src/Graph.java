import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Graf pro ulozeni mapy
 * @author Libor Vasa
 */
class Graph {
    /**
     * Sousedi jednotlivych vrcholu (hrany)
     */
    Link[] edges;

    /**
     * Inicializuje sousedy jednotlivych vrcholu (hrany)
     *
     * @param vertexCount pocet vrcholu grafu
     */
    public void initialize(int vertexCount) {
        edges = new Link[vertexCount];
    }

    /**
     * Prida do grafu novou obousmernou hranu
     *
     * @param start cislo pocatecniho vrcholu
     * @param end   cislo koncoveho vrcholu
     */
    public void addEdge(int start, int end) {
        Link n = new Link(end, edges[start]);
        edges[start] = n;
        n = new Link(start, edges[end]);        //Prohozeno
        edges[end] = n;
    }

    public int shortestPathLength(int start, int end) {
        int d = BFSDistance(start, end);
        return d;
    }

    int BFSDistance(int s, int end) {
        int[] result = new int[edges.length];
        for (int i = 0;i<edges.length;i++)
            result[i] = -1;
        result[s] = 0;
        int[] mark = new int[edges.length];
        mark[s] = 1;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(s);

        while(!q.isEmpty()) {
            int v = q.pop();

                Link n = edges[v];

                while(n!=null) {
                    int i = n.neighbour;
                        if (mark[i] == 0) {
                            mark[i] = 1;
                            q.add(i);
                            result[i] = result[v] + 1;

                            if(i == end){
                                return result[end];
                            }
                        }
                    n = n.next;

            }
            mark[v] = 2;
        }
        return -1;
    }

}