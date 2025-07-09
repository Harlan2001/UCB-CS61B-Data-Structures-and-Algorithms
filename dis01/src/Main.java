class Book {
    public String title;
    public Library library;
    public static Book last = null;

    public Book(String name) {
        title = name;
        last = this;
        library = null;
    }

    public static String lastBookTitle() {
        return last.title;
    }

    public String getTitle() {
        return title;
    }
}

class Library {
    public Book[] books;
    public int index;
    public static int totalBooks = 0;

    public Library(int size) {
        books = new Book[size];
        index = 0;
    }

    public void addBook(Book book) {
        books[index] = book;
        index++;
        totalBooks++;
        book.library = this;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Library.totalBooks);
//        System.out.println(Book.lastBookTitle());
//        System.out.println(Book.getTitle());
        Book goneGirl = new Book("Gone Girl");
        Book fightClub = new Book("Fight Club");
        System.out.println(goneGirl.title);
        System.out.println(Book.lastBookTitle());
        System.out.println(fightClub.lastBookTitle());
        System.out.println(goneGirl.last.title);
        Library libraryA = new Library(1);
        Library libraryB = new Library(2);
        libraryA.addBook(goneGirl);
        System.out.println(libraryA.index);
        System.out.println(libraryA.totalBooks);
        libraryA.totalBooks = 0;
        libraryB.addBook(fightClub);
        libraryB.addBook(goneGirl);
        System.out.println(libraryB.index);
        System.out.println(Library.totalBooks);
        System.out.println(goneGirl.library.books[0].title);
    }
}

