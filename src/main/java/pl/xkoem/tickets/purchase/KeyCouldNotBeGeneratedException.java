package pl.xkoem.tickets.purchase;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT, reason = "Key could not be generated, please try again later.")
class KeyCouldNotBeGeneratedException extends RuntimeException {
}
