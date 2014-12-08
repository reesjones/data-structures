data-structures
===============

Various sorting algorithms and data structures created at the North Carolina School of Science and
Mathematics in CS410 (data structures).

**Sort.java** contains merge bubble sorting algorithms, namely *mergeSort()* and *bubbleSort()*. It also contains
*randomArray(int size)* for testing purposes.


### DuhList.java
An array-based data structure with functionality similar to ArrayList. It utilizes generics and implements the **IList.java** interface.

### DuhListTester.java
The testing class used for testing and debugging **DuhList.java**. See the **ListTester.java** description below.

### DuhLinkedList.java
LinkedList data structure implementing the **IList.java** interface.

### DuhHashTable.java
HashTable data structure implementing the **IList.java** interface.

### Node.java
The object used as the LinkedList elements in **DuhLinkedList.java**. Contains getters, setters, and *getNext()*/*setNext()* methods.



## Interfaces

### IList.java
The interface used for all data structure implementations above. It is based mostly on the ArrayList specification, excluding methods
that were too in-depth and that we did not have time to implement.

### ListTester.java
The interface used for all testing classes. Methods in the interface focus on scalability by testing the time required to complete tasks
such as adding many items to a list and reversing the order of the elements.

Unit testing was not covered in the class or in prerequisite classes, so we did not do any proper unit testing in this project.


## Sorting

### Sort.java
A static class with public methods *mergeSort()*, *bubbleSort()*, and *randomArray()*. It can be used to generate and sort arrays.
