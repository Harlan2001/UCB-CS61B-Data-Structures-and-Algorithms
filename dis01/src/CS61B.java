/** Haha get it...because CS61B is a class...at a public university...I'll see myself out */
public class CS61B {
    // Variables (part a)
    public static String university = "UC Berkley";
    public String semester;
    public CS61BStudent[] students;

    // Constructor (part b)
    public CS61B(int capacity, CS61BStudent[] signups, String semester){
        this.semester = semester;

        int min = Math.min(capacity, signups.length);
        this.students = new CS61BStudent[min];
        System.arraycopy(signups, 0, this.students, 0, min);
    }
    // Methods (part c)
    /** Makes every CS61BStudent enrolled in this semester of the course watch lecture. Returns the
     number of students who actually watched lecture. */
    public int makeStudentsWatchLecture(){
        int watched = 0;

        for(CS61BStudent s : students){
            if(s.watchLecture()){
                watched++;
            }
        }

        return watched;
    }
    /** Takes in a new university name newUniversity and changes the university
     for all semesters of CS61B to newUniversity. */
    public static void changeUniversity(String newUniversity){
        university = newUniversity;
    }
    // Expansion (part d)
    /** Expands the course to the given capacity. */
}