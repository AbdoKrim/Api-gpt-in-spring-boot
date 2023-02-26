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

