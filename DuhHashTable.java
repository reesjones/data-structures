import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class DuhHashTable<K, V>
{
    private static final int KEYS = 1;
    private static final int VALUES = 2;
    private static final int STRING = 3;


    private int duhSize;
    private double duhLoadFactor;
    private int duhLengthOfDuhLongestListInAllOfDuhBuckets;
    private Object[] duhBuckets;
    private int capacity = 8675309;
//    private int capacity = 17;

    private class DuhPear<K, V>
    {
        private V value;
        private K key;

        public DuhPear(K _key, V _value)
        {
            key = _key;
            value = _value;
        }

        public K getKey()
        {
            return key;
        }

        public V getValue()
        {
            return value;
        }

        public void setValue(V _value)
        {
            value = _value;
        }

        public String toString()
        {
            return key + ": " + value;
        }
        
        public boolean equals(Object o)
        {
            if(!(o instanceof DuhPear))
                return false;
            DuhPear other = (DuhPear) o;
            if(!this.getKey().equals(other.getKey()))
                return false;
            if(this.getValue() == null)
            {
                if(other.getValue() == null)
                    return true;
                else
                    return false;
            }
            return this.getValue().equals(other.getValue());
        }
    }

    public DuhHashTable()
    {
        duhSize = 0;
        duhLoadFactor = .75;
        duhLengthOfDuhLongestListInAllOfDuhBuckets = 0;
        duhBuckets = new Object[capacity];
    }

    public int size()
    {
        return duhSize;
    }

    public boolean containsKey(K key)
    {
        return get(key) != null;
    }

    public boolean containsValue(V value)
    {
        return values().contains(value);
    }

    public void put(K key, V value)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }
        
        DuhPear<K, V> pare = new DuhPear<K, V>(key,value);
        if(addToArray(duhBuckets, pare))
        {
            duhSize++;
        }
        if((double)duhSize/capacity >= duhLoadFactor)
        {
            resize();
        }
    }
    @SuppressWarnings("unchecked")
    public V get(K key)
    {
        int index = Math.abs(key.hashCode())%capacity;
        if(duhBuckets[index] == null) return null;
        for(DuhPear<K, V> ddddd: (LinkedList<DuhPear<K, V>>)duhBuckets[index])
        {
            
            if(ddddd.getKey().equals(key))
            {
                return ddddd.getValue();
            }
        }
        return null;
    }
@SuppressWarnings("unchecked")
    private boolean addToArray(Object[] aa, DuhPear<K, V> dd)
    {
        int index = Math.abs(dd.getKey().hashCode())%aa.length;
        if (aa[index] == null)
        {
            LinkedList<DuhPear<K,V>> list = new LinkedList<DuhPear<K, V>>();
            list.add(dd);
            aa[index] = list;
        }
        else
        {
            for(DuhPear<K,V> pair:(LinkedList<DuhPear<K,V>>)aa[index])
            {
                if(pair.getKey().equals(dd.getKey()))
                {
                    pair.setValue(dd.getValue());
                    return false;
                }

            }
            ((LinkedList<DuhPear<K,V>>) aa[index]).add(dd);
        }

        duhLengthOfDuhLongestListInAllOfDuhBuckets = Math.max(((LinkedList)aa[index]).size(),duhLengthOfDuhLongestListInAllOfDuhBuckets);
        return true;
    }
	
@SuppressWarnings("unchecked")
    private void resize() 
    {
        duhLengthOfDuhLongestListInAllOfDuhBuckets = 0;
        capacity = BigInteger.valueOf(capacity).nextProbablePrime().intValue();
        Object[] newArray = new Object[capacity];
        for(int i = 0; i < duhBuckets.length; i++)
        {
            if(duhBuckets[i] != null)
            {
                for(DuhPear<K,V> dp: (LinkedList<DuhPear<K, V>>)duhBuckets[i])
                {
                    addToArray(newArray, dp);
                }
            }
            
        } 
        duhBuckets = newArray;
    }

    public void clear()
    {
        duhBuckets = new Object[capacity];
        duhLengthOfDuhLongestListInAllOfDuhBuckets = 0;
        duhSize = 0;
    }
