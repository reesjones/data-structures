import java.util.Date;
import java.lang.Math;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DuhListTester implements ListTester {
  /**
   * @return the number of miliseconds it takes to add a million elements to the IList
   */
  @SuppressWarnings("unchecked")
  public long addAMillion(IList l) {
    Date girl = new Date();
    long start = girl.getTime();
    
    for(int i = 0; i < 1000000; i++) {
      l.add(i);
    }
    
    
    Date boy = new Date();
    return boy.getTime() - start;
    
  }
  
  /**
   * @return the number of milliseconds it takes to add a billion elements to the IList
   */
  @SuppressWarnings("unchecked")
  public long addABillion(IList l) {
    Date girl = new Date();
    long start = girl.getTime();
    
    for(int i = 0; i < 1000000000; i++) {
      l.add(i);
    }
    
    Date boy = new Date();
    return boy.getTime() - start;
  }
  
  /**
   * @return the number of miliseconds it takes to add n elements to the IList
   */
  @SuppressWarnings("unchecked")
  public long addN(IList l, long n) {
    Date girl = new Date();
    long start = girl.getTime();
    
    for(int i = 0; i < n; i++) {
      l.add(i);
    }
    
    
    Date boy = new Date();
    return boy.getTime() - start;
  }
  
  /**
   * @return the number of milliseconds it takes to 
   * count the number of chars and words in a given file
   */
  @SuppressWarnings("unchecked")
  public long textFileInfo(String fileName, IList charList, IList wordList) {
    Date girl = new Date();
    long start = girl.getTime();
    DuhList<String> words = new DuhList<String>();
    
    try {
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);
      
      String text = "";
      int c;
      while((c = br.read()) != -1) {
        charList.add((char)c);
        text += c;
      }
      
      System.out.println(text);
      String[] anotherWordArray = text.split("\\s+");
      for(String s : anotherWordArray) {
        wordList.add(s);
      }
      System.out.println("words="+wordList);
      
      
    }
    
    catch(FileNotFoundException e) {
      System.out.println("You done messed up, A-Aron! (file not found)");
    }
    catch(IOException e) {
      System.out.println("You done messed up, A-Aron! (IO)");
    }
    
    
    Date boy = new Date();
    return boy.getTime() - start;
  }
  
  /**
   * @return the number of milliseconds it takes to reverse the order of the elements in this list
   */
  @SuppressWarnings("unchecked")
  public long reverseOrder(IList l) {
    Date girl = new Date();
    long start = girl.getTime();
    
    //IList out = new IList();
    for(int i = 0; i < Math.floor(l.size()/2); i++) {
      Object temp = l.get(i);
      l.set(i, l.get(l.size()-i-1));
      l.set(l.size()-i-1, temp);
    }
    
    Date boy = new Date();
    return boy.getTime() - start;
  }
}
