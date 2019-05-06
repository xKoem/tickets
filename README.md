# Tickets app

Rest tickets app with possibility to browse, buy and manage tickets.

Swagger url
`http://[app_url]/swagger-ui.html`

## Rest endpoints:

GET `/tickets` - returns all tickets  
message: {type: string, city: string, seller: string} - returns filtered tickets  
POST `/tickets` - create new ticket (requires permissions)  
message: Ticket object
    
GET `/tickets/{id}` - returns ticket with specified id  
POST `/tickets/{id}` - creates a new ticket_code and pair with a ticket with specified id  
PUT `/tickets/{id}` - updates a ticket with specified id  
DELETE `/tickets/{id}` - removes a ticket with specified id  

GET `/tickets/{id}/buy` - returns a ticket_private_key from ticket with specified id, marks ticket as waiting for payment

GET `tickets/buy` returns ticket_code when payment has been transferred successfully, updates sold value to true
message: {ticket_private_key: string}

GET `/pay` - pays for ticket
message: {ticket_private_key: string}

## Database:


## Design patterns examples:
1. Builder - `pl.xkoem.tickets.models.Ticket.Builder`
2. Static factory method `pl.xkoem.tickets.models.City.valueOf()`
3. Factory - `pl.xkoem.tickets.utils.randomtextgenerator.RandomTextGeneratorFactory`