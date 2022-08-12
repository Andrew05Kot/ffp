# ORDER microservice
This is a microservice for working with orders

The order is formed on the basis of the selected list of Dishes, which add up to the Total Amount

Before starting the Microservice, you need to execute the command:
`mvn compile`

### Backoffice API

| Endpoint Description                                                | Path                                |
|:--------------------------------------------------------------------|:------------------------------------|
| Get all orders (Optional(Pagination), Optional(expandFields))       | `api/vi/ordering`                   |
| Get by Id                                                           | `api/vi/ordering/{id}`              |
| Statistics (Optional(startDate), Optional(endDate))                 | `api/vi/ordering/statistic`         |   


### Mobile API

| Endpoint Description                                                | Path                                |
|:--------------------------------------------------------------------|:------------------------------------|
| Creare order                                                        | `api/mobile/v1/ordering`            |
