import java.util.Collection;
import java.util.Iterator;

import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;

public class DuhLinkedList<E> implements IList<E>, Iterator<E> {
  int duhSize = 0;
  Node<E> head;
  Node<E> tail;
  Node<E> position;
  
  public DuhLinkedList() {
    head = new Node<E>();
    tail = head;
  }
  
  
  public void add(E e) {
    position = new Node<E>(e);
    
    if(duhSize == 0) {
      head = position;
      tail = position;
    }
    else {
      position = head;
      for(int i = 0; i < duhSize-1; i++) {
        position = position.getNext();
      }
      position.setNext(new Node<E>(e));
      tail = position.getNext();
      
    }
    duhSize++;
  }
  
  
  public void add(int index, E e) {
    if(index < 0 || index > duhSize)
    {
        throw new IndexOutOfBoundsException();
    }
    if(index == duhSize) {   // If adding at the end
      add(e);
      return;
    }
    else if(index == 0) {    // If adding at the start
      position = new Node<E>(e);
      position.setNext(head);
      head = position;
    }
    else {                   // If adding somewhere in the middle
      position = head;
      Node<E> insertedNode = new Node<E>(e);
      
      for(int i = 0; i < index-1; i++) {  // Loop through to get to the node right before the index
        position = position.getNext();
      }
      
      Node<E> end = position.getNext();
      
      position.setNext(insertedNode);
      position = position.getNext(); // position is now the inserted node
      position.setNext(end);     //reattach the trailing end of the list
      
    }
    duhSize++;
  }
  
