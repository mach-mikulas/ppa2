/**
 * Hledani nejkratsi cesty v grafu
 * @author Libor Vasa
 */
public class ShortestPathSearch {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.initialize(20);
        g.addEdge(0, 1);
        g.addEdge(0, 5);
        g.addEdge(5, 10);
        g.addEdge(10, 15);

        g.addEdge(1, 7);
        g.addEdge(1, 2);
        g.addEdge(2, 8);
        g.addEdge(7, 2);
        g.addEdge(7, 8);
        g.addEdge(7, 12);

        g.addEdge(12, 8);
        g.addEdge(12, 13);
        g.addEdge(12, 17);
        g.addEdge(12, 18);

        g.addEdge(8, 13);
        g.addEdge(8, 9);

        g.addEdge(9, 4);
        g.addEdge(9, 13);
        g.addEdge(9, 14);

        g.addEdge(13, 14);
        g.addEdge(13, 18);
        g.addEdge(13, 19);
        g.addEdge(14, 19);
        g.addEdge(17, 18);
        g.addEdge(18, 19);


        //System.out.println(g.edges[1].next.next.neighbour);
        System.out.println(g.shortestPathLength(15, 19));
    }
}