package practice.random;

/**
 * Created by Anindita Banik on 8/27/22.
 */
public class RotateBox {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;

        char[][] res = new char[cols][rows];

        //first rotate
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++){
                res[j][i] = box[rows-i-1][j];
            }

        //second drop from bottom to top
        for (int i = res.length - 1; i >= 0; i--) {
            for (int j = 0; j < res[0].length; j++) {
                if (res[i][j] == '#') {
                    int curRow = i;
                    while (curRow+1 < cols && res[curRow+1][j] == '.') {
                        curRow++;
                    }
                    if (curRow != i) {
                        res[curRow][j] = '#';
                        res[i][j] = '.';
                    }
                }
            }
        }

        //(0,0)=>(0,0), (0,1)=>(1,0), (0,2)=>(2,0), 2-j
        // (0,0)=>(0,1),
        // (0,1)=>(1,1),
        // (0,2)=>(2,1)
        // (1,0)=>(0,0)
        // (1,1)=>(1,0)
        return res;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'#','.','*','.'},
                {'#','#','*','.'}};
        RotateBox rb = new RotateBox();
        char[][] res = rb.rotateTheBox(matrix);

        for(int i=0;i<res.length;i++) {
            System.out.print("[");
            for (int j = 0; j < res[0].length; j++) {
                System.out.print("'" + res[i][j] + "',");
            }
            System.out.println("]");
        }
    }
}
