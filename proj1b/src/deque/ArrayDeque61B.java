package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T> {
    int nextFirst;
    int nextLast;
    int size;
    int cap;
    T[] deque;

    public ArrayDeque61B(int cap) {
        this.nextFirst = 0;
        this.nextLast = 1;
        this.size = 0;
        this.cap = cap;
        this.deque = (T[]) new Object[cap];
    }

    @Override
    public void addFirst(T x) {
        size++;
        if(size > cap){
            resizeUp();
        }
        this.deque[nextFirst] = x;
        nextFirst = Math.floorMod(nextFirst - 1, cap);

    }

    @Override
    public void addLast(T x) {
        size++;
        if(size > cap){
            resizeUp();
        }

        this.deque[nextLast] = x;
        nextLast = Math.floorMod(nextLast + 1, cap);
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>(cap);
        for(int i = 0; i < cap; i++){
            returnList.add(this.get(i));
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T removeFirst() {
        if (this.size == 0){
            return null;
        }

        size--;
        nextFirst = Math.floorMod(this.nextFirst + 1, cap);
        T temp = deque[nextFirst];
        deque[nextFirst] = null;

        if(cap >= 16 && size <= (cap/4)){
            resizeDown();
        }



        return temp;
    }

    @Override
    public T removeLast() {
        if (this.size == 0){
            return null;
        }

        size--;
        nextLast = Math.floorMod(this.nextLast - 1, cap);
        T temp = deque[nextLast];
        deque[nextLast] = null;

        if(cap >= 16 && size <= (cap/4)){
            resizeDown();
        }
        return temp;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > 7){
            return null;
        }
        return deque[index];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

    public void resizeUp() {
        int newCap = cap * 2;
        T[] newDeque = (T[]) new Object[newCap];

        // 重新按顺序复制元素
        for (int i = 0; i < size - 1; i++) {
            newDeque[i] = deque[Math.floorMod(nextFirst + 1 + i, cap)];
        }

        deque = newDeque;
        cap = newCap;
        nextFirst = newCap - 1;
        nextLast = size;
    }


    public void resizeDown() {
        int newCap = cap / 4;
        T[] newDeque = (T[]) new Object[newCap];

        for (int i = 0; i < size; i++) {
            newDeque[i] = deque[Math.floorMod(nextFirst + 1 + i, cap)];
        }

        deque = newDeque;
        cap = newCap;
        nextFirst = size - 1;
        nextLast = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    public class ArrayDequeIterator implements Iterator<T>{
        public int curr;

        public ArrayDequeIterator(){
            curr = 0;
        }

        @Override
        public boolean hasNext() {
            return curr < size;
        }

        @Override
        public T next() {
            T item = get(curr);
            curr++;
            return item;
        }
    }
}
