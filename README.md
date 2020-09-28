# city-connectivity


### Overview
 City connectivity Spring Boot application is to check and validate connectivity -  connectivity between any two given
 cities (Origin and Destination).
 
 Program should respond with ‘YES’ if city1 is connected to city2,
 ’NO’ if city1 is not connected to city2.
 Any unexpected input should result in a ’NO’ response.
 

### Build

```
git clone https://github.com/rkbantugit/city-connectivity.git
``` 
 
### Framework used
- Java 8
- SpringBoot 2.3.4
- Maven
- Mockito
- JUnit
 
### Features
This City-Connectivity application reads input from file city.txt (Origin city and destination city)  data.
It will create a set in case 2 Cities are not present in previous set of cities.

for an instance input file city.txt is as below:
 ```text
Boston, NewYork
Philadelphia, Newark
Newark, Boston
Trenton, Albany
```
The program will read this input and will store data as below:
```
[[Boston, NewYork, Philadelphia, Newark],
[Boston, NewYork]]
```

Application will return Response
*  City1 is connected to City2 - 'YES', 
*  City1 is not connected to City2 - 'NO'.
*  Any un matched connectivity input -  ’NO’ response. 
 
### How to use?
*  A Spring Boot Application on port **8080** and expose endpoint:
 http://localhost:8080/connected?origin=<city1>&destination=<city2>
  http://localhost:8080/cityconnectivity?origin=Boston&destination=NewYork
* Application can support -  Uppercase or Lowercase.
* City Connectivity route available between your cities, you will see “YES” in output. The route could be direct link or
 an indirect link.
* ity Connectivity route is not available between given origin and destination city, output
 will be ” NO” .

### Tests
* Given a text file with information:
    ```
    Boston, NewYork
    Philadelphia, Newark
    Newark, Boston
    Trenton, Albany
    ```
* Validates if there is a route between **Boston, NewYork**: Response should be **YES** as path exists between these 2 points

* Validate if unexpected input for ex. **Boston - Albany**: Response should be **NO**.
