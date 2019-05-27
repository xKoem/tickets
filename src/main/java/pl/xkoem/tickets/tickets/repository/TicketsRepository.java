package pl.xkoem.tickets.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.xkoem.tickets.models.TicketEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketsRepository extends JpaRepository<TicketEntity, Integer> {
    List<TicketEntity> findAll();

    Optional<TicketEntity> findById(Integer id);
}
