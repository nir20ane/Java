package leetcodenew;

import java.util.HashMap;

public class RomantoInteger {
    public int romanToInt(String s) {
        char[] X = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int val = 0;
        int n = X.length;
        int i =0;
        while(i<n)
        {
            if(i+1<n && (map.get(X[i]) < map.get(X[i+1])))
            {
                val += map.get(X[i+1]) - map.get(X[i]);
                i += 2;
            }
            else
            {
              val += map.get(X[i]);
              i += 1;  
            }
        }
       return val; 
    }
    public static void main(String[] args)
    {
    	RomantoInteger ri = new RomantoInteger();
    	System.out.println(ri.romanToInt("III"));
    }
}
