# Restful Web Service with Spring Boot

Spring Starter Web ,project lombok , jackson-dataformat , jwt, h2

## Major changes happened in versions

  1.0.0 :

 - Exception Handler is added
 - List is used to store data
 
 1.0.1:
 
 - H2 Database Configuration is added
 - Employee entity added
 
 1.0.2
 - Employee entity is enhanced
 - Authentication and Authorization with JWT feature is addded

## Installation


```bash
git clone [url]
mvn spring-boot:run
```

## Usage
  - Public API: no need for authentication `GET http://localhost:9999/api/public/`
  To access the protected resource , use token issued by server after authenticated .
  
  - To authenticate ` GET http://localhost:9999/api/authenticate?username=root&password=123  `
  
   _

> To access the protected resource , use token issued by server after authenticated .
>    include  the folowing {header : value } information into each request
>    Authorization:Bearer "jwt-token"

_
   
   **You will get token in header of response**
` Authorization →Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtb2JpbGUtYXBwLWFwaSIsImF1ZCI6Im1vYmlsZS1hcHAtY2xpZW50cyIsInN1YiI6InJvb3QiLCJleHAiOjE1ODE0Mjc2MTUsInJvbCI6WyJST0xFX0FETUlOIl19.1SieTMr5adzx6NZ1ec815-PfxS9896U3TZVldRGWg6A`
   
   Use this information  , and send it in each request to access protected resource

```
 - GET - Getting resource     -- /api/employees or api/employees/{employeeID}
 - PUT - Creating new resource -- api/employees
 - POST - Updating resource   -- /api/employees/{employeeID}
 - DELETE -Remove resource   --  /api/employees/{employeeID}
```
   

Example :  **with token in the request header**
`- GET - Getting resource     -- /api/employees `

```
[
    {
        "firstName": "ADMIN",
        "lastName": "ADMIN",
        "email": "ADMIN@test.com",
        "id": 1,
        "hiring_date": "2020-02-01T13:11:50.467+0000",
        "department_id": 90,
        "salary": 9999999
    },
    {
        "firstName": "Steven",
        "lastName": "King",
        "email": "SKING@yahoo.com",
        "id": 100,
        "hiring_date": "2003-06-16T19:00:00.000+0000",
        "department_id": 90,
        "salary": 24000
    },
.....
]
```




## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
