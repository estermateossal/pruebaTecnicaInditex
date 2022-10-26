# pruebaTecnicaInditex
Repository storing the Inditex technical test code.

##Initializing Application
Using maven wrapper:

> ./mvnw clean spring-boot:run

Using your installed maven version:

> mvn clean spring-boot:run

When the app starts, you can immediately interrogate it.

###Examples
####GET ALL
* curl -v localhost:8080/pricesByDate
  
####GET ONE
> curl -v localhost:8080/pricesByDate/1

> curl -v localhost:8080/pricesByDate/2

> curl -v localhost:8080/pricesByDate/3

> curl -v localhost:8080/pricesByDate/4

####GET PRICE BY DATE, PRODUCT_ID AND BRAND_ID
> curl -v "localhost:8080/priceByDateProductAndBrand/?date=2020-06-14-16.00.00&productId=35455&brandId=1"

####POST
> curl -X POST localhost:8080/pricesByDate -H 'Content-type:application/json' -d '{"id": 5, "brandId": 1, 
  "startDate": "2020-06-13T22:00:00.000+00:00", "endDate": "2020-12-31T22:59:59.000+00:00", "priceList": 1, 
  "productId": 35455, "priority": 0, "price": 35.5, "curr": "EUR"}'

####PUT
> curl -X PUT localhost:8080/pricesByDate/6 -H 'Content-type:application/json' -d '{"priority": 0}'

####DELETE
> curl -X DELETE localhost:8080/pricesByDate/3
> 
> curl localhost:8080/pricesByDate/3 