  public E remove(int index) {
    if(index >= duhSize || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    E element;
    position = head;
    
    if(index == duhSize-1) {     // If removing the last element
      for(int i = 0; i < duhSize-1; i++) {
        position = position.getNext();
      }
      element = position.getElement();      
      position.setNext(null);
      tail = position;
    }
    else if(index == 0) {   // removing first element
      element = head.getElement();
      head = head.getNext();
    }
    else {    // removing from somewhere in the middle
      position = head;
      for(int i = 0; i < index-1; i++) {
        position = position.getNext();
      }
      element = position.getNext().getElement();
      position.setNext(position.getNext().getNext());
    }
    
    duhSize--;
    return element;
  }
  
  public boolean remove(Object o) {
    int index = 0;
    position = head;
    for(int i = 0; i < duhSize; i++) {
     if(position.getElement() == null) {
       if(o == null) {
         remove(index);
         return true;
       }
     } 
     else if(position.getElement().equals(o)) {
        remove(index);  // remove(index) method takes care of head, tail, duhSize, etc.
        return true;
      }
      index++;
      position = position.getNext();
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> c) {
    boolean flag = false;
    for(Object element: c) {
      while(remove(element)) {
        flag = true;
      }
    }
    return flag;
  }
  
  public boolean retainAll(Collection<?> c) {
    boolean hasMatch = false;
    position = head;
    for(int i = 0; i < duhSize; i++)
    {
      for(Object retained: c)
      {
        if(retained == null) {
          if(position.getElement() == null) {
            hasMatch = true;
          }
        }
        else if(retained.equals(position.getElement())) {  // if a collection member isn't equal to a DuhLinkedList member
          hasMatch = true;
        }
      }
      if(!hasMatch) {
        remove(i--);
      }
      position = position.getNext();
      hasMatch = false;
    }
    return !hasMatch;
  }
  
  
  public int size() {
    return duhSize;
  }
  
  
  public void clear() {
    head = new Node<E>();
    tail = head;
    duhSize = 0;
  }
  
  public boolean isEmpty() {
    return duhSize == 0;
  }
  
  public E get(int index) {
    if(index < 0 || index >= duhSize) {
      throw new IndexOutOfBoundsException();
    }
    
    position = head;
    for(int i = 0; i < index; i++) {
      position = position.getNext();
    }
    
    return position.getElement();
  }
  
  public E set(int index, E element) {
    position = head;
    for(int i = 0; i < index; i++) {
      position = position.getNext();
    }
    
    E old = position.getElement();
    position.setElement(element);
    
    return old;
  }
  
  public Object[] toArray() {
    Object[] duhArray = new Object[duhSize];
    position = head;
    for(int i = 0; i < duhSize; i++) {
      duhArray[i] = position.getElement();
      position = position.getNext();
    }
    return duhArray;
  }
  
  public boolean contains(Object o) {
    position = head;
    for(int i = 0; i < duhSize; i++) {
      if(o == null) {
        if(position.getElement() == null) {
          return true;
        }
      }
      if(position.getElement().equals(o)) {
        return true;
      }
      position = position.getNext();
    }
    return false;
  }
  
  
  public IList<E> subList(int fromIndex, int toIndex) {
    if(fromIndex > toIndex || fromIndex < 0 || toIndex < 0 || toIndex >= duhSize) {
      throw new IllegalArgumentException();
    }
    
    position = head;
    for(int i = 0; i < fromIndex; i++) {
      position = position.getNext();
    }
    
    DuhLinkedList<E> out = new DuhLinkedList<E>();
    for(int i = 0; i <= toIndex-fromIndex; i++) {
      out.add(position.getElement());
      position = position.getNext();
    }
    
    return out;
  }
  
  
  public boolean equals(Object o) {
    if(!(o instanceof DuhLinkedList)) {
      System.out.println("EQUALS: !O INSTANCEOF DUHLINKEDLIST");
      return false;
    }
    DuhLinkedList other = (DuhLinkedList)o;
    
    if(this.duhSize != other.size()) {
      System.out.println("EQUALS: DUHSIZE NOT EQUAL");
      return false;
    }
    
    position = head;
    for(int i = 0; i < duhSize; i++) {
      if(position.getElement() != null) {
        if(!position.getElement().equals(other.get(i))) {
          System.out.println("EQUALS: ELEMENT DOES NOT EQUAL AT I=" + i);
          return false;
        }
      }
      else if(other.get(i) != null) {
        System.out.println("EQUALS: NULL IS NOT EQUAL TO TESTED EXTERNAL OBJECT");
        return false;
      }
      position = position.getNext();
    }
    return true;
  }
  
  
  public int indexOf(Object o) {
    return indexOf(0, o);  // startIndex of 0, search for o
  }
  
  public int indexOf(int startIndex, Object o) {
    if(startIndex < 0 || startIndex >= duhSize) {
      throw new IndexOutOfBoundsException();
    }
    
    position = head;  // TODO increment to the starting index    
    
    for(int i = startIndex; i < duhSize; i++) {
      if(o == null && position.getElement() == null) {
        return i;
      }
      else if(position.getElement().equals(o)) {
        return i;
      }
      position = position.getNext();
    }
    return -1;
  }
  

  public int lastIndexOf(Object o) {
    int last = -1;
    position = head;
    if(o == null) {
      for(int i = 0; i < duhSize; i++) {
        if(position.getElement() == null) {
          last = i;
        }
        position = position.getNext();
      }
    }
    else {
      for(int i = 0; i < duhSize; i++) {
        if(position.getElement() != null) {
          if(position.getElement().equals(o)) {
            last = i;
          }
        }
        position = position.getNext();
      }
    }
    return last;
  }
  
  public Iterator<E> iterator() {
    return this;
  }
  
  // TODO implement Iterator method remove
  public void remove() {
    
  }
  
  public E next() {
    return position.getNext().getElement();
  }
  
  public boolean hasNext() {
    return position.getNext() != null;
  }
  
  @Override
  public String toString()
  {
    if(duhSize <= 0)
    {
      return "[]";
    }
    
    String out = "[";
    position = head;
    
    // duhSize-1 to prevent fencepost comma
    for(int i = 0; i < duhSize - 1; i++)
    {
      if(position.getElement() == null) {
        out += "null, ";
      }
      else {
        out += position.getElement().toString() + ", ";
      }
      position = position.getNext();
    }
    
    if(position.getElement() == null) {
      out += "null]";
    }
    else {
      out += position.getElement().toString() + "]";
    }
    
    return out;
  }
  
}
