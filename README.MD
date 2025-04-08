### Docker Compose support
To test application run `docker-compose up --build`

### Swagger
To test API go to `http://localhost:8080/api/v1/swagger-ui/index.html`

### H2
To connect H2 database go to `http://localhost:8080/api/v1/h2-console/login.jsp`

Driver Class:`org.h2.Driver`

JDBC URL: `jdbc:h2:mem:test`

Username: `sa`

Password: 

### Application angular
To connect to application `http://localhost:4200`

Template css of application come from `https://v17.angular.io/tutorial/tour-of-heroes`

### MQ message
To send mq message using api: `http://localhost:8080/api/v1/swagger-ui/index.html#/mq-message-controller/send`
