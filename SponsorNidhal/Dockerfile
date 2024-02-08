# Utiliser l'image OpenJDK 11 comme base
FROM openjdk:11

# Exposer le port 8085
EXPOSE 8081

# Copier le fichier JAR dans l'image Docker
COPY target/SponsorNidhal-0.0.1-SNAPSHOT.jar Sponsor-docker.jar

# Commande d'entrée pour exécuter l'application
ENTRYPOINT ["java", "-jar", "Sponsor-docker.jar"]