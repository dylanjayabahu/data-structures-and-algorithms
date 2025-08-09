import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Your implementation of breadth-first search.
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you should use is the adjacency
     * list from graph. DO NOT create new instances of Map for BFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the bfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        Queue<Vertex<T>> Q = new LinkedList<>();
        List<Vertex<T>> path = new ArrayList<>();
        Set<Vertex<T>> VS = new HashSet<>();

        Q.add(start);
        VS.add(start);

        while (!Q.isEmpty()){
            Vertex<T> curr = Q.remove();
            path.add(curr);

            for (VertexDistance<T> vd : graph.getAdjList().get(curr)){
                Vertex<T> v = vd.getVertex();

                if (!VS.contains(v)){
                    VS.add(v);
                    Q.add(v);
                }
                
            }
        }

        return path;
    }
}