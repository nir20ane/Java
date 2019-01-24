/*Count the number of prime numbers less than a non-negative number, n.
Example:
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.*/
//Method: count primes - Sieve of Eratosthenes
public class Count_Primes {
	public static int count_primes(int n)
	{
		int count = 0;
		// boolean array primes
		Boolean[] primes = new Boolean[n];
		// return 0 if n<2
		if(n<2) return 0;
		// initialize array with true
		for(int i=2;i<n;i++)
		{
			primes[i] = true;
		}
		// 0 and 1 are not prime
		primes[0] = primes[1] = false;
		// check only till sqrt(n)
		for(int i=2;i*i<n;i++)
		{
			// only if prime, make all mutilpes of prime as false
			if(primes[i]) {
			for(int j=i*i;j<n;j+=i)
			{
				primes[j] = false;
			}}
		}
		// count primes
		for(int i=2;i<n;i++)
		{
			if(primes[i]) 
			{
			count+=1;
		}}
		// return count
		return count;
	}
// main function and function call	
	public static void main(String[] args)
	{
		System.out.println(count_primes(10));
	}

}
