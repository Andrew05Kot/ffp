# _DISH microservice_
This service is intended for working with Dishes.

A Dish can have name, description, ingredients, and also belong to a certain category.

## Structure

The three-level architecture is the basis of the Dish-microservice structure


### Basic layers of architecture:

1. DAL - Data Access Layer
    - dao
    - repository
1. BLL - Business Logical Layer
   - service
1. API
   1. mobile api
   2. backoffice api

### Data Access Layer
Database access level. Responsible for working with repositories.

### Business Logical Layer
The layer responsible for working with the business logic of the application.

Uses the DTO model to use different objects for the database and for the context

### API layer
The request processing layer.

It also contains API services to work with responses and requests.

2 separate APIs are supported for the backoffice and for the mobile application.
