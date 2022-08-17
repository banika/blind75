package blind.interval;

/**
 * Created by Anindita Banik on 8/17/22.
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (overlap(intervals[i], intervals[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean overlap(int[] interval1, int[] interval2) {
        return (Math.min(interval1[1], interval2[1]) >
                Math.max(interval1[0], interval2[0]));
    }
}
