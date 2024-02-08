Documentation du Site de Gestion d'Événements avec Réservations et Sponsors Bienvenue dans la documentation du projet de gestion d'événements avec réservations et sponsors. Ce projet utilise une architecture de microservices avec Spring Boot, Angular, Symfony, MySQL, H2, PostgreSQL, Eureka Server et Client, ainsi qu'une passerelle (Gateway) pour connecter tous les microservices. De plus, le projet est conteneurisé avec Docker et géré avec Docker Compose.

Table des matières Introduction Architecture Microservices Configuration et Exécution Services Service de Sponsors (Spring/H2) Service de Lieux (Spring/SQL) Service d'Événements (Spring/H2) Service de Médias (Spring/SQL) Service de Réservations (Symfony/PostgreSQL) Dockerisation avec Docker Compose Utilisation du Site Problèmes Connus Contributions Remerciements Licence Introduction Le projet de gestion d'événements est conçu pour simplifier la planification, la réservation et la gestion des événements. Chaque événement peut être associé à un ou plusieurs sponsors, et les utilisateurs ont la possibilité de réserver leur participation à un événement.

Architecture Microservices L'architecture du projet est basée sur des microservices interconnectés pour garantir une évolutivité, une flexibilité et une maintenance efficaces. Le schéma ci-dessous illustre l'interaction entre les différents microservices :

Architecture Microservices

Configuration et Exécution Pour configurer et exécuter le projet, veuillez suivre les instructions détaillées dans le README principal.

Services Chaque microservice est responsable d'une fonctionnalité spécifique du système. Vous pouvez consulter la documentation individuelle de chaque service en suivant les liens ci-dessous :

Service de Sponsors (Spring/H2) Service de Lieux (Spring/SQL) Service d'Événements (Spring/H2) Service de Médias (Spring/SQL) Service de Réservations (Symfony/PostgreSQL) Dockerisation avec Docker Compose Le projet est conteneurisé à l'aide de Docker et orchestré avec Docker Compose. Pour déployer l'ensemble du système, suivez les instructions dans le README de Docker Compose.

Utilisation du Site Après le déploiement réussi du système, vous pouvez accéder au site de gestion d'événements en utilisant le navigateur à l'adresse suivante : http://localhost:4200.

Problèmes Connus Consultez la section des problèmes connus dans le README principal pour obtenir des informations sur les problèmes actuellement identifiés et les solutions disponibles.

Contributions Nous accueillons les contributions de la communauté. Consultez le GUIDE DE CONTRIBUTION pour plus d'informations sur la manière de contribuer au projet.

Remerciements Nous remercions tous les contributeurs et les utilisateurs qui ont participé au développement et à l'amélioration de ce projet.

Licence Ce projet est sous licence LICENSE NAME. Consultez le fichier LICENSE pour plus d'informations sur les conditions de licence.

Note: Assurez-vous de remplacer les liens fictifs (lien-vers-image, lien-vers-licence, etc.) par les liens réels et appropriés dans votre documentation. De plus, personnalisez la documentation en fonction des besoins spécifiques de votre projet.
