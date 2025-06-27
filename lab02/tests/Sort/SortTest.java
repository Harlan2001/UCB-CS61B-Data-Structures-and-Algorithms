package Sort;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class SortTest {
    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(input, 0);
        assertThat(actual).isEqualTo(expected);

        String[] input2 = {"there", "are", "many", "pigs"};
        int expected2 = 1;

        int actual2 = Sort.findSmallest(input2, 0);
        assertThat(actual2).isEqualTo(expected2);
    }

    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};

        Sort.swap(input, a, b);
        assertThat(expected).isEqualTo(input);
    }

    public static void main(String[] args){
        testFindSmallest();
        testSwap();
    }
}
