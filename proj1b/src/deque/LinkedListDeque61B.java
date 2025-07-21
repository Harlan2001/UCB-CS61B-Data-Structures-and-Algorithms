package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<T> {
        public int curr;

        public LinkedListIterator(){
            this.curr = 0;
        }

        @Override
        public boolean hasNext() {
            return (curr < size -1);
        }

        @Override
        public T next() {
            T currentItem = get(curr);
            curr ++;
            return currentItem;
        }
    }


    private class Node{
        public T item;
        public Node prev;
        public Node next;

        public Node(T item){
            this.item = item;
            next = null;
            prev = null;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque61B() {
        this.sentinel = new Node(null);
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
        this.size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node newnode = new Node(x);
        newnode.prev = sentinel;
        newnode.next = sentinel.next;
        sentinel.next.prev = newnode;
        sentinel.next = newnode;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node newnode = new Node(x);
        newnode.next = sentinel;
        newnode.prev = sentinel.prev;
        sentinel.prev.next = newnode;
        sentinel.prev = newnode;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node n;
        n = sentinel.next;
        while(n != sentinel){
            returnList.add(n.item);
            n = n.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        if(sentinel.next == sentinel){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T removeFirst() {
        if(size == 0){
            return null;
        }
        Node tempnode = sentinel.next;
        sentinel.next = tempnode.next;
        tempnode.next.prev = sentinel;
        tempnode.prev = null;
        tempnode.next = null;

        size--;
        return tempnode.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node tempnode = sentinel.prev;
        sentinel.prev = tempnode.prev;
        tempnode.prev.next = sentinel;
        tempnode.prev = null;
        tempnode.next = null;

        size--;

        return tempnode.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > (size - 1)) {
            return null;
        }

        Node tempnode = sentinel.next;;

        while(index > 0){
            tempnode = tempnode.next;
            index--;
        }
        return tempnode.item;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(Node node, int index) {
        if (node == sentinel) {
            return null; // 到达哨兵，索引越界
        }
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
}
