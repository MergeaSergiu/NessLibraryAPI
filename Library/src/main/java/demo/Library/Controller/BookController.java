package demo.Library.Controller;

import demo.Library.Exception.BookAlreadyExist;
import demo.Library.Exception.BookCanNotBeAdd;
import demo.Library.Exception.BookNotFoundException;
import demo.Library.Exception.IncompletePath;
import demo.Library.Model.Book;
import demo.Library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @PostMapping("/book")
    ResponseEntity<Book> addANewBook(@RequestBody Book booktoAdd)
    {
        if(booktoAdd.getTitle() == null || booktoAdd.getTitle().isBlank() || booktoAdd.getAuthor() == null || booktoAdd.getAuthor().isBlank())
        {
            throw new BookCanNotBeAdd();
        }
        if(bookService.getAllBooks().contains(booktoAdd) == false)
        {
            return new ResponseEntity<>(bookService.saveBook(booktoAdd),HttpStatus.CREATED);
        }
        throw new BookAlreadyExist();
    }

    @GetMapping("/books")
    ResponseEntity<List<Book>> returnAllBook()
    {
            return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @DeleteMapping("/book/{title}")
    public ResponseEntity<?> deleteBook(@PathVariable String title)
    {
        if(bookService.getBookByTitle(title) !=null)
        {
            bookService.deleteBook(title);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        throw new BookNotFoundException();
    }

    @GetMapping("/book/{title}")
    ResponseEntity <Book> returnBookByTitle(@PathVariable String title) {
        if( bookService.getBookByTitle(title) != null)
        {
            return new ResponseEntity<>(bookService.getBookByTitle(title),HttpStatus.FOUND);
        }
        throw new BookNotFoundException();
    }
    @PutMapping("/book/{title}")
    ResponseEntity <Book> updateAuthorOfBook( @PathVariable String title, @RequestParam String author)
    {
        if( author == null || author.isBlank() )
        {
            throw new IncompletePath();
        }
        else if(bookService.getBookByTitle(title) != null)
        {
            return new ResponseEntity<>(bookService.updateBookAuthor(title,author), HttpStatus.OK);
        }
        throw new BookNotFoundException();
    }

}
