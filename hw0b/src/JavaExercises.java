import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class JavaExercises {

    /** Returns an array [1, 2, 3, 4, 5, 6] */
    public static int[] makeDice() {
        return new int[] {1, 2, 3, 4, 5, 6};
    }

    /** Returns the order depending on the customer.
     *  If the customer is Ergun, return ["beyti", "pizza", "hamburger", "tea"].
     *  If the customer is Erik, return ["sushi", "pasta", "avocado", "coffee"].
     *  In any other case, return an empty String[] of size 3. */
    public static String[] takeOrder(String customer) {
        String[] order;
        if (Objects.equals(customer, "Ergun")){
            order = new String[] { "beyti", "pizza", "hamburger", "tea" };
        }
        else if(Objects.equals(customer, "Erik")){
            order = new String[] { "sushi", "pasta", "avocado", "coffee" };
        }
        else{
            order = new String[] { "", "", "" };
        }
        return order;
    }

    /** Returns the positive difference between the maximum element and minimum element of the given array.
     *  Assumes array is nonempty. */
    public static int findMinMax(int[] array) {
        int maximum = array[0];
        int minimum = array[0];

        for(int item : array){
            if(item > maximum){
                maximum = item;
            }
            if(item < minimum){
                minimum = item;
            }
        }

        return maximum - minimum;
    }

    /**
      * Uses recursion to compute the hailstone sequence as a list of integers starting from an input number n.
      * Hailstone sequence is described as:
      *    - Pick a positive integer n as the start
      *        - If n is even, divide n by 2
      *        - If n is odd, multiply n by 3 and add 1
      *    - Continue this process until n is 1
      */
    public static List<Integer> hailstone(int n) {
        return hailstoneHelper(n, new ArrayList<>());
    }

    private static List<Integer> hailstoneHelper(int x, List<Integer> list) {
        list.add(x);
        if(x == 1){
            return list;
        }
        int next = (x % 2 == 0) ? (x / 2) : (3 * x  + 1);
        return(hailstoneHelper(next, list));
    }

}
