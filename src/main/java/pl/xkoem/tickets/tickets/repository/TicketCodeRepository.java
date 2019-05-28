package pl.xkoem.tickets.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.xkoem.tickets.models.TicketCodeEntity;

import java.util.List;

@Repository
public interface TicketCodeRepository extends JpaRepository<TicketCodeEntity, Integer> {
    List<TicketCodeEntity> findAll();

    List<TicketCodeEntity> findByTicketEntityId(Integer id);

    TicketCodeEntity findFirstByTicketEntityId(Integer id);
}
