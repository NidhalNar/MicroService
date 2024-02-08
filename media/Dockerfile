# Utiliser l'image OpenJDK 11 comme base
FROM openjdk:11

# Exposer le port 8085
EXPOSE 8085

# Copier le fichier JAR dans l'image Docker
COPY target/Media-0.0.1-SNAPSHOT.jar Media-docker.jar

# Commande d'entrée pour exécuter l'application
ENTRYPOINT ["java", "-jar", "Media-docker.jar"]
