# Spring Boot + MongoDB

## How to start
Install and run MongoDB server locally: [link](https://www.mongodb.com/download-center#community)

```{r, engine='bash', count_lines}
./gradlew build
./gradlew run
curl localhost:9090
```


## CRUD operations

### Get every customer from database:
```
curl http://localhost:9090
```

### Get specific customer from database:
```
curl http://localhost:9090/12345
```

### Delete user from database:
```
curl -H "Content-Type: application/json" -X DELETE -d '{"id": "12345", "firstName": "Abc", "lastName": "Xyz"}' http://localhost:9090
```
or
```
curl -X DELETE http://localhost:9090/12345
```

## Update user:
```
curl -H "Content-Type: application/json" -X PUT -d '{"firstName": "new", "lastName": "lastName"}' http://localhost:9090/12345
```

## Create user:
```
curl -H "Content-Type: application/json" -X POST -d '{"firstName": "myNew", "lastName": "user"}' http://localhost:9090
```

## Config
You can update on which port should the server listen by updating the **server.port** in **application.properties** 