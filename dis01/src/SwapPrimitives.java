public class SwapPrimitives {
    public static void main(String[] args) {
        IntWrapper first = new IntWrapper(6);
        IntWrapper second = new IntWrapper(7);
        swap(first, second);
    }

    public static void swap(IntWrapper first, IntWrapper second) {
        int temp = first.x;
        first.x = second.x;
        second.x = temp;
    }
}