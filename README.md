# Tickets app

Rest ticketEntities app with possibility to browse, buy and manage ticketEntities.

Swagger url
`http://[app_url]/swagger-ui.html`

## Rest endpoints:

GET `/ticketEntities` - returns all ticketEntities  
message: {type: string, cityEntity: string, seller: string} - returns filtered ticketEntities  
POST `/ticketEntities` - create new ticketEntity (requires permissions)  
message: Ticket object
    
GET `/ticketEntities/{id}` - returns ticketEntity with specified id  
POST `/ticketEntities/{id}` - creates a new ticket_code and pair with a ticketEntity with specified id  
PUT `/ticketEntities/{id}` - updates a ticketEntity with specified id  
DELETE `/ticketEntities/{id}` - removes a ticketEntity with specified id  

GET `/ticketEntities/{id}/buy` - returns a ticket_private_key from ticketEntity with specified id, marks ticketEntity as waiting for payment

GET `ticketEntities/buy` returns ticket_code when payment has been transferred successfully, updates sold value to true
message: {ticket_private_key: string}

GET `/pay` - pays for ticketEntity
message: {ticket_private_key: string}

## Database:

`http://[app_url]/h2-console`

## Design patterns examples:
1. Builder - `pl.xkoem.tickets.models.TicketEntity.Ticket.Builder`
2. Static factory method `pl.xkoem.ticketEntities.models.City.valueOf()`
3. Factory - `pl.xkoem.ticketEntities.utils.randomtextgenerator.RandomTextGeneratorFactory`
4. Dependency injection - almost every service e.g. `pl.xkoem.tickets.tickets.TicketsServiceImpl`
5. Decorator - `pl.xkoem.tickets.purchase.KeysAwaitingService`