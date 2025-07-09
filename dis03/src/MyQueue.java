import java.util.Comparator;

public interface MyQueue<E> {
    void enqueue(E element);        // adds an element to the end of the queue
    E dequeue();        // removes and returns the front element of the queue
    boolean isEmpty();    // returns true if the queue is empty
    int size();    // returns the number of elements in the queue


    // removes all items from the queue
    default void clear() {
        while(!isEmpty()){
            dequeue();
        }
    }

    // removes all items equal to item from the queue
    // the remaining items should be in the same order as they were before
    default void remove(E item) {
        int originalsize = size();
        for(int i = 0; i < originalsize; i++){
            E e = dequeue();
            if(e == null){
                //e为空，如果做e.equal(item)的判断，会空指针异常
                if(item != null){
                    enqueue(item);
                }
                //两者都是空，不管
            }
            else{
                if(!e.equals(item)){
                    enqueue(item);
                }
            }
        }
    }

    // returns the maximum element in the queue according to the comparator
    // the items in the queue should be in the same order as they were before
    // assume the queue is not empty
    default E max(Comparator<E> c) {
        int originalsize = size();

        E e1 = dequeue();
        enqueue(e1);
        for (int i = 0; i < originalsize - 1; i++) {
            E e2 = dequeue();
            enqueue(e2);
            if (c.compare(e1, e2) < 0) {
                e1 = e2;
            }
        }
        return e1;
    }
}