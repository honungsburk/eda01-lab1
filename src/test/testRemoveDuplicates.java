package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static set.RemoveDuplicates.uniqueElements;

public class testRemoveDuplicates {
    private int[] test;
    private int[] check;

    private boolean testAgainst(int[] xs, int[] expected){
        boolean isEqual = true;
        int[] test = uniqueElements(xs);
        int i = 0;

            while (i < test.length && isEqual) {
                if (expected[i] != test[i]) isEqual = false;
                i++;
            }

        return isEqual;
    }

/*  @Before
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
        assertTrue("false if RemoveDuplicates is can't handle empty", testAgainst(test, check));
    }

    @Test
    public final void  testOneTypeOfNumber(){
        test = new int[]{2,2,2,2,2,2,2,2,2,2,2,2};
        check = new int[]{2};
        assertTrue("false if RemoveDuplicates can't handle multiple 2's", testAgainst(test, check));
    }

    @Test
    public final void  testLotsOfNumbers(){
        test = new int[]{1,6,89,3,2,3,6,7,8,34,100,12};
        check = new int[]{1,2,3,6,7,8,12,34,89,100};
        assertTrue("false if RemoveDuplicates can't sort and remove duplicates from an array with numbers", testAgainst(test, check));
    }

    @Test
    public final void  testAlreadySorted(){
        test = new int[]{1,2,3,3,3,4,5,5,6,7};
        check = new int[]{1,2,3,4,5,6,7};
        assertTrue("false if RemoveDuplicates makes any changes to an already sorted", testAgainst(test, check));
    }

    @Test
    public final void  testAllUnique(){
        test = new int[]{5,1,3,2,4,7,6};
        check = new int[]{1,2,3,4,5,6,7};
        assertTrue("false if RemoveDuplicates makes any changes to an already sorted array with only unique numbers", testAgainst(test, check));
    }
}
