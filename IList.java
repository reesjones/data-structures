import java.util.*;
/**
 * @author NCSSM CS 410 T3 class
 *
 */
public interface IList<E> extends Iterable
{
     
    /** This adds an element to the end of the list
     * 
     * @param e the element being added to the list
     */
    public void add(E e);
     
     
    /** This adds the element e to the list at index
     * 
     * @param index integer representing the position in the list
     * @param e the element being added to the list
     */
    public void add(int index, E e);
   
   
    /** Removes the element at the position stated. Shifts all elements after it to the left one
     *
     * @param index is the position of the element being deleted
     * @return the removed element
     * @throws IndexOutOfBoundsException
     */
    public E remove(int index);
  
     
    /** Removes the FIRST occurence of the specified element (ie .equals()).
     *
     * @param o is the element that is being searched for in the list
     * @return true if the first occurence is deleted, and false if the element is not in the IList
     */
    public boolean remove(Object o);
 
    /** Removes any element in this IList that is also in the Collection c
     * @param c is the Collection of elements to be removed
     * @return true if at least one element is removed from this IList
     */
    public boolean removeAll(Collection<?> c);
     
    /** Intersects the existing IList<E> with a Collection<?> c
     * passed in such that only elements contained in both the IList
     * and the Collection are retained.
     * 
     * @param c the Collection<?> to be intersected with this IList
     * @return a boolean representing whether the operation did or did not complete successfully
     */
    public boolean retainAll(Collection<?> c);
                      
    /** The size function returns the integer number of elements in this IList.
     */
    public int size();
     
    /** Removes all elements from this IList and reduces size to 0.
     * 
     */
    public void clear();
     
    /** Returns true if the list contains no elements.
     * @return true if the list contains no elements
     */
    public boolean isEmpty();
     
    /** Returns the element with type E at the given index
     * @author D Block Data Structures
     * @param index  The postion of the desired element within the list 
     * @return   Returns the element with type E at the given index
     * @throws   Throws IndexOutOfBounds exception if the index is out of the range of the list 
     *
     */
    public E get(int index);
                         
    /** Puts element at index in the IList
     * @param index  The postion of the pointer which points at the desired position within the list    
     * @param element   The element that the user wishes to store into the list 
     * @return   Returns the element with type E at the given index
     * @throws   Throws IndexOutOfBoundsException if the index is out of the range of the list
     * @throws   Throws IllegalArgumentException if the element the user wishes to input has a property that will not allow it to be store it into the list 
     * 
     */
    public E set(int index, E element);
     
     
    /** Returns this IList as an Object[].
     * @return an Object[] containing all elements from this IList, in order.
     */
    public Object[] toArray();
     
    /** This checks if the Object o is in this IList
     * @param o the Object that is being checked for membership in this IList
     * @return true if Object is in IList
     */
    public boolean contains(Object o);
     
    /** Returns a range of the original list from {@code fromIndex} to {@code toIndex}.
     * 
     * @param fromIndex the beginning point of the sublist
     * @param toIndex the end point of the sublist
     * @return a range of the original list
     */
    public IList<E> subList(int fromIndex, int toIndex);
     
 
    /** This checks if the Object o is of the same type of IList.
     * It also checks the equals method of each pair of elements at index 0 to n and returns false if
     * any pair returns false.  Otherwise it returns true indicating that each IList contains the
     * the same elements in the same order.
     * @param o the Object that is checked against IList
     * @return true if Object o is equal to IList
     */
    public boolean equals(Object o);
     
    /** Returns the index of the first occurence of Object o or -1 if the Object is not an element in this IList 
     * @param o the object we are looking for in the IList
     * @return returns the index at which Object o first appears. If the object is not an element of the list, this method returns -1
     * 
     */
    public int indexOf(Object o);
 
    /** returns the index of the first occurence of Object o starting at startIndex or -1 if the Object is not found after startIndex
     * @param o the object we are looking for in the IList
     * @param startIndex the index at which we start looking for Object o
     * @return returns the index at which Object o first appears starting at startIndex. If the object is not an element of the list, this method returns -1
     */
    public int indexOf(int startIndex, Object o);
 
    /** returns the index of the last occurence of Object o or -1 if the Object is not an element of this IList
     * @param o the Object we are looking for in the IList
     * @return returns index with which Object o last appears. If the object is not an element of the list, this method returns -1
     */
    public int lastIndexOf(Object o);
     
    /** Iterator returns an iterator for the elements in this list in the order in which they appear
     */
    public Iterator<E> iterator();
   
   
}
