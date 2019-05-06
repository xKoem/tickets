package pl.xkoem.tickets.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.xkoem.tickets.models.TicketType;

import java.util.List;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Integer> {
    List<TicketType> findAll();
}
