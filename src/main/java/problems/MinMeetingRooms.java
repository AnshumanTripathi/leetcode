package problems;

import java.util.Arrays;

public class MinMeetingRooms {
  public static void main(String[] args) {
//    System.out.println(minMeetingRooms(new int[][]{{4,5}, {1,4}}));
    System.out.println(minMeetingRooms(new int[][]{{0,30}, {5,10}, {15,20}}));
  }
  public static int minMeetingRooms(int[][] intervals) {
    int meetingRooms = 0;
    int currentEnd = 0;
    Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0]));
    int[] firstMeeting = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= firstMeeting[1] && intervals[i][0] < currentEnd) {
        currentEnd = firstMeeting[1];
        meetingRooms++;
      }
      firstMeeting = intervals[i];
    }
    return meetingRooms;
  }
}
