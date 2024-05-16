# BAR-APP BACK

## Introduction

Ceci est une API Java qui permet de gérer les boissons et les ingrédients d'un bar. Elle a été développée en utilisant Spring Boot.

## Installation

1. Clonez ce dépôt sur votre machine locale.
2. Assurez-vous d'avoir installé Java 8 ou une version ultérieure.
3. Assurez-vous d'avoir installé Maven.
4. Inscrivez votre url de database, et votre username / password dans src/ressources/application.properties: 
    `spring.datasource.url=jdbc:mysql://VOTRE-ADRESSE:VOTRE-PORT/bar-app?createDatabaseIfNotExist=true`
    `spring.datasource.username=VOTRE-USERNAME`
    `spring.datasource.password=VOTRE-PASSWORD`

A partir d'ici, le plus rapide reste d'utiliser IntelliJ IDEA (CE ou Ultimate) et de lancer l'application par ce tier. Sinon:
5. Ouvrez un terminal et naviguez jusqu'au répertoire du projet.
6. Exécutez la commande suivante pour compiler le projet : `mvn clean install`.
7. Exécutez la commande suivante pour démarrer l'application : `java -jar target/bar-app-0.0.1-SNAPSHOT.jar`.

Un systeme de WebSocket est mis en place avec barapp-front. Il est configuré dans src/main/java/WebSocket/WebSocketConfig.java
Assurez-vous de bien autoriser (l.16) votre adresse front : ".setAllowedOrigins("VOTRE_URL_FRONT");" PArdéfaut, il est configuré pour fonctionné sur localhost:5173 (port par défaut de VueJS 3)

Un script.SQL nommé "data.sql" est a votre disposition dans /src/main/ressources/data.sql, il créé une liste d'ingrédient et de catégories

## Utilisation Client

L'API expose en libre accès les points de terminaison suivants :

- `GET api/boisson` : Renvoie une liste de toutes les boissons.
- `GET api/suggestion` : Renvoie une liste des boissons à l'honneur.

- `GET api/categorie` : Renvoie une liste de toutes les catégories.
- `GET api/categorie/liste` : Renvoie une liste de toutes les catégories sous forme allegée.

- `GET api/ingredient` : Renvoie une liste de toutes les ingrédients.
- `GET api/ingredient/liste` : Renvoie une liste de toutes les ingrédients sous forme allegée.

- `GET api/commande` : Renvoie une liste de toutes les commandes (vue client).
- `PUT api/commande` : Créer une commande. (@WebSocket liée sur /socket/admin, renvoie la commande créée)

- `POST api/auth` : Renvoie le token necessairep our les routes sécurisées.

- `PUT api/users/create` : Créer un User.


## Utilisation Admin

Afin d'accéder aux routes sécurisées ci dessous, il va vous falloir créer un USER. Aucune route n'est prévu coté front pour le faire. 
Depuis POSTMAN ou votre logiciel favoris de génération de requete, lancer une requete PUT sur l'endpoint api/users/create avec en body (JSON) : 
`{ 
    "username": "votre-username",
    "password": "votre-password"
}`

Votre mot de passe doit contenir 8 caractères, 1 majuscule, 1 minuscule minimum pour être valide.
Vous devriez avoir la réponse "Création réussi"

Vous pouvez désormais utiliser ces informations de connection pour récupérer votre Token. Vous pouvez le faire depuis e front via la route /admin/login disponible. Si vous souhaitez découvrir l'API independemmant, envoyez une requête POST à l'endpoint "/api/auth" avec le même body ci-dessus.

Vous devriez recevoir en réponse un token. Poru accéder aux routes admin, joignez aux headers de vos requetes `"auth-token" : votre-token`

L'API expose en sécurisées les points de terminaison suivants :
- `POST api/auth/verify-token` : Renvoie la validité du token.
- `POST api/auth/update-token` : Renvoie un nouveau token à partir d'un token bientot expirée.

- `PUT api/admin/boisson`: Ajoute une boisson à la carte
- `PATCH api/admin/boisson`: Mets la boisson en suggestion du jour
- `GET api/admin/boisson/:id`: Renvoie la boisson ciblée
- `DELETE api/admin/boisson/:id`: Supprime la boisson ciblée 

- `PUT api/admin/categorie`: Ajoute une categorie
- `GET api/admin/categorie/:id`: Renvoie la categorie ciblée.
- `DELETE api/admin/categorie/:id`: Supprime la categorie ciblée 

- `PUT api/admin/ingredient`: Ajoute une ingredient
- `GET api/admin/ingredient/:id`: Renvoie l'ingredient ciblé
- `DELETE api/admin/ingredient/:id`: Supprime l'ingredient ciblé

- `GET api/admin/commande`: Renvoie les commandes (vue admin)
- `GET api/admin/commande/:id`: Renvoie la commande ciblée
- `PATCH api/admin/commande`: Mets à jour la commande

## Tests

Pour exécuter les tests, ouvrez un terminal, naviguez jusqu'au répertoire du projet et exécutez la commande suivante : `mvn test` (ceux-ci sont automatiquement effectué lors du mvn clean install).

