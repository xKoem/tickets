package pl.xkoem.tickets.database;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    private final DatabaseService databaseService;

    public DatabaseController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @PostMapping(value = "populate")
    private ResponseEntity populateDatabase() {
        return databaseService.populateDatabase();
    }

}
