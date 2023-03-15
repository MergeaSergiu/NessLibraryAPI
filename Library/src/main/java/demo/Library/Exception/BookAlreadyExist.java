package demo.Library.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "Book already exist")
public class BookAlreadyExist extends RuntimeException {
}