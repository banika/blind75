package blind.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Anindita Banik on 7/17/22.
 */
public class ConnectedComponentsOfUndirectedGraph {
    int components = 0;
    Set<Integer> seen = new HashSet<>();
    List<List<Integer>> adjList = new ArrayList<>();

    public int countComponents(int n, int[][] edges) {
        for(int i =0;i<n;i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int edge[] : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        for(int u=0;u<n;u++){
            components+=dfs(u);
        }
        return components;
    }

    int dfs(int node){
        if(seen.contains(node))
            return 0;
        seen.add(node);
        for(int neighbor: adjList.get(node)){
            dfs(neighbor);
        }
        return 1;
    }
}
