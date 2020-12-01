# Projet d'évaluation pour la formation JAVA

> Projet initialisé via [start.spring.io](https://start.spring.io/) avec les dépendances JPA, MySQL, Spring Web, Spring Boot Dev Tools.

## Note

> Une fois le champ de recherche utilisé, la pagination rentre en conflit avec le name ( bouton / Javascript )

> Les ne sont par rechargé a chaque étape, des couacs peuvent avoir lieu ( ajout suppression affichage ), peux créer des albums orphelins

> Attention, l'étape de suppression d'artiste supprime l'artiste ID 5, utilisé par l'étape suivante : la suppression bloque le lien

## TODO

- [x] Créer le projet
- [x] Versionner le projet
- [x] Créer une branche de travail eval et travailler dedans
- [x] Créer dès que possible la Pull Request sur Github
- [x] Intégrer le dump dans la base de données locale MySQL.
- [x] Utiliser SimpleCorsFilter du TP pour éviter les problèmes de communication entre le front et le back
- [x] Paramétrer le fichier application.properties pour se connecter à la base de données précédemment créée 
- [x] Créer les classes (dans le bon package) permettant de modéliser les objets de l'application et mettre en place le mapping adéquat
- [x] Créer les repository (dans le bon package) permettant d'accéder aux données de la base
- [x] Créer éventuellement un MyRunner (comme dans le TP) pour tester vos repository et s'assurer que la récupération de données se passent bien

### Si vous avez le temps pendant votre eLearning)

- [x] Télécharger le client Web pour l'évaluation : https://github.com/pjvilloud/ipi-mdd-050-eval-web/releases/download/V1.2/ipi-mdd-050-eval-web-v1.2.zip
- [ ] Ajouter les classes nécessaires afin de créer un service web permettant de :
    - [x] Afficher un artiste (gérer les 404)
    - [x] Recherche par nom
    - [x] Liste des artistes avec pagination
    - [x] Création d'un artiste (gestion de l'erreur 409 s'il existe déjà un artiste de même nom)
    - [x] Modification d'un artiste (Méthode PUT avec gestion des 404)
    - [x] Suppression d'un artiste (gérer les 404 et le bon code HTTP de retour, gérer de manière cohérente le cascading...)
    - [x] Ajout d'un album à un artiste (gérer les 404 et les 409 en cas d'album déjà existant).
    - [x] Suppression d'un album (gérer les 404)