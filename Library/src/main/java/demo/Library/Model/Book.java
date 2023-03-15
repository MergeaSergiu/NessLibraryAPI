package demo.Library.Model;


import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book>{

    private String title;

    private String author;

    public static List<Book> booklist = new ArrayList<>();

    public static List<Book> getBooklist() {
        return booklist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == this)
        {
            return true;
        }
        if (!(obj instanceof Book))
            return false;

        Book book = (Book) obj;
        return this.author.equals(book.author) && this.title.equals(book.title);
    }

    @Override
    public String toString()
    {
        return "Book-> " + "title: " + this.getTitle() + ", author: " + this.getAuthor() + "\n";
    }

    @Override
    public int compareTo(Book otherBook)
    {
        int titleCompare = this.title.compareTo(otherBook.getTitle());
        if( titleCompare != 0)
        {
            return  titleCompare;
        }
        return this.author.compareTo(otherBook.getAuthor());
    }

}
