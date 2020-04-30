# **Senior health application**

## Table of contents
* [General info](#general-info)
* [User stories](#user-stories)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
* This project is being created for Programming and DataBases Studies.
* Application is made for older people to control the health results. 
* Created by Antonina Marikhina ([Git Hub repositories](https://github.com/AntoninaMJ)).

## User stories
Application helps people take care of their health.

User can:
* logIn/logOut,
* create, update, delete account,
* add temperature, pressure results,
* view results on chart,
* add a notification,

System do:
* send an email to contact person, if results are bad
* notify the user of new data insertion

## Technologies
* JAVA 8
* Gradle
* Spring Boot (Security, DataJPA, Web)
* REST
* Hibernate

## Setup
To run the App You need to build and run project with gradle wrapper:
```
$ ./gradlew bootRun
```
OR
```
$ ./gradlew build
$ java -jar build/libs/tasks-0.0.1-SNAPSHOT.jar
```
