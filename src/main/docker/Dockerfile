# LEKHONI BLOG
FROM openjdk:8u141-jdk
MAINTAINER FAHAD AHAMMED "email@fahadahammed.com" www.fahad.space


RUN mkdir blog

ADD *.jar /root/blog/lekhoni.jar

WORKDIR /root/blog/


EXPOSE 9229

CMD ["java", "-Dserver.port=9229", "-jar", "lekhoni.jar"]
