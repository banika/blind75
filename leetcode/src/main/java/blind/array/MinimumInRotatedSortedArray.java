package blind.array;

/**
 * Created by Anindita Banik on 7/31/22.
 */
public class MinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        int start=0,end=num.length-1;

        while (start<end) {
            if (num[start]<num[end])
                return num[start];

            int mid = (start+end)/2;

            if (num[mid]>=num[start]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return num[start];
    }

    public static void main(String[] args) {
        MinimumInRotatedSortedArray mrs = new MinimumInRotatedSortedArray();
        mrs.findMin(new int[]{3,1,2});
    }
}
