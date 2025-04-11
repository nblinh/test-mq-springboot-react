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


###############################Requirement#######################################"
### Contexte :
Le département de paiement de la banque est amené à recevoir des messages de la part des applications Back Office via une file IBM MQ Series. Ces messages vont transiter dans une application de routage pour être transférés vers d’autres destinations. Les utilisateurs ont aussi la possibilité d’ajouter des partenaires pour configurer les MQ.
### A réaliser :
Créer une application qui permet :
    `• De lire et de stocker les messages déposés sur une file IBM MQ Series dans une base de données relationnelle
    • D’afficher la liste des messages stockés dans l’IHM sous forme de tableau
    • Pouvoir afficher le détails d’un message quand l’utilisateur clique sur le message dans le tableau. Le détail s’affiche sous forme de popin avec un bouton cancel pour fermer la popin. 
    • D’exposer des API REST pour la consultation des messages via une IHM
    • D’exposer une API REST pour ajouter des partenaires. Pour ajouter un partenaire il faut les informations suivantes : 
        ◦ Alias required
        ◦ Type required
        ◦ Direction deux possibilités INBOUND, OUTBOUND
        ◦ Application champ texte libre
        ◦ Processed Flow Type 3 possibilités MESSAGE ALERTING NOTIFICATION
        ◦ Description required
    • D’ajouter et de supprimer des partenaires MQ côté IHM
    • Côté IHM l’utilisateur a menu de navigation qui contient Messages pour afficher la liste des messages, Partenaires pour accéder à la liste de partenaire et de pouvoir ajouter des partenaires. La liste des partenaires est un tableau aussi avec les propriétés comme nom de colonne.`
Cette application devrait répondre à des contraintes de performance et de résilience étant donnée la volumétrie importante de messages à traiter.
### Environnement technique :
    • Langage : Java 11+
    • Framework Spring Boot 2+
    • Framework Angular 17, Angular Material ou autre comme couche graphique. 
    • Base de données relationnelle : aucune préférence
    • Projet Maven
    • Documentation pour tester l’application
    • Utilisation de docker si possible
    • Pusher le code sur github
### Out of scope :
    • Gestion de l’authentification et des autorisations