@SuppressWarnings("unchecked")
    public Collection<K> keys()
    {
        return (Collection<K>)traverse(KEYS);
    }
       
@SuppressWarnings("unchecked")
    public Collection<V> values()
    {
        return (Collection<V>)traverse(VALUES);
    }
   
    @Override
    public String toString()
    {
        return traverse(STRING).toString();
    }
 
@SuppressWarnings("unchecked")
    public Collection traverse(int whatToDo)
    {
        ArrayList out = new ArrayList(duhSize);
        for (int i = 0; i < duhBuckets.length; i++)
        {
            if (duhBuckets[i] != null)
            {
                for (DuhPear<K,V> dsomething: (LinkedList<DuhPear<K,V>>) duhBuckets[i])
                {
                    switch(whatToDo)
                    {
                        case DuhHashTable.KEYS:
                            out.add(dsomething.getKey());
                            break;
                        case DuhHashTable.VALUES:
                            out.add(dsomething.getValue());
                            break;
                        case DuhHashTable.STRING:
                            out.add(dsomething);
                            break;
                    }
                }
            }
        }
        return out;
    }

    public boolean equals(Object o)
    {
        if(!(o instanceof DuhHashTable))
            return false;
        DuhHashTable other = (DuhHashTable)o;
        ArrayList<DuhPear<K, V>> lhs = (ArrayList<DuhPear<K, V>>)traverse(STRING);
        ArrayList<DuhPear<K, V>> rhs = (ArrayList<DuhPear<K, V>>)other.traverse(STRING);
        for(DuhPear<K, V> lhs_entry : lhs)
        {
            boolean found = false;
            for(DuhPear<K, V> rhs_entry : rhs)
            {
                if(lhs_entry.equals(rhs_entry))
                {
                    rhs.remove(rhs_entry);
                    found = true;
                    break;
                }
            }
            if(!found) return false;
        }
        if(rhs.size() > 0) return false;
        return true;
    }
    

    public static void main(String[] args)
    {
        DuhHashTable<String, String> hashTable = new DuhHashTable<String, String>();        
        
        hashTable.put("Kieran", "Failing Grade");
        hashTable.put("Mitch", "banana");
        hashTable.put("Puja", "strawberry");
        hashTable.put("J-Dawg", "Josh Rees-Jones");
        hashTable.put("Sam", "ultimate");
        hashTable.put("Kieran", "pizza");
        hashTable.put("Teddy", "The Incredibles");
        hashTable.put("Q", "Coffee");
        hashTable.put("Caleb", "Sleep");
        hashTable.put("Josh R-J", "GOOGLE");
        hashTable.put("Ghost of Morrison Past", "GOOGLE");
    
        DuhHashTable<String, String> hashTable2 = new DuhHashTable<String, String>();

        hashTable2.put("Mitch", "banana");
        hashTable2.put("Puja", "strawberry");
        hashTable2.put("J-Dawg", "Josh Rees-Jones");
        hashTable2.put("Sam", "ultimate");
        hashTable2.put("Kieran", "pizza");
        hashTable2.put("Teddy", "The Incredibles");
        hashTable2.put("Q", "Coffee");
        hashTable2.put("Caleb", "Sleep");
        hashTable2.put("Josh R-J", "GOOGLE");
        hashTable2.put("Ghost of Morrison Past", "GOOGLE");
        hashTable2.put("Ghost of Morrison Past", "Cow Pie");
       

        DuhHashTable<String, String> hashTable3 = new DuhHashTable<String, String>();
        DuhHashTable<String, String> hashTable4 = new DuhHashTable<String, String>();
 
        System.out.println(hashTable.size()); 
        System.out.println(hashTable.get("Kieran")); 
        System.out.println(hashTable.get("Q"));
        System.out.println(hashTable.keys());   
        System.out.println(hashTable.values());   
        System.out.println(hashTable.toString());   
        System.out.println(hashTable.containsKey("Q"));
        System.out.println(hashTable.containsKey("Y"));
        System.out.println(hashTable.containsValue("pizza"));
        System.out.println(hashTable.containsValue("Q"));
        System.out.println(hashTable.equals(hashTable2));
        System.out.println(hashTable3.equals(hashTable4));
        
    }
}


