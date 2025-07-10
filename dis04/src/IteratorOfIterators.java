import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class IteratorOfIterators implements Iterator {
    private List<Iterator<Integer>> iterators;
    private int curr;

    public IteratorOfIterators(List<Iterator<Integer>> a) {
        iterators = new LinkedList<>();
        for (Iterator<Integer> i : a) {
            if (i.hasNext()) {
                this.iterators.add(i);
            }
        }
        curr = 0;
    }

    @Override
    public boolean hasNext() {
        return !iterators.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Iterator<Integer> currIterator = iterators.get(curr);
        int result = iterators.get(curr).next();
        if (!currIterator.hasNext()) {
            iterators.remove(curr);
            if (curr >= iterators.size()) {
                curr = 0;
            }
        } else {
            curr = (curr + 1) % iterators.size();
        }
        return result;
    }
}
