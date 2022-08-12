package blind.matrix;

/**
 * Created by Anindita Banik on 8/10/22.
 */
public class Transpose {
    public int[][] transpose(int[][] matrix) {

        int R = matrix.length;
        int C = matrix[0].length;

        if(R!=C){
            int[][] tMatrix = new int[C][R];
            for(int i=0;i<C;i++)
                for(int j=0;j<R;j++)
                    tMatrix[i][j]=matrix[j][i];
            return tMatrix;
        } else{
            int[][] tMatrix = new int[R][C];
            for(int i = 0; i<R; i++)
                for(int j = i+1; j<C; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            return matrix;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };
        Transpose t = new Transpose();
        int[][] tMat = t.transpose(matrix);
        System.out.println(tMat);
    }
}
