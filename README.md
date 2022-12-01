# Projet programmation réseau Java
Avec une architecture hexagonale, réalisé par Sylvain HENQUIN et [Colin DEPELSENAIRE](https://github.com/cocoricodai)

## Introduction
Dans le cadre de notre cours de programmation résau Java, il nous fallait réaliser une application web en java.
Nous avons décidé de réaliser seulement le backend en Java, en faisant sur une API rest.
Pour la partie frontend, nous avons utilisé du JavaScript avec la librairies REACT.JS

## Les conditions imposées
BDD : PostgresSQL

Architecture :
o Adaptateur Web : Contrôleur MVC (Spring Boot)
o Adaptateur de persistance : utilisation de l’ORM JPA (Spring Data JPA)
o Assemblage de l’application : injection de dépendance (@Configuration)

Tests:
o Utilisation de la bibliothèque JUnit pour les tests unitaires
o Utilisation la bibliothèque “mockMvc” pour tester les contrôleurs MVC
o Utilisation de Stub (bibliothèque Mockito)
o Utilisation Testcontainers (Conteneur Docker PostgreSQL)

Outils:
o Améliorer la lisibilité (Lombok)
o Outils de moteur de production (build automation) : Gradle
