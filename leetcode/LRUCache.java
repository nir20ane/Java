/*LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?
Example:
LRUCache cache = new LRUCache( 2 capacity  );
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/
package leetcodenew;

import java.util.HashMap;

public class LRUCache {
	Node head = new Node(0,0);
	Node tail = new Node(0,0);
	int capacity;
	
	HashMap<Integer, Node> map = new HashMap();  // hashMap to store integer and node
	
	LRUCache(int ncapacity)
	{
		capacity = ncapacity;
		head.next = tail;  // constructor for LRUCache
		tail.prev = head;
	}
	
	public void put(int key, int value)
	{
		if(map.containsKey(key))
		{
			remove(map.get(key));  // remove Node if already present
		}
		if(map.size() == capacity)
		{
			remove(tail.prev);  // remove lst element if capacity is exceeded
		}
		insert(new Node(key, value));  // insert Node at head
		
	}
	
	public int get(int key)
	{
		if(map.containsKey(key))
		{
			Node n = map.get(key);  // get and return node value if key node is present
			remove(n);
			insert(n);
			return n.value;  // else return -1
		}
		else
		{
			return -1;
		}
	}
	
	public void remove(Node node)
	{
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev; // remove from map as well as from linked list
	}
	
	public void insert(Node node)
	{
		map.put(node.key, node);
		Node acthead = head.next;  // insert in map as well as linked list
		head.next = node;
		node.next = acthead;
		acthead.prev = node;
		node.prev = head;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
	}
}

