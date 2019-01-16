#  Linked Lists 
1. Like links in chain 
2. Head points to first node
3. first node has data and a pointer, this pointer points to second node
4. second node has data and a pointer, this pointer points to third node and so on

##  Operations on Linked List   
1. PushFront, PopFront, TopFront
2. PushBack, TopBack, PopBack
3. Remove , Empty, Find
4. Add Before, Add After

##   Time for Operations of Singly Linked List  
1. PushFront- O(1)
2. PopFront - O(1)
3. TopFront - O(1)
###   if there is no tail pointer  
1. PushBack - O(n)
2. PopBack - O(n)
3. TopBack - O(n)
###   if there is tail pointer  
1. TopBoack - O(1)
2. PushBack - O(1)
3. PopBack - O(n) - Because we don't know next to last element
*** Head is different as pointer points in a different way/direction of pointing ***

1. Remove - O(n)
2. Empty - O(1)
3. Find - O(n)
4. AddBefore - O(n)
5. AddAfter - O(1)

#  Disadvantages of arrays 
1. Inserting an element at begining or middle takes O(n) time
2. Arrays are of fixed length

#  Disadvantages of Lists 
1. Findind an item in a linked list - takes time proportional to length of list - O(N), where as it takes a constant time

#  Problem finding the nth element of the list 
Use rescursion to traverse through the list

##  Use a List Class Always 
Because we can avoid conflicts
empty lkist is nott possible without List class

#  Advantages of using List class 
1. keeps Track of head
2. keeps trasize
3. No conflicts
  
#  Singly Linked List ADT invariants 
1. Size is always true (size and head fields are private)
2. Never Circularly linked (No node returns head)

#  Doubly Linked List 
1. Inserting or Deleting at front and end is easy
2. Each node points to previous node and next node

## Sentinel 
1. Sentinel is a special node that points to head of first node and tail of last mode
2. it should be an ADT
3. it is a circularly linked list
4. Does not have item but just points to head of first and tail of last

### Inavairants about Sentinel 
1. for an DLIST d, d.head != NULL
2. for any node DLIST Node x, x.head != NULL
3. for any node DLIST Node x, x.prev != NULL
4. for any node DLIST Node x, x.prev == y and y.next == x
5. for any node DLIST Node x, x.next == y and y.prev == x
6. Size that does not count sentinel, size is corrent
7. Empty DList sentinels prev and next point to itself

