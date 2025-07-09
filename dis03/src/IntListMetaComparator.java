import java.util.Comparator;

public class IntListMetaComparator implements Comparator<IntList> {
    private Comparator<Integer> c;

    public IntListMetaComparator(Comparator<Integer> givenC) {
        this.c = givenC;
    }


    /* Returns negative number if more items in x are less,
          Returns positive number if more items in x are greater.
          If one list is longer than the other, extra items are ignored. */
    public int compare(IntList x, IntList y) {
        if ((x == null) || (y == null)) {
            return 0;
        }

        int compValue = c.compare(x.first, y.first);

        if (compValue > 0) {
            return compare(x.rest, y.rest) + 1;
        } else if (compValue < 0) {
            return compare(x.rest, y.rest) -1;
        } else {
            return compare(x.rest, y.rest);
        }
    }
}