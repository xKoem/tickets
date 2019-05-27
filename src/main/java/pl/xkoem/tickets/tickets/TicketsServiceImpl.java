package pl.xkoem.tickets.tickets;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.xkoem.tickets.models.TicketCodeEntity;
import pl.xkoem.tickets.models.TicketEntity;
import pl.xkoem.tickets.tickets.repository.TicketCodeRepository;
import pl.xkoem.tickets.tickets.repository.TicketsRepository;

import java.util.List;

@Service
public class TicketsServiceImpl implements TicketsService {

    private final TicketsRepository ticketsRepository;
    private final TicketCodeRepository ticketCodeRepository;

    public TicketsServiceImpl(TicketsRepository ticketsRepository, TicketCodeRepository ticketCodeRepository) {
        this.ticketsRepository = ticketsRepository;
        this.ticketCodeRepository = ticketCodeRepository;
    }

    @Override
    public ResponseEntity<List<TicketEntity>> getTickets() {
        return ResponseEntity.ok(ticketsRepository.findAll());
    }

    @Override
    public ResponseEntity<TicketEntity> createTicket(TicketEntity ticketEntity) {
        var savedTicket = ticketsRepository.saveAndFlush(ticketEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);
    }

    @Override
    public ResponseEntity<TicketEntity> getTicket(String id) {
        return ResponseEntity.ok(getTicketEntity(id));
    }

    @Override
    public ResponseEntity<TicketCodeEntity> getTicketCode(String id) {
        //TODO: should be replaced with marking tickets as bought mechanism, and should only look for available ticket codes
        return ResponseEntity.ok(ticketCodeRepository.findFirstByTicketEntityId(Integer.valueOf(id)));
    }

    @Override
    public ResponseEntity<TicketCodeEntity> addTicketCode(TicketCodeEntity ticketCodeEntity) {
        ticketCodeRepository.saveAndFlush(ticketCodeEntity);
        return ResponseEntity.ok(ticketCodeEntity);
    }

    @Override
    public ResponseEntity<TicketEntity> updateTicket(String id, TicketEntity newTicket) {
        TicketEntity ticket = getTicketEntity(id);
        BeanUtils.copyProperties(newTicket, ticket);
        ticket.setId(Integer.valueOf(id));
        return ResponseEntity.ok(ticketsRepository.saveAndFlush(ticket));
    }

    @Override
    public ResponseEntity<TicketEntity> deleteTicket(String id) {
        TicketEntity ticket = getTicketEntity(id);
        List<TicketCodeEntity> ticketCodes = ticketCodeRepository.findByTicketEntityId(Integer.valueOf(id));
        ticketCodes.stream()
                .map(TicketCodeEntity::getId)
                .forEach(ticketCodeRepository::deleteById);

        ticketsRepository.deleteById(Integer.valueOf(id));
        return ResponseEntity.ok(ticket);
    }

    private TicketEntity getTicketEntity(String id) {
        try {
            Integer idValue = Integer.valueOf(id);
            return ticketsRepository.findById(idValue).orElseThrow(IdNotFoundException::new);
        } catch (NumberFormatException e) {
            throw new IdNotFoundException();
        }
    }
}
