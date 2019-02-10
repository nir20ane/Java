/*Meeting Rooms II
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.
Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Example 2:
Input: [[7,10],[2,4]]
Output: 1
*/
package leetcodenew;

import java.util.Arrays;

public class MeetingRoomsII {
    public int meetingrooms(int[][] meetings)
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
    	int rooms = 0;
    	int free = 0;
    	for(int i=0;i<n;i++)
    	{
    		if(start[i] < end[free])
    		{
    			rooms += 1;
    		}
    		else
    		{
    			free += 1;
    		}
    	}
    	return rooms;
    }
    
	public static void main(String[] args)
	{
		MeetingRoomsII meetroom = new MeetingRoomsII();
		int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
		System.out.println(meetroom.meetingrooms(meetings));
		int[][] meetings1 = {{7, 10}, {2, 4}};
		System.out.println(meetroom.meetingrooms(meetings1));
	}
}
