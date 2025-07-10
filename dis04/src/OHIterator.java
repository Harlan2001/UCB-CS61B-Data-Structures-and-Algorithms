import java.util.Iterator;
import java.util.NoSuchElementException;

public class OHIterator implements Iterator {
    private OHRequest curr;

    public OHIterator(OHRequest request) {
        this.curr = request;
    }

    public static boolean isGood(String description) { return description.length() >= 5; }

    @Override
    public boolean hasNext() {
        while (this.curr != null && !isGood(curr.description)) {
            this.curr = this.curr.next;
        }
        return curr != null;
    }

    @Override
    public OHRequest next() {
        if (curr.next == null) {
            throw new NoSuchElementException();
        }
        OHRequest temp = curr;
        curr = curr.next;
        if (curr.description.contains("thank u")) {
            curr = curr.next;
        }
        return temp;
    }
}
