package practice.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anindita Banik on 8/13/22.
 */
public class NumberOfIslands {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        char[][] grid = new char[m][n];
        for (char[] row : grid) {
            Arrays.fill(row, '0');
        }
        for (int[] pos : positions) {
            grid[pos[0]][pos[1]] = '1';
            int no = numIslands(grid);
            ans.add(no);
        }
        return ans;
    }

    public int numIslands(char[][] grid) {
        if(grid==null || grid.length ==0)
            return 0;
        int numOfIslands = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
            for(int j =0;j<grid[i].length; j++){
                if(grid[i][j]=='1')
                    numOfIslands += dfs(grid, i, j,visited);
            }

        return numOfIslands;
    }

    int dfs(char[][] grid, int i, int j, boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]=='0' || visited[i][j])
            return 0;

        visited[i][j] = true;
        dfs(grid,i-1,j,visited);
        dfs(grid,i+1,j,visited);
        dfs(grid,i,j-1,visited);
        dfs(grid,i,j+1,visited);

        return 1;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','0'}
                ,{'0','0','0','0'}
                ,{'0','0','0','0'}
                ,{'0','0','0','0'}
        };

        NumberOfIslands noi = new NumberOfIslands();
        int result = noi.numIslands(grid);
        System.out.println(result);
        int[][] positions = {
                {0,0},
                {0,1},
                {1,2},
                {2,1}
        };
        List<Integer> res = noi.numIslands2(3,3,positions);
        System.out.println(res);
    }
}

