*** Linked Lists ***
Like links in chain, 
--> Head points to first node
--> first node has data and a pointer, this pointer points to second node
--> second node has data and a pointer, this pointer points to third node and so on
________________________________________________________________________________________________
*** Operations on Linked List ***
--> PushFront, PopFront, TopFront
--> PushBack, TopBack, PopBack
--> Remove , Empty, Find
--> Add Before, Add After
________________________________________________________________________________________________
*** Time for Operations of Singly Linked List ***
--> PushFront - O(1)
--> PopFront - O(1)
--> TopFront - O(1)
if there is no tail pointer:
--> PushBack - O(n)
--> PopBack - O(n)
--> TopBack - O(n)
if there is tail pointer:
--> TopBoack - O(1)
--> PushBack - O(1)
--> PopBack - O(n) - Because we don't know next to last element
** Head is difference as pointer points in a different way of pointing

_______________________________________________________________________________________________|
-- Remove - O(n)
-- Empty - O(1)
-- Find - O(n)
-- AddBefore - O(n)
-- AddAfter - O(1)
_______________________________________________________________________________________________
*** Disadvantages of arrays ***
--> Inserting an element at begining or middle takes O(n) time
--> Arrays are of fixed length
____________________________________________________________________________________________________________________________________________________________________________________________
Disadvantages of Lists:
--> Findind an item in a linked list - takes time proportional to length of list - O(N), where as it takes a constant time
________________________________________________________________________________________________
*** Problem finding the nth element of the list ***
Use rescursion to traverse through the list
________________________________________________________________________________________________________________________________________________________________________________________________
*** Use a List Class Always ***
Because we can avoid conflicts
empty lkist is nott possible without List class
_______________________________________________________________________________________________
*** Advantages of using List class ***
--> keeps Track of head
--> keeps trasize
--> No conflicts
________________________________________________________________________________________________  
*** Singly Linked List ADT invariants ***
--> Size is always true (size and head fields are private)
--> Never Circularly linked (No node returns head)

_______________________________________________________________________________________________
*** Doubly Linked List ***
Inserting or Deleting at front and end is easy
Each node points to previous node and next node
_______________________________________________________________________________________________
*** Sentinel ***
Sentinel is a special node that points to head of first node and tail of last mode
it should be an ADT
it is a circularly linked list
Does not have item but just points to head of first and tail of last
_______________________________________________________________________________________________
*** Inavairants about Sentinel ***
-->for an DLIST d, d.head != NULL
-->for any node DLIST Node x, x.head != NULL
-->for any node DLIST Node x, x.prev != NULL
-->for any node DLIST Node x, x.prev == y and y.next == x
-->for any node DLIST Node x, x.next == y and y.prev == x
-->Size that does not count sentinel, size is corrent
-->Empty DList sentinels prev and next point to itself

