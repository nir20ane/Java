package myhashtable;

public class MyHashMap {
    ListNode[] nodes = new ListNode[100000];
	
    public void put(int key, int value)
    {
    	int hash = gethash(key);
    	
    	if(nodes[hash] == null)
    	{
    		nodes[hash] = new ListNode(-1, -1);
    	}
    	ListNode prev = find(nodes[hash], key);
    	
    	if(prev.next == null)
    	{
    		prev.next = new ListNode(key, value);
    	}
    	prev.next.value = value;
    }
    
    public int get(int key)
    {
    	int hash = gethash(key);
    	if(nodes[hash] == null)
    	{
    		return -1;
    	}
    	ListNode prev = find(nodes[hash], key);
    	if(prev.next == null) return -1;
    	return prev.next.value;
    }
    
    public void remove(int key)
    {
    	int hash = gethash(key);
    	if(nodes[hash] == null)
    	{
    		return;
    	}
    	ListNode prev = find(nodes[hash], key);
    	if(prev.next == null) return;
    	prev.next = prev.next.next;
    }
    
    public ListNode find(ListNode bucket, int key)
    {
    	ListNode node = bucket;
    	ListNode prev = null;
    	while(node != null && node.key != key)
    	{
    		prev = node;
    		node = node.next;
    	}
    	return prev;
    }
    
	public int gethash(int key)
	{
		return Integer.hashCode(key)%nodes.length;
	}
	
	class ListNode
	{
		int key;
		int value;
		ListNode next;
		ListNode(int key, int value)
		{
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	public static void main(String[] args)
	{
		MyHashMap hmap = new MyHashMap();
		for(int i=0;i<30;i++)
		{
			hmap.put(i, i*9);
		}
		System.out.println(hmap.get(8));
		System.out.println(hmap.get(11));
		System.out.println(hmap.get(20));
		hmap.remove(20);
		System.out.println(hmap.get(20));
	}
}
