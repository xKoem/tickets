package pl.xkoem.tickets.tickets;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Id not found")
class IdNotFoundException extends RuntimeException {
}
