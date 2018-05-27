package bookpack;

public class BookDemo {
    public static void main(String args[]) {
        Book books[] = new Book[5];
        books[0] = new Book("Java beginners", "Schildt", 2014);
        books[1] = new Book("Java pro", "Schildt", 2014);
        books[2] = new Book("arto of java", "Schildt and Holmes", 2003);
        books[3] = new Book("LOTR", "Tolkien", 1968);
        books[4] = new Book("Java beginners", "Schildt", 2014);
        //for (int i=0; i<books.length; i++) books[i].show();
        for (int i=0; i < books.length; i++) books[i].show();
    }
}

class Book{
    private String title;
    private String author;
    private int pubDate;

    Book(String title, String author, int pubDate){
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
    }

    void show(){
        System.out.println(title);
        System.out.println(author);
        System.out.println(pubDate);
        System.out.println();
    }
}
