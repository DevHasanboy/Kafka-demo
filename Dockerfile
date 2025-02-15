FROM openjdk:17-jdk-alpine

# Jar faylini konteynerga ko'chirish
COPY target/app-user.jar /app/app-user.jar

# Konteyner ichida "/app" papkasini ishga tushirish
WORKDIR /app

# Spring Boot ilovasini ishga tushirish
ENTRYPOINT ["java", "-jar", "/app/app-user.jar"]
