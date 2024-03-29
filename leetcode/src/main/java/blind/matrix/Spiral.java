package blind.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anindita Banik on 8/10/22.
 */
public class Spiral {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0)
            return res;
        int n = matrix.length, m=matrix[0].length;
        int up =0, down=n-1, left =0, right=m-1;

        while(res.size()<n*m){
            for(int j =left;j<=right && res.size()<n*m;j++)
                res.add(matrix[up][j]);
            for(int i =up+1;i<=down-1 && res.size()<n*m;i++)
                res.add(matrix[i][right]);
            for(int j =right;j>=left && res.size()<n*m;j--)
                res.add(matrix[down][j]);
            for(int i =down-1;i>=up+1 && res.size()<n*m;i--)
                res.add(matrix[i][left]);
            left++;right--;up++;down--;
        }

        return res;
    }
}
