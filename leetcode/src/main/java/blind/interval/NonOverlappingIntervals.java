package blind.interval;

import java.util.Arrays;

/**
 * Created by Anindita Banik on 8/17/22.
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b)->Integer.compare(a[0],b[0]));
        int end = intervals[0][1], prev = 0, count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                if (intervals[prev][1] > intervals[i][1]) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }
        return count;
    }
}
