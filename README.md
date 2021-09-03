# Spring-Boot-Rest-JPA-H2DB-App-

ADD(POST): http://localhost:8080/api/add 
LIST(GET): http://localhost:8080/api/
UPDATE(POST):http://localhost:8080/api/update
DELETE(POST):http://localhost:8080/api/delete
LIST BY ID(GET):http://localhost:8080/api/products/{id}

json example add or update:
{
  "id": 1,
  "name": "example",
  "category": "example",
  "stock": 5,
  "active": true,
  "description": "example"
}
