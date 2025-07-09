public class Pokemon {
    public String name;
    public int level;
    public static String trainer = "Ash";
    public static int partySize = 0;

    public Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
        this.partySize += 1;
    }

    public static void main(String[] args) {
        Pokemon p = new Pokemon("Pikachu", 17);
        Pokemon j = new Pokemon("Jolteon", 99);
        System.out.println("Party size: " + Pokemon.partySize);
        p.printStats();
        int level = 18;
        Pokemon.change(p, level);
        p.printStats();
        Pokemon.trainer = "Ash";
        j.trainer = "Cynthia";
        p.printStats();
    }

    public static void change(Pokemon poke, int level) {
        poke.level = level;
        level = 50;
        poke = new Pokemon("Luxray", 1);
        poke.trainer = "Team Rocket";
    }

    public void printStats() {
        System.out.println(name + " " + level + " " + trainer);
    }

    /** Returns a new array containing the elements of A shifted k positions to the right. */
    public static int[] rotate(int[] A, int k) {
        int rightShift = k % A.length;
        if (rightShift < 0) {
            rightShift += A.length;
        }
        int[] newArr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int newIndex = (rightShift + i) % A.length;
            newArr[newIndex] = A[i];
        }
        return newArr;
    }

}