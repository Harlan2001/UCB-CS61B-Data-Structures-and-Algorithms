import java.util.Iterator;

public class OHQueue implements Iterable<OHRequest> {
    private OHRequest request;

    public OHQueue(OHRequest request) {
        this.request = request;
    }

    @Override
    public Iterator<OHRequest> iterator() {
        return new OHIterator(request);
    }
}