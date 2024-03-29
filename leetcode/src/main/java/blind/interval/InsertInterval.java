package blind.interval;

import java.util.LinkedList;

/**
 * Created by Anindita Banik on 8/17/22.
 */
public class InsertInterval  {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();
        //LinkedList<int[]> output = new LinkedList<int[]>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0])
            result.add(intervals[i++]);
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // we could mutate newInterval here also
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.length) result.add(intervals[i++]);
        return result.toArray(new int[result.size()][2]);
    }
}
