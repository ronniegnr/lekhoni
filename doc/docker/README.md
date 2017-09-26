Intro# Introduction
There is a maven plugin added in the pom.xml and it is working.

# How to build as Docker Image

```java
mvn clean package docker:build
```
Docker will run it in **9229** port.

# Which files are affected?

Several:

- pom.xml
- src/main/docker/Dockerfile
- application.properties

Here,
application.properties has severe changes.

```bash
#----- FOR DOCKER: It Needs a Compose File
spring.datasource.url = jdbc:mysql://${LEKHONI_DB_HOST}/${LEKHONI_DB}
spring.datasource.username = ${LEKHONI_DB_USERNAME}
spring.datasource.password = ${LEKHONI_DB_PASSWORD}
```

To run with new updated application properties, one has to pass database credentials from environment variables.

```bash
export LEKHONI_DB=blognrdb
export LEKHONI_DB_HOST=locahost
export LEKHONI_DB_USERNAME=root
export LEKHONI_DB_PASSWORD=PASSWORD
```
You need a docker compose file to make it much more clear and deployable. There is a docker compose file added in this folder. Make changes to the compose file according to you need.

# How can I deploy with docker compose file?
1. Your should make sure to install *docker* and *docker-compose*.
2. Then `mvn clean package docker:build`, it will make docker image with the build project.
3. Then If you come to this folder and run `docker-compose up -d`, it should run in **9229** port.


