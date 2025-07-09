public interface MyStack<E> {
    void push(E element);       // adds an element to the top of the stack
    E pop();        // removes and returns the top element of the stack
    boolean isEmpty();          // returns true if the stack is empty
    int size();         // returns the number of elements in the stack



    // inserts the item at the bottom of the stack using push, pop, isEmpty, and size
    private void insertAtBottom(E item) {
        if(isEmpty()){
            push(item);
        }
        else{
            E top = pop();             // 先拿出顶部
            insertAtBottom(item);      // 递归到底插入
            push(top);                 // 再把拿出的放回去
        }
    }

    // flips the stack upside down (hint: use insertAtBottom)
    default void flip() {
        if (!isEmpty()) {
            E top = pop();      // 取出栈顶
            flip();             // 递归翻转剩下的
            insertAtBottom(top); // 把当前元素放到底部
        }
    }
}