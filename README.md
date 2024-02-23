## Consuming-KafkaTopic-with-Camel

Consuming messages from a Kafka topic seamlessly using Apache Camel and Spring Boot. 

#### Installation 
> Ensure you have Kafka installed on your local server

- Run the application then navigate to your API test application of choice e.g - Postman, Insomnia e.t.c
- Test this url as a POST request ```localhost:8080/api/messages```, then add a message in json format, which will be consumed by Camel
- E.g: -
```
 {
  "Messages": "THE WEEKEND HAS STARTED!"
}
```
