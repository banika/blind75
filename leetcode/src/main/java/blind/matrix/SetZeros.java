package blind.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anindita Banik on 8/10/22.
 */
public class SetZeros {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        int R=matrix.length;
        int C=matrix[0].length;

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }

        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j]=0;
                }
    }
}
