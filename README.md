<h1 align="center"> Jumper 👋</h1>

> Jeux de Jumper avec boucle de jeu en JavaFX.

### 🏠 [Homepage](https://github.com/B3njaminV/javafx-mario-game)


## 📍 Prérequis

- JavaFX 11.0
- OpenJFX
- OpenJDK

## ‍💻 Lancement (dans le dossier executable)

- Lancer le script :
```
/executable/Jumper.bat
```
- Lancer la ligne de commande :
```sh
java --module-path /chemin/ver/javafx_sdk/lib --add-modules javafx.fxml,javafx.controls -jar ./javafx-mario-game.jar
```

## ⚙️ Configuration

#### 1 - Ajout variable d'environnement 
```sh
file > settings > apparence > path > ajout 'PATH_TO_JFX_11 = /chemin/openjfx/javafx-sdk/lib'
```

#### 2 - Choix du SDK
```sh
 f4 sur le projet > sdk > openjdk/jdk dossier
```

#### 3 - Ajout des librairies
```sh
f4 sur le projet > librairie > + Java > dossier lib de openjfx-sdk
```

#### 4 - Arborescence du Projet
```sh
f4 sur le projet > modules > définir le répertoire resources comme resources et le répertoire src comme sources.
```

#### 5 - Vérifier le SDK
```sh
f4 sur le projet > Project > version 11 et version language 11 - Local variables ...
```

#### 6 - Ajouter une configuration run

- Add configuration : run
    - modify option > add vm options
        - Dans VM Options : `--module-path ${PATH_TO_JFX_11} --add-modules javafx.fxml,javafx.controls`
    - Dans SDK : `SDK 11 (sdk of javafx-...)`
    - Dans Main.class : `Launch.Launch`


## ✍️ Auteur

👤 **VALLEIX Benjamin**

* Github: [@B3njaminV](https://github.com/B3njaminV)
* LinkedIn: [@Benjamin VALLEIX](https://www.linkedin.com/in/benjamin-valleix-27115719a)

👤 **BONAZ Clément**

* GitLab: [@clbonaz](https://gitlab.iut-clermont.uca.fr/clbonaz)


## 📝 License

Copyright © 2021


## 🛠  Languages

<p> 
    <a href="https://openjfx.io" target="_blank"> 
        <img src="https://www.vectorlogo.zone/logos/java/java-icon.svg" alt="java" width="60" height="60"/> 
    </a> 
	<a href="https://gitlab.com/gitlab-org/gitlab" target="_blank"> 
        <img src="https://www.vectorlogo.zone/logos/gitlab/gitlab-icon.svg" alt="gitlab" width="60" height="60"/> 
    </a> 
</p>
