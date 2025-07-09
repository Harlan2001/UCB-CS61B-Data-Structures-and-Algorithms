public class IntList {
    IntList rest;

    public IntList(){

    }

    public static IntList reverse(IntList lst){

        return lst;
    }

    public static IntList[] interweave(IntList lst, int k) {
        IntList[] array = new IntList[k];
        int index = k- 1;
        IntList L = reverse(lst); // Assume reverse is implemented correctly
        while (L != null) {
            IntList prevAtIndex = array[index];
            IntList next = L.rest;
            array[index] = L;
            array[index].rest = prevAtIndex;
            L = next;
            index-= 1;
            if (index < 0) {
                index = k-1;
            }
        }
        return array;
    }

}
