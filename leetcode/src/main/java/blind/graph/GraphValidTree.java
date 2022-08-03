package blind.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Anindita Banik on 7/17/22.
 */
public class GraphValidTree {
    Set<Integer> seen = new HashSet<>();
    List<List<Integer>> adjList = new ArrayList<>();
    public boolean validTree(int n, int[][] edges) {
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return dfs(0, -1) && seen.size()==n;
    }

    boolean dfs(int node, int parent){
        if(seen.contains(node))
            return false;
        seen.add(node);
        for(int neighbor: adjList.get(node)){
            if(parent!=neighbor){
                boolean result = dfs(neighbor, node);
                if(!result)
                    return false;
            }
        }
        return true;
    }
}
