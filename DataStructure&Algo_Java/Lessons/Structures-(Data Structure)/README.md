# When to Choose Which Structure

# Use Arrays When:
-You know the maximum size in advance
-You need random access by index
-Memory efficiency is critical

Use Linked Lists When:
*You frequently insert/delete from middle
*Size changes frequently
*You don't need random access

Use Hash Tables When:
-You need fastest possible lookups
-Order doesn't matter
-You have good hash function

Use Trees When:
-You need sorted data
-You need range queries
-You want guaranteed O(log n) performance

Use Graphs When:
-You're modeling relationships
-You need path finding
-You're working with networks

=======================================================

Memory Complexities
Structure	Space	Notes
Array	O(n)	Contiguous memory
LinkedList	O(n)	Extra pointers (next/prev)
Hash Table	O(n)	Load factor affects performance
Binary Tree	O(n)	Each node has pointers
Graph	O(V+E)	Depends on representation

=======================================================
