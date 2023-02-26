# homework

## Serveur java simple pour s'interfacer avec ChatGPT. 
#### Pourquoi Spring Boot 
Spring Boot est qu'il permet d'être extraordinairement productif dans la construction de son API : il permet de se concentrer sur la partie métier de son application en laissant de côté toute la complexité de la création d'une API. Spring se basant sur JAVA comme langage de développement, vous êtes toujours libre de réaliser n'importe quel type de développement et n'êtes pas bloqué dans un type de développement spécifique.
  
## Running
En arrière-plan, L’api est utilisée pour interagir avec ChatGPT, qui utilise puppeteer pour générer une fenêtre de navigateur. En d'autres termes, un serveur non headless capable d'afficher une fenêtre de navigateur est nécessaire pour exécuter ce programme.
1.	Exécuter avec l'application Spring Boot
2.	Terminé. Le serveur sert sur localhost:8080
3.	Points de terminaison :
POST /api/send, accepts JSON data containing message to send to {"message": "Hello world"}. Subsequent requests are followed-up by default.
4.	Les questions et les réponses sont enregistrées dans un fichier CSV :
	path : src/main/resources/csv/chat.csv
  
  ![image](https://user-images.githubusercontent.com/104686964/221441715-e135bb3b-3774-4965-9142-e7a473118064.png)
  
  5.	Cas de test :Pour tester ce service, nous utilisons l'outil swagger 
Envoi d'une question au service :
 
La réponse reçue du service :
 

6.	Pour configurer la clé du service ChatGPT modifier le fichier de configuration
public static final String API_KEY = "Bearer " + "your key";


7.	Test de connexion :
Le test de connexion à Internet est un processus qui consiste à vérifier si votre appareil est correctement connecté à Internet et s'il est capable d'envoyer et de recevoir des données d'autres appareils et serveurs sur Internet. Le test consiste généralement à envoyer un signal ou une requête de votre appareil à un autre appareil ou serveur sur internet, puis à recevoir une réponse pour confirmer que le signal a été reçu avec succès.
Dans ce service, s'il y a une mauvaise connexion, voici la réponse :
 

8.       Pour consulter la documentation swagger et tester le service, utilisez le point de terminaison 
http://localhost:8080/swagger-ui.html

9.          Denpendencies :
Pour obtenir les dépendances de ce projet, vous pouvez consulter le fichier pom.xml. 
 Les nouvelles dépendances sont :

<dependency>
   <groupId>org.springdoc</groupId>
   <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
   <version>2.0.0</version>
</dependency>
<dependency>
   <groupId>com.opencsv</groupId>
   <artifactId>opencsv</artifactId>
   <version>5.3</version>
</dependency>
<dependency>
   <groupId>org.apache.commons</groupId>
   <artifactId>commons-csv</artifactId>
   <version>1.8</version>
</dependency>


Partie Testing
la requêtes HTTP «/api/send >>est testé avec Junit et mockMVC 
 
Résulta de Test 
  


