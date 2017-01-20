package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static set.RemoveDuplicates.uniqueElements;

public class testRemoveDuplicates {
    private int[] test;
    private int[] check;


/* @Before
   public void setUp() throws Exception{
       test = new int[]{};
       check = new int[]{};
   }*/


  @After
   public void tearDown() throws Exception{
      test = null;
      check = null;
   }

    @Test
    public final void testEmpty(){
        test = new int[]{};
        check = new int[]{};
        assertArrayEquals("false if RemoveDuplicates is can't handle empty", check, uniqueElements(test));
    }

    @Test
    public final void  testOneTypeOfNumber(){
        test = new int[]{2,2,2,2,2,2,2,2,2,2,2,2};
        check = new int[]{2};
        assertArrayEquals("false if RemoveDuplicates can't handle multiple 2's", check, uniqueElements(test));

    }

    @Test
    public final void  testLotsOfNumbers(){
        test = new int[]{1,6,89,3,2,3,6,7,8,34,100,12};
        check = new int[]{1,2,3,6,7,8,12,34,89,100};
        assertArrayEquals("false if RemoveDuplicates can't sort and remove duplicates from an array with numbers", check, uniqueElements(test));
    }

    @Test
    public final void  testAlreadySorted(){
        test = new int[]{1,2,3,3,3,4,5,5,6,7};
        check = new int[]{1,2,3,4,5,6,7};
        assertArrayEquals("false if RemoveDuplicates makes any changes to an already sorted", check, uniqueElements(test));
    }

    @Test
    public final void  testAllUnique(){
        test = new int[]{5,1,3,2,4,7,6};
        check = new int[]{1,2,3,4,5,6,7};
        assertArrayEquals("false if RemoveDuplicates makes any changes to an already sorted array with only unique numbers", check, uniqueElements(test));
    }
}
