package blind.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anindita Banik on 7/17/22.
 */
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int[][] pacific = new int[heights.length][heights[0].length];
        int[][] atlantic = new int[heights.length][heights[0].length];

        // top and bottom
        for(int col=0; col< heights[0].length; col++){
            dfs(0, col, Integer.MIN_VALUE, heights, pacific);
            dfs(heights.length-1, col, Integer.MIN_VALUE, heights, atlantic);
        }

        // left and right
        for(int row=0; row< heights.length; row++){
            dfs(row, 0, Integer.MIN_VALUE, heights, pacific);
            dfs(row, heights[0].length-1, Integer.MIN_VALUE, heights, atlantic);
        }

        for(int i=0;i<heights.length;i++)
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    List list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }

        return result;
    }

    //
    void dfs(int row, int col, int preVal, int[][] heights, int[][] ocean){

        //1. Check necessary conditions
        if(row<0 || row >heights.length-1 || col<0 || col >heights[0].length-1 )
            return;
        else if(heights[row][col] < preVal)
            return;
        else if(ocean[row][col]==1)
            return;

        //2. process cell
        ocean[row][col] = 1;

        //3. call dfs recursively.
        dfs(row-1, col, heights[row][col], heights, ocean);
        dfs(row+1, col, heights[row][col], heights, ocean);
        dfs(row, col-1, heights[row][col], heights, ocean);
        dfs(row, col+1, heights[row][col], heights, ocean);
    }

}
