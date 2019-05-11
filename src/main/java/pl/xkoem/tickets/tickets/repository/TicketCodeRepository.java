package pl.xkoem.tickets.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.xkoem.tickets.models.TicketCode;

import java.util.List;

@Repository
public interface TicketCodeRepository extends JpaRepository<TicketCode, Integer> {
    List<TicketCode> findAll();
}
