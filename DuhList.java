import java.util.Collection;
import java.util.Iterator;

/*
 * @author CS 410 T3 2013-2014
 * @created 2014_03_10
 * @modified 2014_03_28
 * 
 */

// In order to implement an ArrayList we will need an array
// Array should be mutable
// We need to know where we are for the iterator
// We need to know current length

public class DuhList<E> implements IList<E>, Iterator<E>
{
  // The Array
  private Object[] duhArray;
  
  // Number of elements currently in the array
  private int duhSize;
  
  // The current position of the IList iterator
  private int duhIterPos;
  
  public DuhList()
  {
    this(10);
  }
  
  public DuhList(int initialSize)
  {
    duhSize = 0;                   //Length is the number of elements to put in
    duhIterPos = 0;                //Position of the pointer for the iterator
    duhArray = new Object[initialSize];
  }
  
  private DuhList(Object[] oa)
  {
    duhArray = oa;
    duhIterPos = 0;
    duhSize = oa.length;
  }
  
//    private int max(int lhs, int rhs)
//    {
//         return lhs > rhs ? lhs : rhs;
//    }
  
  private int chooseNewSize(int n)
  {
    return Math.max(2*n, 1);
  }
  
  private void changeSize()
  {
    Object[] newArray = new Object[chooseNewSize(duhArray.length)];
    arrayCopy(duhArray, 0, newArray, 0, duhArray.length);
    duhArray = newArray;   
  }
  
  //Will throw index out of bounds exception if there is not enough space in the destination or length is larger than src
  private static void arrayCopy(Object[] src, int srcPos, Object[] dest, int destPos, int numElements)
  {
    //TODO: Make this actually work!
    //This works if Source and Destination are different, but has issues if they are the same
    
    if(srcPos < destPos)
    {
      //Shifting from the left to the right which means we need to start from the right
      //This copies from right to left (which means it doesn't work if you are shifting to the left (remove))
      
      for(int i = srcPos + numElements - 1; i >= srcPos; i--) //iterates through starting position through the length we want copied
      {
        dest[i + (destPos-srcPos)] = src[i];
      }
    }
    else
    {
      //This copies from left to right (which means it doesn't work if you are shifting to the right (adding))
      for(int i = srcPos; i < (srcPos + numElements); i++) //iterates through starting position through the length we want copied
      {
        dest[destPos + i - srcPos] = src[i]; //the (i - srcPos) is a counter that goes from 0 to length
      }
    }
  }
  
  public void add(E e)
  {
    add(duhSize, e);
// Remove later when we feel more confident that this is the correct way to solve this.
//      if(duhSize >= duhArray.length)
//      {
//          changeSize();
//      }
//      duhArray[duhSize] = e;
//      duhSize++;
  }
  
  public void add(int index, E e)
  {
    if(duhSize >= duhArray.length)
    {
      changeSize();
    }
    arrayCopy(duhArray, index, duhArray, index+1, duhSize - index);
    duhArray[index] = e;
    duhSize++;
  } 
  
  @SuppressWarnings("unchecked")
  public E remove(int index)
  {
    E ret = (E)duhArray[index];
    arrayCopy(duhArray, index+1, duhArray, index, duhSize - index);
    duhSize--;
    return ret;
  } 
  /*
   * removes first insance of the object o.
   */
  public boolean remove(Object o)
  {
    for(int k =0; k < duhSize; k++)
    {
      if(o.equals(duhArray[k]))
      {
        remove(k);
        return true;
      }
    }
    return false;
  } 
  
  public boolean removeAll(Collection<?> c)
  {
    boolean flag = false;
    for(Object thang: c)
    {
      while(remove(thang))
      {
        flag = true;
      }
    }
    return flag;
  }
  
  //returns true if this DuhList changes in the process.
  public boolean retainAll(Collection<?> c)
  {
    /*
     boolean flag = false;
     
     for(int i = duhSize-1; i >= 0 && duhSize > 0; i--)
     {
     System.out.println(i);
     
     if(!c.contains(duhArray[i]))
     {
     remove(i);
     flag = true;
     }
     
     }
     return flag;
     */
    /*        
     for(Object cElement : c)
     {
     if(!contains(cElement))
     {
     while(remove(cElement))
     {
     flag = true;
     }
     }
     }
     return flag;
     */      
    
    
    
    System.out.printf("duhsize = %s\n", duhSize);
    boolean flagellate = false;
    for(int k = 0; k < duhSize; k++)
    {
      for(Object thang: c)
      {
        boolean flag2 = false;
        //System.out.printf("duhsize = %s\n", duhSize);
        if(!thang.equals(duhArray[k])) {  //if our current element
          remove(k--);
          flagellate = true;
        }
      }
    }
    return flagellate;
    
  } 
  
