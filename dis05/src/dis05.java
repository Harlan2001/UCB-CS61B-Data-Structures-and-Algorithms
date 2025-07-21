// Desired Runtime: Theta(N)
public static void f1(int N) {
    for (int i = 1; i < N; i++){
        System.out.println("hi Dom");
    }
}

// Desired Runtime: Theta(log N)
public static void f2(int N) {
    for (int i = 1; i < N; i = i * 2) {
        System.out.println("howdy Ergun");
    }
}
// Desired Runtime: Theta(1)
public static void f3(int N) {
    for (int i = 1; i < 2; i += 1) {
        System.out.println("hello Anniyat");
    }
}

// Desired Runtime: Theta(2^N)
// This one is tricky! Hint: think about the dominating term in 1 + 2 + 4 + 8 + ... + f(N)
public static void f4(int N) {
    for (int i = 1; i <= Math.pow(2, N); i *= 2) {
        for (int j = 0; j < i; j += 1) {
            System.out.println("what's up Alyssa");
        }
    }
}

//best: N^3*logM
//worst: N^3*M
public static void f5(int N) {
    for (int i = 0; i < N; i += 1) {
        for (int j = 1; j <= M; ) {
            if (kachow()) { //Θ(𝑁2)
                j += 1;
            } else {
                j *= 2;
            }
        }
    }
}

// N
public static int curse(int n) {
    if (n <= 0) {
        return 0;
    } else {
        return n + curse(n - 1);
    }
}

//logN * N
public static void silly(int[] arr) {
    if (arr.length <= 1) {
        System.out.println("You won!");
        return;
    }
    int newLen = arr.length / 2;
    int[] firstHalf = new int[newLen];
    int[] secondHalf = new int[newLen];
    System.arraycopy(arr, 0, firstHalf, 0, newLen);
    System.arraycopy(arr, newLen, secondHalf, 0, newLen);
    silly(firstHalf);
    silly(secondHalf);
}

// 3 ^ N
public void ronnie(int N) {
    if (N <= 1) {
        return;
    }
    ronnie(N - 2);
    ronnie(N - 2);
    ronnie(N - 2);
    exponentialWork(N); // Runs in $Theta(3^N)$ time
}

//
public void f5(int N){
    for (int i = 1; i < N; i = i + 1) {
        for (int j = 1; j < i; j = j + 1) {
            System.out.println("This is one is low key hard");
        }
    }
}

//
public void f5(int N){
    for (int i = 1; i < N; i = i * 2) {
        for (int j = 1; j < 2; j = j * 2) {
            System.out.println("This is one is mid key hard");
        }
    }
}

// Θ(2^𝑁)
public void f5(int N){
    for (int i = 1; i < N; i = i + 1) {
        for (int j = 1; j < Math.pow(2,i); j = j + 1) {
            System.out.println("This is one is high key hard");
        }
    }
}

//N^3
public void f5(int N){
    for (int i = 1; i < Math.pow(2, N); i = i * 2) {
        for (int j = 1; j < N * N; j = j = j + 1) {
            System.out.println("yikes");
        }
    }
}

//
void g(int N, int x) {
    if (N == 0) {
        return;
    }
    for (int i = 1; i <= x; i++) {
        g(N - 1, i);
    }
}

//g(N, 1): Θ(N)

//g(N, 2): Θ(N^2)

//
void g(int N, int x) {
    if (N == 0) {
        return;
    }
    for (int i = 1; i <= f(x); i++) {
        g(N - 1, x);
    }
}
//g(N, 2): Ω(N), 𝑂(2 ^ N)
//g(N, N): Ω(N), 𝑂(____)