package myhashtable;

public class MyHashTable {
	private static int size = 26;
    private HashEntry[] entries = new HashEntry[size];
	
    public void put(String key, String value)
    {
    	HashEntry item = new HashEntry(key, value);
    	int itemhash = gethash(key);
    	if(entries[itemhash] == null)
    	{
    		entries[itemhash] = item;
    	}
    	else
    	{
    		HashEntry temp = entries[itemhash];
    		while(temp.next != null)
    		{
    			temp = temp.next;
    		}
    		temp.next = item;
    	}
    }
    
    public String get(String key)
    {
    	int itemhash = gethash(key);
    	if(entries[itemhash] != null)
    	{
    	HashEntry temp = entries[itemhash];
    	while(!temp.key.equals(key) && temp.next != null)
    	{
    		temp = temp.next;

    	}
    	return temp.value;
    	}
    	return null;
    }
    
    public void delete(String key)
    {
    	int itemhash = gethash(key);
    	if(entries[itemhash] != null)
    	{
    	HashEntry temp = entries[itemhash];
    	HashEntry prev = null;
    	while(!temp.key.equals(key) && temp.next != null)
    	{
    		prev = temp;
    		temp = temp.next;

    	}
    	if (temp.key.equals(key)) 
        {
            if (prev == null)
                entries[itemhash] = temp.next;
            else
                prev.next = temp.next;
        }
    	}
    }
    
    public void printHasTable()
    {
    	for (int i = 0; i < entries.length; i++)
        {
            System.out.print("\nBucket "+ (i) +" : ");
            HashEntry entry = entries[i];
            while (entry != null)
            {
                System.out.print(entry.value +" --> ");
                entry = entry.next;
            }  
            System.out.print("null");
        }
    }
    
	public static class HashEntry{
			String key;
			String value;
			HashEntry next;
			HashEntry(String key, String value)
			{
				this.key = key;
				this.value = value;
			}
	}
	
	public int gethash(String key)
	{
	    return key.hashCode()%size;
	}
	public static void main(String[] args) {
		MyHashTable myht = new MyHashTable();
		for(int i=0;i<30;i++)
		{
			myht.put(String.valueOf(i), String.valueOf(i));
		}
		myht.printHasTable();
		System.out.println();
		System.out.println(myht.get(String.valueOf(10)));
		System.out.println(myht.get(String.valueOf(15)));
		myht.delete(String.valueOf(15));
		myht.printHasTable();
	}
}
