# Tickets app

Rest ticketEntities app with possibility to browse, buy and manage ticketEntities.

Swagger url
`http://[app_url]/swagger-ui.html`

## Rest endpoints:

POST `/populate` - populates database

GET `/tickets` - returns all tickets  
POST `/tickets` - create new ticket
    
GET `/tickets/{id}` - returns ticket with specified id  
PUT `/tickets/{id}` - updates a ticket with specified id  
DELETE `/tickets/{id}` - removes a ticket with specified id  

POST `/tickets/code` - creates a new ticket_code and pair with a ticket with specified id  
GET `/tickets/{id}/code` - gets first ticket code for specified ticket id

GET `/tickets/{id}/buy` - returns a ticket_private_key from ticketEntity with specified id, marks ticketEntity as waiting for payment  
POST `tickets/buy` returns ticket_code when payment has been transferred successfully, updates sold value to true
message: TicketPrivateKey 

POST `/pay` - pays for ticketEntity
message: TicketPrivateKey

## Database:

`http://[app_url]/h2-console`

## Design patterns examples:
1. Builder - `pl.xkoem.tickets.models.TicketEntity.Ticket.Builder`
2. Static factory method `pl.xkoem.ticketEntities.models.City.valueOf()`
3. Factory - `pl.xkoem.ticketEntities.utils.randomtextgenerator.RandomTextGeneratorFactory`
4. Dependency injection - almost every service e.g. `pl.xkoem.tickets.tickets.TicketsServiceImpl`
5. Decorator - `pl.xkoem.tickets.purchase.KeysAwaitingService`