### KÜHNE + NAGEL INTERNSHIP PROJECT - Order Management System API

## Description
This project is an API for an Order Management System. 
It is a RESTful API.
The API is built using the Spring REST framework. 
The API is connected to a PostgreSQL database. 
The API is also connected to a Swagger UI that allows the user to interact with the API.


## Installation
To run the API, you need to have Java 17 or higher installed on your machine.
You also need to have a PostgreSQL database running on your machine.
You can download the database from [here](https://www.postgresql.org/download/).

To run the API, you need to do following steps:
1. Clone the repository
2. Open the project in your IDE
3. Open the `src.main.resources.application.properties` file and change the database connection properties 
to match your database connection properties
4. Initialize the database by running the `database.reset_database.sql` script in your database
5. Run script `database.create.sql` to create the tables in the database
6. Run script `database.import.sql` to import the data into the database
7. Run the application
8. Open the Swagger UI in your browser by going to `http://localhost:8080/swagger-ui.html`
9. You can now interact with the API


## Usage
The API has 7 endpoints:
 - `/users/create` - POST request - creates a new user
 - `/products/create` - POST request - creates a new product
 - `/orders/create` - POST request - creates a new order
 - `/orders/update` - PATCH request - updates an existing order
 - `/orders/by-user?userId={userId}` - GET request - returns all orders for a user
 - `/orders/by-product?productId={productId}` - GET request - returns all orders for a product
 - `/orders/by-date?date={date}` - GET request - returns all orders for a date

The API has 3 models:
    - User
    - Product
    - Order

The API has 7 services:
 - On business layer:
    - UsersService 
    - OrdersService 
    - ProductsService
 - On data access layer:
   - UserService
   - OrderService
   - OrderLineService
   - ProductService

The API has 5 repositories:
    - UserRepository
    - ProductRepository
    - OrderRepository
    - OrderLineRepository

The API has 3 controllers:
    - UserController
    - ProductController
    - OrderController

The API has 9 DTOs:
    - User
        -  UserCreateRequest
    - Product
        - ProductCreateRequest
    - Order
        - OrderByDateResponse
        - OrderByProductResponse
        - OrderByUserResponse
        - OrderCreateRequest
        - OrderLineByUserResponse
        - OrderLineCreateRequest
        - OrderLineQuantityUpdateRequest


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.


## License
[MIT](https://choosealicense.com/licenses/mit/)



 


