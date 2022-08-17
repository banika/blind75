package blind.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Anindita Banik on 8/17/22.
 */
public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (Integer.compare(a[0], b[0])));
        PriorityQueue<Integer> queue = new PriorityQueue<>(); //dont need store all int[] but just end time
        for (int[] interval : intervals) {
            if (!queue.isEmpty() && queue.peek() <= interval[0]) queue.poll();
            queue.offer(interval[1]);
        }
        return queue.size();
    }
}