  public int size()
  {
    return duhSize;
  } 
  
  public void clear()
  {
    duhSize = 0;
    duhArray = new Object[duhArray.length];
  } 
  
  public boolean isEmpty()
  {
    return duhSize == 0;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index)
  {
    //TODO make this suck less
    
    
    return (E)duhArray[index];
  } 
  
  @SuppressWarnings("unchecked")
  public E set(int index, E element)
  {
    E displaced = (E)duhArray[index];
    duhArray[index] = element;
    return displaced;
  } 
  
  public Object[] toArray()
  {
    Object[] newArray = new Object[duhSize];
    arrayCopy(duhArray, 0, newArray, 0, duhSize-1);
    return newArray;
  } 
  
  public boolean contains(Object o)
  {
    return indexOf(o) != -1;
  } 
  
  public IList<E> subList(int fromIndex, int toIndex)
  {
    if(fromIndex > toIndex)
    {
      throw new IllegalArgumentException();
    }
    Object[] newArray = new Object[toIndex-fromIndex];
    arrayCopy(duhArray, fromIndex, newArray, 0, toIndex-fromIndex);
    return new DuhList<E>(newArray);
  } 
  
  public boolean equals(Object o)
  {

    //Just for morrison :)
    if(!(o instanceof DuhList)) { return false; }
    DuhList other = (DuhList)o;
    if(this.duhSize != other.size()) { return false; }
    for(int i = 0; i < duhSize; i++) {
      if(duhArray[i] != null) {
        if(!duhArray[i].equals(other.get(i))) {
          return false;
        }
      }
      else if(other.get(i) != null) {
        return false;
      }
    }
    return true;
    
    /*
     if(!(o instanceof DuhList))
     {
     return false;
     }
     
     DuhList other = (DuhList)o;
     
     if(this.duhSize != other.size())
     {
     return false;
     }
     
     
     for(int i = 0; i < duhSize; i++)
     {
     if(duhArray[i] != null)
     {
     if(!duhArray[i].equals(other.get(i)))
     {
     return false;
     }
     }
     else if(other.get(i) != null)
     {
     return false;
     }
     
     }
     return true;
     */
  } 
  
  public int indexOf(Object o)
  {
    return indexOf(0, o);
  } 
  
  public int indexOf(int startIndex, Object o)
  {
    //If o is null, search for null in the array.
    if(o == null)
    {
      for(int i = startIndex; i < duhSize; i++)
      {
        if(duhArray[i] == null)
        {
          return i;
        }
      }
      //If null wasn't found in the DuhList, return -1
      return -1;
    }
    
    //o is not null, therefore we can call .equals on it.
    for(int i = startIndex; i < duhSize; i++)
    {
      if( o.equals(duhArray[i]) )
      {
        return i;
      }
    }
    return -1;
  } 
  
  public int lastIndexOf(Object o)
  {
    //If o is null, search for null in the array.
    if(o == null)
    {
      for(int i = duhSize-1; i >= 0; i--)
      {
        if(duhArray[i] == null)
        {
          return i;
        }
      }
      //If null wasn't found in the DuhList, return -1
      return -1;
    }
    
    //o is not null, therefore we can call .equals on it.
    for(int i = duhSize-1; i >= 0; i--)
    {
      if( o.equals(duhArray[i]) )
      {
        return i;
      }
    }
    return -1;
  } 
  
  
  public Iterator<E> iterator()
  {
    return this;
  }
  
  @Override
  public String toString()
  {
    if(duhSize <= 0)
    {
      return "[]";
    }
    
    String out = "[";
    // duhSize-1 to prevent fencepost comma
    for(int i = 0; i < duhSize - 1; i++)
    {
      out += duhArray[i] + ", ";
    }
    out += duhArray[duhSize-1] + "]";
    return out;
  }
  
  
  public boolean hasNext()
  {
    return duhIterPos < duhSize;
  }
  
  @SuppressWarnings("unchecked")
  public E next()
  {
    return (E)duhArray[duhIterPos++];
  }
  
  public void remove()
  {
    
  }
  
  
}
