/* This is the object used as the elements in DuhLinkedList
 * 
 */
public class Node<E> {
  
  private Node<E> next;
  private E element;
  
  public Node() {
    next = null;
    element = null;
  }
  
  public Node(E _element) {
    element = _element;
    next = null;
  }
  
  public E getElement() {
    return element;
  }
  
  public Node<E> getNext() {
    return next;
  }
  
  
  public void setElement(E _element) {
    element = _element;
  }
  
  public void setNext(Node<E> _next) {
    next = _next;
  }
  
  
  @Override
  public String toString() {
    if(element == null) { return "null"; }

    return "{Node:" + element.toString() + "}";
  }
  
}
