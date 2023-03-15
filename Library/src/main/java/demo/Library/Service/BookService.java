package demo.Library.Service;

import demo.Library.Model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {


    public Book saveBook(Book book)
    {
        Book newBook = new Book(book.getTitle(), book.getAuthor());
        if(newBook != null || Book.getBooklist().contains(newBook) == false) {
           Book.getBooklist().add(newBook);
           return newBook;
        }
        return null;
    }

    public List<Book> getAllBooks() {
        Collections.sort(Book.getBooklist());
        return Book.getBooklist();
    }
    public void deleteBook(String title) {
        for (int i = 0; i < Book.booklist.size(); i++) {
            if (Book.getBooklist().get(i).getTitle().equals(title)) {
                Book.getBooklist().remove(Book.getBooklist().get(i));
                break;
            }
        }
    }

    public Book getBookByTitle(String title)
    {
        for(int i = 0 ; i< Book.getBooklist().size(); i++) {
            if(Book.getBooklist().get(i).getTitle().equals(title))
            {
                return Book.getBooklist().get(i);
            }
        }
        return null;
    }


    public Book updateBookAuthor(String title, String author)
    {
        for(int i = 0 ; i < Book.getBooklist().size(); i++)
        {
            if(Book.getBooklist().get(i).getTitle().equals(title))
            {
                Book.getBooklist().get(i).setAuthor(author);
                return Book.getBooklist().get(i);
            }
        }
        return null;
    }
}
