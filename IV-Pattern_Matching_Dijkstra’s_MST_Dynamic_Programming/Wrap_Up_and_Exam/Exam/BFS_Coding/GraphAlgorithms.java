import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Your implementation of depth-first search.
 */
public class GraphAlgorithms {

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * NOTE: This method should be implemented recursively. You may need to
     * create a helper method.
     *
     * You may import/use java.util.Set, java.util.List, and any classes that
     * implement the aforementioned interfaces, as long as they are efficient.
     *
     * The only instance of java.util.Map that you may use is the adjacency list
     * from graph. DO NOT create new instances of Map for DFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the dfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */

    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        HashSet<Vertex<T>> visitedSet = new HashSet<>();
        List<Vertex<T>> path = new ArrayList<>();

        rDFS(start, graph, visitedSet, path);

        return path;
    }


    private static<T> void rDFS(Vertex<T> curr, Graph<T> graph, HashSet<Vertex<T>> visitedSet, List<Vertex<T>> path){
        visitedSet.add(curr);
        path.add(curr);

        List<VertexDistance<T>> adj = graph.getAdjList().get(curr);


        Vertex<T> w;
        for (VertexDistance<T> vd : adj){
            w = vd.getVertex();
            if (!visitedSet.contains(w)){
                rDFS(w, graph, visitedSet, path);
            }
        }
    }
}