package demo.Library.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This name is not a valid name")
public class IncompletePath extends RuntimeException{

}
