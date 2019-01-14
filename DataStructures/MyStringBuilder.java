/* Implemented StringBuilder in Java using char[] arrays
 * append function will check if array needs to be re sized and appends the string to character array

*/
import java.util.Arrays;

public class MyStringBuilder {
	
	// declared defacult count, capacity and char array
	private static final int DEFAULT_CAPACITY = 10;
	private char[] mystringbuilder;
	int count = 0;
	
	// default constructor
	public MyStringBuilder()
	{
		mystringbuilder = new char[DEFAULT_CAPACITY];
	}
	
	// constructor overloading with size
	public MyStringBuilder(int size)
	{
		mystringbuilder = new char[size];
		
	}
	
	// constructor overloading with String
	public MyStringBuilder(String str)
	{
		mystringbuilder = str.toCharArray();
		
	}
	
	// constructor overloading with character array
	public MyStringBuilder(char[] str)
	{
		mystringbuilder = str;
		
	}
	
	// append method to keep adding string and to increase capacity if neececd
	public String append(String str)
	{
		if((count + str.length()) <= mystringbuilder.length)
		{
			resize();
		}
		char[] newstringbuilder = str.toCharArray();
		System.arraycopy(newstringbuilder, 0, mystringbuilder, count, newstringbuilder.length);
		
		for (int i = 0; i < newstringbuilder.length; i++) {
			count += 1;
		}
		return Arrays.toString(mystringbuilder);
	}
	
	// Resize  method with help in resizing the character array
	public void resize()
	{
		char[] resizestringbuilder = new char[mystringbuilder.length * 2];
		System.arraycopy(mystringbuilder, 0, resizestringbuilder, 0, mystringbuilder.length);
		mystringbuilder = resizestringbuilder;
	}
	
	// Main function to test the StringBuilder append 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStringBuilder mysb = new MyStringBuilder();
		System.out.println(mysb.append("Java"));
		System.out.println(mysb.append("Programming"));
		System.out.println(mysb.append("Data Structure"));
	}

}
