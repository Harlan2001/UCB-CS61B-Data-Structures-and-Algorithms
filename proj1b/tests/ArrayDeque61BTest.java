import deque.ArrayDeque61B;

import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {
    @Test
    public void getTest(){
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>(8);
        deque.addFirst(16);
        deque.addFirst(10);
        deque.addLast(15);
        assertThat(deque.get(-5)).isNull();
        assertThat(deque.get(10)).isNull();
        assertThat(deque.get(1)).isEqualTo(15);
    }

    @Test
    public void sizeTest(){
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>(8);
        assertThat(deque.size()).isEqualTo(0);
        deque.addFirst(16);
        deque.addFirst(10);
        deque.addLast(15);
        assertThat(deque.size()).isEqualTo(3);
    }

    @Test
    public void isEmptyTest(){
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>(8);
        assertThat(deque.isEmpty()).isEqualTo(true);
        deque.addFirst(16);
        deque.addFirst(10);
        deque.addLast(15);
        assertThat(deque.isEmpty()).isEqualTo(false);
    }

    @Test
    public void toListTest(){
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>(8);
        deque.addFirst(20);
        deque.addFirst(10);
        deque.addLast(15);
        deque.addLast(5);
        deque.addLast(25);
        assertThat(deque.toList()).containsExactly(20,15,5,25,null,null,null,10);
    }

    @Test
    public void removeFirstTest(){
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>(8);
        assertThat(deque.removeFirst()).isNull();
        deque.addFirst(20);
        deque.addFirst(10);
        deque.addLast(15);
        deque.addLast(5);
        deque.addLast(25);
        assertThat(deque.removeFirst()).isEqualTo(10);
    }

    @Test
    public void removeLastTest(){
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>(8);
        assertThat(deque.removeLast()).isNull();
        deque.addFirst(20);
        deque.addFirst(10);
        deque.addLast(15);
        deque.addLast(5);
        deque.addLast(25);
        assertThat(deque.removeLast()).isEqualTo(25);
    }

    @Test
    public void resizeUpTest(){
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>(8);
        deque.addFirst(20);
        deque.addFirst(10);
        deque.addFirst(5);
        deque.addLast(15);
        deque.addLast(5);
        deque.addFirst(30);
        deque.addLast(25);
        deque.addFirst(35);
        assertThat(deque.toList()).containsExactly(20,15,5,25,35,30,5,10);
        deque.addFirst(100);
//        assertThat(deque.get(15)).isEqualTo(100);
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeLast();
        deque.removeFirst();
    }
}
