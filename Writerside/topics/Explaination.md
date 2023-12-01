# Explaination

## Project structure

### Package de base

- package: fr.erazor.project
- path: src/main/java/fr/erazor/project/

Note: fr.erazor.project -> template du projet

### Model

- package: fr.erazor.project.model
- path: src/main/java/fr/erazor/project/model

Note: C'est ici que l'on retrouvera tout nos models dit "Entité"

### Repository

- package: fr.erazor.project.repository
- path: src/main/java/fr/erazor/project/repository

Note: JPA (Java Persist API) Repository

### Service

- package: fr.erazor.project.service
- path: src/main/java/fr/erazor/project/service

Note: Business logic

### Controller

- package: fr.erazor.project.controller
- path: src/main/java/fr/erazor/project/controller

Note: On retrouvera nos endpoints d'API

### DTO

- package: fr.erazor.project.dto
- path: src/main/java/fr/erazor/project/dto

Note: Transfert de nos données entre nos différents layers

### Util

- package: fr.erazor.project.util
- path: src/main/java/fr/erazor/project/util

Note: Pour toutes nos fonctions ou constantes récurrentes

### Exception

- package: fr.erazor.project.exception
- path: src/main/java/fr/erazor/project/exception

Note: Exception & error handling