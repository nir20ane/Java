/* Meeting Rooms
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
determine if a person could attend all meetings.
Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
*/
package leetcodenew;

import java.util.Arrays;

public class MeetingRooms {
	public boolean meetingrooms(int[][] meetings)
    {
    	int n = meetings.length;
    	int[] start = new int[n];
    	int[] end = new int[n]; 
    	
    	for(int i=0; i<n;i++)
    	{
    		start[i] = meetings[i][0];
    		end[i] = meetings[i][1];    		
    	}
    	Arrays.sort(start);
    	Arrays.sort(end);
    	for(int i=1;i<n;i++)
    	{
    		if(start[i] < end[i-1])
    		{
    			return false;
    		}
    	}
    	return true;
    }
    
	public static void main(String[] args)
	{
		MeetingRooms meetroom = new MeetingRooms();
		int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
		System.out.println(meetroom.meetingrooms(meetings));
		int[][] meetings1 = {{7, 10}, {2, 4}};
		System.out.println(meetroom.meetingrooms(meetings1));
	}
}
