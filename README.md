# Projet programmation réseau Java
Avec une architecture hexagonale, réalisé par Sylvain HENQUIN et [Colin DEPELSENAIRE](https://github.com/cocoricodai)

## Introduction
Dans le cadre de notre projet, nous avons développé une application web en utilisant Java pour le backend, avec l'aide de frameworks tels que Spring Boot et JPA pour la gestion de la persistance des données. Nous avons construit une API pour gérer les requêtes HTTP entrantes et transmettre les réponses appropriées aux clients. Pour effectuer des tests sur notre application nous avons utilisé JUnit, MockMvc et Mockito.
Côté Frontend, nous avons utilisé JavaScript et le framework ReactJS pour construire une interface utilisateur interactive et réactive qui communique avec l'API Java pour afficher les données et réaliser des actions. En somme, notre application utilise une architecture basée sur une combinaison de Java pour le Backend et ReactJS pour le Frontend.

## Les conditions imposées
BDD : PostgresSQL

Architecture :
- Adaptateur Web : Contrôleur MVC (Spring Boot)
- Adaptateur de persistance : utilisation de l’ORM JPA (Spring Data JPA)
- Assemblage de l’application : injection de dépendance (@Configuration)

Tests:
- Utilisation de la bibliothèque JUnit pour les tests unitaires
- Utilisation la bibliothèque “mockMvc” pour tester les contrôleurs MVC
- Utilisation de Stub (bibliothèque Mockito)
- Utilisation Testcontainers (Conteneur Docker PostgreSQL)

Outils:
- Améliorer la lisibilité (Lombok)
- Outils de moteur de production (build automation) : Gradle

## Commande avec Docker
```
docker-compose up --build
```

## Configuration du KeyCloack
1. Aller sur : localhost:8081
2. Se connecter avec les identifiants suivants -> login : admin, password : admin
3. Création d'un Realm sous le nom de "Projet API" 
4. Création d'un client au nom de frontendReact.
5. Création de deux rôles : "admin" et "user"
6. Activer User Registration


