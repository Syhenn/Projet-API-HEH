# Projet programmation réseau Java
Avec une architecture hexagonale, réalisé par Sylvain HENQUIN et [Colin DEPELSENAIRE](https://github.com/cocoricodai)

## Introduction
Dans le cadre de notre cours de programmation résau Java, il nous fallait réaliser une application web en java.
Nous avons décidé de réaliser seulement le backend en Java, en faisant sur une API rest.
Pour la partie frontend, nous avons utilisé du JavaScript avec la librairies REACT.JS

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

## Les commandes pour faire fonctionner
