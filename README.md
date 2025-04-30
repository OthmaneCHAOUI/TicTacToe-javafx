# Tic Tac Toe JavaFX

Ce projet est un simple **jeu de Tic Tac Toe (morpion)** réalisé avec **JavaFX**, proposant une interface graphique intuitive, stylisée à l’aide d’un fichier **CSS**.

## Contenu du projet

- `Main.java` : Code principal de l'application JavaFX (interface du jeu, logique du tour par tour, gestion des événements).
- `style.css` : Feuille de style appliquée à l’interface pour améliorer l’apparence.

## Fonctionnalités

- **Jeu multijoueur local** : Joueurs X et O s’affrontent sur le même écran.
- **Détection automatique** de victoire ou égalité.
- **Bouton "RESTART"** pour relancer une nouvelle partie.
- **Affichage dynamique** du joueur courant ou du gagnant.
- **Interface simple et responsive** basée sur `GridPane`.

## Technologies utilisées

- Java 17+ (ou version compatible avec JavaFX)
- JavaFX SDK
- CSS pour le style graphique

## Prérequis

- Java Development Kit (JDK) installé.
- JavaFX configuré dans votre environnement de développement.

**Lien utile pour configurer JavaFX :**  
- [Documentation JavaFX](https://openjfx.io/)

## Lancer le projet

1. Assurez-vous d’avoir le JDK et JavaFX installés.
2. Compilez le projet :
   ```bash
   javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml main/Main.java
